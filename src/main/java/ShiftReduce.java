/**
 * Created by nikita on 08.01.18.
 */
public class ShiftReduce {
    private SuperState<SimpleState> superState;
    private Rule rule;
    private final boolean isSuperState;

    ShiftReduce(SuperState<SimpleState> superState) {
        this.superState = superState;
        this.isSuperState = true;
    }
    ShiftReduce(Rule rule) {
        this.rule = rule;
        this.isSuperState = false;
    }

    SuperState<SimpleState> getSuperState() {
        return superState;
    }

    Rule getRule() {
        return rule;
    }

    boolean isShift() {
        return isSuperState;
    }

    boolean isReduce() {
        return !isSuperState;
    }
}
