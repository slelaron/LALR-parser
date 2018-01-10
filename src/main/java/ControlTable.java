import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by nikita on 07.01.18.
 */
public class ControlTable {
    private final List<Rule> initial;
    private final Map<? extends Element, List<Rule>> rules;
    private final NonTerminal curStart;
    private final SuperState<State> startSuperState;
    private final Rule startRule;
    private final FirstCounter firstCounter;
    private final Map<SuperState<SimpleState>, Map<Element, ShiftReduce>> table = new HashMap<>();
    private final Map<SuperState<SimpleState>, SuperState<State>> simpleToNormal = new HashMap<>();
    public final static Function<SuperState<State>, SuperState<SimpleState>> normalToSimple =
            a -> new SuperState<>(a.getStates().stream().map(State::simplify).collect(Collectors.toList()));

    private void closureRule(SuperState<State> superState) {
        Set<State> stateSet = new HashSet<>();
        Map<SimpleState, State> simpleToNormal = new HashMap<>();
        Queue<State> epsQueue = new ArrayDeque<>();

        epsQueue.addAll(superState.getStates());
        while (!epsQueue.isEmpty()) {
            State state = epsQueue.poll();
            if (simpleToNormal.containsKey(state.simplify())) {
                State cur = simpleToNormal.get(state.simplify());
                stateSet.remove(cur);
                cur.concatenate(state);
                stateSet.add(cur);
            } else {
                stateSet.add(state);
                simpleToNormal.put(state.simplify(), state);
            }
            if (state.getRule().getRight().size() > state.getPosition()) {
                Element element = state.get();
                if (element.isNonTerminal()) {

                    List<Element> rightSide = state.getRule().getRight();
                    List<Element> toGetFirst = rightSide.subList(state.getPosition() + 1, rightSide.size());
                    Set<Element> set = firstCounter.getFirst(toGetFirst);
                    FirstCounter.replaceEpsilon(set, state.getSymbols());

                    epsQueue.addAll(rules.get(element).stream().
                            map(rule -> new State(rule, 0, set)).
                            filter(a -> !simpleToNormal.containsKey(a.simplify())).
                            collect(Collectors.toList()));
                    rules.get(element).stream().
                            map(rule -> new State(rule, 0, set)).
                            filter(a -> simpleToNormal.containsKey(a.simplify()) && !stateSet.contains(a)).
                            forEach(a -> {
                                State cur = simpleToNormal.get(a.simplify());
                                stateSet.remove(cur);
                                cur.concatenate(a);
                                stateSet.add(cur);
                            });
                }
            }
        }
        superState.setStates(stateSet);
    }

    private void createControlTable() throws GeneratorException {
        Queue<SuperState<State>> queue = new ArrayDeque<>();
        closureRule(startSuperState);
        queue.add(startSuperState);
        while (!queue.isEmpty()) {
            SuperState<State> superState = queue.poll();
            Map<Element, List<State>> shift = new HashMap<>();
            Map<Element, State> reduce = new HashMap<>();
            for (State state: superState.getStates()) {
                if (state.getRule().getRight().size() == state.getPosition()) {
                    for (Element element: state.getSymbols()) {
                        if (reduce.containsKey(element)) {
                            throw new GeneratorException("Different ways to reduce");
                        }
                        reduce.put(element, state);
                    }
                } else {
                    if (!shift.containsKey(state.get())) {
                        shift.put(state.get(), new ArrayList<>());
                    }
                    shift.get(state.get()).add(new State(state.getRule(), state.getPosition() + 1, state.getSymbols()));
                }
            }
            if (!Collections.disjoint(shift.keySet(), reduce.keySet())) {
                throw new GeneratorException("Can't determine: to reduce or to shift");
            }
            Map <Element, ShiftReduce> row = new HashMap<>();
            for (Map.Entry<Element, List<State>> entry: shift.entrySet()) {
                SuperState<State> have = new SuperState<>(entry.getValue());
                closureRule(have);
                SuperState<SimpleState> simpleHave = normalToSimple.apply(have);
                if (table.containsKey(simpleHave)) {
                    boolean truth = false;
                    Iterator<State> iter1 = normalToSimple.apply(simpleToNormal.get(simpleHave)).getStates().stream().map(SimpleState::getParent).iterator();
                    Iterator<State> iter2 = simpleHave.getStates().stream().map(SimpleState::getParent).iterator();
                    while (iter1.hasNext() && iter2.hasNext()) {
                        State first = iter1.next();
                        State second = iter2.next();
                        truth |= first.concatenate(second);
                    }
                    if (truth) {
                        queue.add(simpleToNormal.get(simpleHave));
                    }
                } else {
                    queue.add(have);
                }
                row.put(entry.getKey(), new ShiftReduce(simpleHave));
            }
            for (Map.Entry<Element, State> entry: reduce.entrySet()) {
                row.put(entry.getKey(), new ShiftReduce(entry.getValue().getRule()));
            }
            table.put(normalToSimple.apply(superState), row);
            simpleToNormal.put(normalToSimple.apply(superState), superState);
        }
    }

    public class Wrapper<T, E> {
        public String getTable() {
            return table;
        }

        public List<T> getElements() {
            return elements;
        }

        public List<E> getSuperStates() {
            return superStates;
        }

        public int[][] getInitTable() {
            return initTable;
        }

        private final String table;
        private final List<T> elements;
        private final List<E> superStates;
        private final int[][] initTable;

        Wrapper(String table, List<T> elements, List<E> superStates, int[][] initTable) {
            this.table = table;
            this.elements = elements;
            this.superStates = superStates;
            this.initTable = initTable;
        }
    }

    Wrapper<Element, SuperState<State>> getTable() {
        Map<Element, Integer> allElements = new HashMap<>();
        Map<SuperState<SimpleState>, Integer> allSuperStates = new HashMap<>();
        Map<Rule, Integer> allRules = new HashMap<>();
        allElements.put(Terminal.EXIT, 0);
        int counter = 1;
        for (Rule rule: initial) {
            if (!allElements.containsKey(rule.getLeft())) {
                if (!rule.getLeft().equals(startRule.getLeft())) {
                    allElements.put(rule.getLeft(), counter++);
                }
            }
            for (Element element : rule.getRight()) {
                if (!allElements.containsKey(element)) {
                    allElements.put(element, counter++);
                }
            }
        }
        int columnSize = counter;
        counter = 1;
        allSuperStates.put(normalToSimple.apply(startSuperState), 0);
        for (Map.Entry<SuperState<SimpleState>, Map<Element, ShiftReduce>> entry: table.entrySet()) {
            if (!allSuperStates.containsKey(entry.getKey())) {
                allSuperStates.put(entry.getKey(), counter++);
            }
        }
        int rowSize = counter;
        counter = 0;
        for (Rule rule: initial) {
            if (!allRules.containsKey(rule)) {
                allRules.put(rule, counter++);
            }
        }

        int[][] need = new int[rowSize][columnSize];

        for (Map.Entry<SuperState<SimpleState>, Map<Element, ShiftReduce>> entry: table.entrySet()) {
            int row = allSuperStates.get(entry.getKey());
            for (Map.Entry<Element, ShiftReduce> internal: entry.getValue().entrySet()) {
                int column = allElements.get(internal.getKey());
                if (internal.getValue().isReduce()) {
                    need[row][column] = -(allRules.get(internal.getValue().getRule()) + 1);
                } else {
                    need[row][column] = allSuperStates.get(internal.getValue().getSuperState()) + 1;
                }
            }
        }

        List<Element> toReturnElements = new ArrayList<>(columnSize);
        for (int i = 0; i < columnSize; i++) {
            toReturnElements.add(null);
        }
        allElements.entrySet().stream().forEach(entry -> toReturnElements.set(entry.getValue(), entry.getKey()));

        List<SuperState<State>> toReturnSuperState = new ArrayList<>(rowSize);
        for (int i = 0; i < rowSize; i++) {
            toReturnSuperState.add(null);
        }
        allSuperStates.entrySet().stream().forEach(entry -> toReturnSuperState.set(entry.getValue(), simpleToNormal.get(entry.getKey())));

        return new Wrapper<>(Arrays.deepToString(need).replace('[', '{').replace(']', '}'), toReturnElements, toReturnSuperState, need);
    }

    ControlTable(NonTerminal start, List<Rule> rules) throws GeneratorException {
        initial = new ArrayList<>();
        curStart = new NonTerminal(Terminal.getName("Start"));
        startRule = new Rule(curStart, Collections.singletonList(start));
        initial.add(startRule);
        initial.addAll(rules);
        firstCounter = new FirstCounter(rules);
        HashMap<NonTerminal, List<Rule>> hashMap = new HashMap<>();
        for (Rule rule: rules) {
            if (!hashMap.containsKey(rule.getLeft())) {
                hashMap.put(rule.getLeft(), new ArrayList<>());
            }
            hashMap.get(rule.getLeft()).add(rule);
        }

        this.rules = hashMap;
        startSuperState = new SuperState<>(Collections.singletonList(new State(startRule, 0, Collections.singletonList(Terminal.EXIT))));
        createControlTable();
    }
}
