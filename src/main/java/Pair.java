import java.util.Arrays;

/**
 * Created by nikita on 25.01.18.
 */
public class Pair<E, T> {
    private final E firstEl;
    private final T secondEl;

    Pair(E firstEl, T secondEl) {
        this.firstEl = firstEl;
        this.secondEl = secondEl;
    }

    public E first() {
        return firstEl;
    }

    public T second() {
        return secondEl;
    }

    public int hashCode() {
        return Arrays.asList(firstEl, secondEl).hashCode();
    }

    public boolean equals(Object object) {
        if (object instanceof Pair) {
            Pair pair = (Pair)object;
            return pair.first().equals(firstEl) && pair.second().equals(secondEl);
        }
        return false;
    }

    public String toString() {
        return "[" + firstEl + " " + secondEl + ']';
    }
}