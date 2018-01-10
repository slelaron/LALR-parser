import java.util.*;

/**
 * Created by nikita on 07.01.18.
 */
public class State extends SimpleState {
    public Set<Element> getSymbols() {
        return symbols;
    }

    private final Set<Element> symbols;

    State(Rule rule, int position, Collection<Element> symbols) {
        super(rule, position);
        this.symbols = new HashSet<>(symbols);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("<");
        builder.append(super.toString());
        builder.append("|{");
        Iterator<Element> iter = symbols.iterator();
        while (iter.hasNext()) {
            builder.append(iter.next());
            if (iter.hasNext()) {
                builder.append(",");
            }
        }
        builder.append("}>");
        return builder.toString();
    }

    public Element get() {
        return rule.get(position);
    }

    public int hashCode() {
        return Arrays.asList(rule, position, symbols).hashCode();
    }

    public SimpleState simplify() {
        return new SimpleState(this, rule, position);
    }

    public boolean equals(Object object) {
        if (object instanceof State) {
            State now = (State)object;
            return now.rule.equals(rule) && now.position == position && now.getSymbols().equals(symbols);
        }
        return false;
    }

    public boolean concatenate(State another) {
        return simplify().equals(another.simplify()) && symbols.addAll(another.getSymbols());
    }
}
