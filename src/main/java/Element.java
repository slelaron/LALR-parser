/**
 * Created by nikita on 07.01.18.
 */
public interface Element {
    boolean isNonTerminal();
    String getName();
    String toString();
    boolean isSkippable();
}
