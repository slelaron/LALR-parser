import java.util.Arrays;
import java.util.List;

/**
 * Created by nikita on 07.01.18.
 */
public class Rule {
    private final NonTerminal left;
    private final List<Element> right;

    public NonTerminal getLeft() {
        return left;
    }

    public List<Element> getRight() {
        return right;
    }

    public Element get(int position) {
        return right.get(position);
    }

    Rule(NonTerminal left, List<Element> right) {
        this.left = left;
        this.right = right;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(left);
        builder.append("->");
        right.stream().forEach(builder::append);
        return builder.toString();
    }

    public int hashCode() {
        return Arrays.asList(left, right).hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof Rule) {
            Rule rule = (Rule)object;
            return rule.getLeft().equals(left) && rule.getRight().equals(right);
        }
        return false;
    }
}
