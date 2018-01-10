import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nikita on 07.01.18.
 */
public class NonTerminal implements Element {
    public String toString() {
        String toReturn = naming.substring(0, naming.indexOf('_') == -1 ? naming.length() : naming.indexOf('_'));
        if (children.size() == 0) {
            return toReturn;
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append(toReturn);
            builder.append('[');
            for (int i = 0; i < children.size(); i++) {
                builder.append(children.get(i));
                if (i != children.size() - 1) {
                    builder.append(", ");
                }
            }
            builder.append(']');
            return builder.toString();
        }
    }

    public String getName() {
        return naming;
    }

    private final String naming;
    private final List<Element> children;

    public boolean isNonTerminal() {
        return true;
    }

    NonTerminal(String naming) {
        this.naming = naming;
        this.children = new ArrayList<>();
    }

    public int hashCode() {
        return naming.hashCode();
    }

    public boolean equals(Object object) {
        return object instanceof NonTerminal && ((NonTerminal)object).naming.equals(naming);
    }

    public void addChildren(Element... elements) {
        children.addAll(Arrays.asList(elements));
    }

    NonTerminal copy() {
        return new NonTerminal(this.naming);
    }

    public boolean isSkippable() {
        return false;
    }
}
