import java.util.List;

/**
 * Created by nikita on 07.01.18.
 */
public interface Element {
    boolean isNonTerminal();
    String getName();
    String toString();
    boolean isSkippable();
    void applyOperation(List<Element> elements);
    String getString();
    Object get(int index);
    String getObjectsTypes();
}
