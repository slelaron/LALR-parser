import java.util.Arrays;

/**
 * Created by nikita on 09.01.18.
 */
public class SimpleState {
    public Rule getRule() {
        return rule;
    }

    public int getPosition() {
        return position;
    }

    protected final Rule rule;
    protected final int position;
    private final State parent;

    public State getParent() {
        return parent;
    }

    SimpleState(Rule rule, int position) {
        this.rule = rule;
        this.position = position;
        this.parent = null;
    }

    protected SimpleState(State state, Rule rule, int position) {
        this.rule = rule;
        this.position = position;
        this.parent = state;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(rule.getLeft());
        builder.append("->");
        for (int i = 0; i < rule.getRight().size(); i++) {
            if (i == position) {
                builder.append('.');
            }
            builder.append(rule.getRight().get(i));
            if (i != rule.getRight().size() - 1) {
                builder.append(" ");
            }
        }
        if (position == rule.getRight().size()) {
            builder.append('.');
        }
        return builder.toString();
    }

    public int hashCode() {
        return Arrays.asList(rule, position).hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof SimpleState) {
            SimpleState state = (SimpleState)object;
            return state.position == position && state.rule.equals(rule);
        }
        return false;
    }

    public SimpleState simplify() {
        return new SimpleState(rule, position);
    }

    public boolean concatenate(State another) {
        return false;
    }
}
