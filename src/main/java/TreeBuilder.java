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
        Deque<Element> stack = new ArrayDeque<>();
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
                throw new ParserException("No suitable way to go");
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
                    children.add(stack.pop());
                    states.pop();
                }
                Collections.reverse(children);
                children.forEach(nonTerminal::addChildren);
                tokens.push(nonTerminal);
            }
            if (next > 0) {
                int cur = next - 1;
                stack.push(tokens.pop());
                states.push(cur);
            }
        }
        if (!good) {
            throw new ParserException("Can't create tree");
        }
        assert(stack.size() == 1);
        return stack.pop();
    }
}
