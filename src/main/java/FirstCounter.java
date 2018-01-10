import java.util.*;

/**
 * Created by nikita on 08.01.18.
 */
public class FirstCounter {
    private final List<Rule> rules;
    private final Map<Element, Set<Element>> first;

    FirstCounter(List<Rule> rules) {
        this.rules = rules;
        this.first = new HashMap<>();
        countFirst();
    }

    public Set<Element> getFirst(List<Element> elements) {
        if (elements.isEmpty()) {
            Set <Element> set = new HashSet<>();
            set.add(Terminal.EPSILON);
            return set;
        } else if (!elements.get(0).isNonTerminal()) {
            Set <Element> set = new HashSet<>();
            set.add(elements.get(0));
            return set;
        } else  {
            Set<Element> set = new HashSet<>();
            if (!first.containsKey(elements.get(0))) {
                first.put(elements.get(0), new HashSet<>());
            }
            set.addAll(first.get(elements.get(0)));
            set.remove(Terminal.EPSILON);
            if (first.get(elements.get(0)).contains(Terminal.EPSILON)) {
                set.addAll(getFirst(elements.subList(1, elements.size())));
            }
            return set;
        }
    }

    private void countFirst() {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (Rule rule: rules) {
                if (!first.containsKey(rule.getLeft())) {
                    first.put(rule.getLeft(), new HashSet<>());
                }
                int size = first.get(rule.getLeft()).size();
                first.get(rule.getLeft()).addAll(getFirst(rule.getRight()));
                if (size != first.get(rule.getLeft()).size()) {
                    changed = true;
                }
            }
        }
    }

    public static void replaceEpsilon(Set<Element> init, Set<Element> replacement) {
        if (init.remove(Terminal.EPSILON)) {
            init.addAll(replacement);
        }
    }
}
