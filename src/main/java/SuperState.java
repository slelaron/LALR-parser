import java.util.*;

/**
 * Created by nikita on 07.01.18.
 */
public class SuperState<T extends SimpleState> {
    public Set<T> getStates() {
        return states;
    }

    public void setStates(Collection<T> states) {
        adding(states);
    }

    private void adding(Collection<T> states) {
        this.states = new HashSet<>(states);
    }

    private Set<T> states;

    SuperState() {}
    SuperState(Collection<T> states) {
        adding(states);
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T state: states) {
            builder.append(state);
            builder.append(" ");
        }
        return builder.toString();
    }

    public int hashCode() {
        return states.hashCode();
    }

    public boolean equals(Object object) {
        return object instanceof SuperState && states.equals(((SuperState) object).getStates());
    }
}
