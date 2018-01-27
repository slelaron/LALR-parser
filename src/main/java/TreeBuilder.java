import java.util.*;

/**
 * Created by nikita on 09.01.18.
 */
public class TreeBuilder {
    public static Element build(int[][] table, String[] names, List<Terminal> terminals, List<Rule> rules, String input) throws ParserException, TokenizerException {
        Deque<Element> tokens = new ArrayDeque<>();
        List<Terminal> tokenList = Tokenizer.tokenize(terminals, input);
        tokens.addAll(tokenList);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], i);
        }
        List<Element> stack = new ArrayList<>();
        int pointer = 0;
        Deque<Integer> states = new ArrayDeque<>();
        states.add(0);
        boolean good = false;
        while (!tokens.isEmpty()) {
            while (tokens.peek().isSkippable()) {
                tokens.pop();
            }
            int curSymbol;
            try {
                curSymbol = map.get(tokens.peek().getName());
            } catch (NullPointerException e) {
                throw new ParserException("Met token, that doesn't meet in rules" + tokens.peek().getName());
            }
            int next = table[states.peek()][curSymbol];
            if (next == 0) {
                throw new ParserException("No suitable way to go " + tokens);
            }
            if (next < 0) {
                if (next == -1) {
                    if (tokens.size() > 1) {
                        throw new ParserException("No suitable way to go");
                    } else {
                        good = true;
                        break;
                    }
                }
                int cur = -next - 2;
                NonTerminal nonTerminal = rules.get(cur).getLeft().copy();
                List<Element> children = new ArrayList<>();
                for (int i = 0; i < rules.get(cur).getRight().size(); i++) {
                    children.add(stack.get(pointer - 1));
                    pointer--;
                    states.pop();
                }
                Collections.reverse(children);
                nonTerminal.addChildren(children);
                tokens.push(nonTerminal);
            }
            if (next > 0) {
                int cur = next - 1;
                Element element = tokens.pop();
                element.applyOperation(stack.subList(0, pointer));
                if (pointer == stack.size()) {
                    stack.add(element);
                } else {
                    stack.set(pointer, element);
                }
                pointer++;
                states.push(cur);
            }
        }
        if (!good) {
            throw new ParserException("Can't create tree");
        }
        assert(pointer == 1);
        return stack.get(pointer - 1);
    }
}
