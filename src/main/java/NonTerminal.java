import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

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
    public String getString() {
        return ((Wrapper<String>)objects.get(0)).object;
    }

    private final String naming;
    private final List<Element> children = new ArrayList<>();
    private final List<Object> objects = new ArrayList<>();
    private final BiConsumer<List<Object>, List<Element>> function;
    private final int border;

    public boolean isNonTerminal() {
        return true;
    }

    NonTerminal(String naming) {
        this.naming = naming;
        this.border = 0;
        this.objects.add(new Wrapper<>(""));
        this.function = (a, b) -> {};
    }

    NonTerminal(String naming, int border) {
        this.naming = naming;
        this.objects.add(new Wrapper<>(""));
        this.function = (a, b) -> {};
        this.border = border;
    }

    NonTerminal(String naming, BiConsumer<List<Object>, List<Element>> function, int border) {
        this.naming = naming;
        this.objects.add(new Wrapper<>(""));
        this.function = function;
        this.border = border;
    }

    public int hashCode() {
        return naming.hashCode();
    }

    public boolean equals(Object object) {
        return object instanceof NonTerminal && ((NonTerminal)object).naming.equals(naming);
    }

    public void addChildren(List<Element> elements) {
        StringBuilder builder = new StringBuilder();
        builder.append(((Wrapper<String>)objects.get(0)).object);
        elements.forEach(a -> builder.append(a.getString()));
        objects.set(0, new Wrapper<>(builder.toString()));
        children.addAll(elements);
        for (int i = 1; i < border + 1; i++) {
            objects.add(elements.get(0).get(i));
        }
    }

    NonTerminal copy() {
        return new NonTerminal(this.naming, this.function, this.border);
    }

    public boolean isSkippable() {
        return false;
    }

    public Object get(int index) {
        return objects.get(index);
    }

    public String getObjectsTypes() {
        StringBuilder builder = new StringBuilder();
        for (Object object: objects) {
            builder.append(object.getClass().getTypeName()).append("<").append((((Wrapper) object).object == null) ? null : ((Wrapper) object).object.getClass().getTypeName()).append("> ");
        }
        return builder.toString();
    }

    public void applyOperation(List<Element> elements) {
        function.accept(objects, elements);
    }
}
