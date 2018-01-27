import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nikita on 07.01.18.
 */
public class Terminal implements Element {
    public Pattern getPattern() {
        return pattern;
    }

    public String addString(String remaining) {
        Matcher matcher = pattern.matcher(remaining);
        if (matcher.lookingAt()) {
            int start = matcher.start();
            int end = matcher.end();
            string = remaining.substring(start, end);
            return remaining.substring(end);
        }
        return remaining;
    }

    private final String naming;
    private final Pattern pattern;
    private String string;
    private final boolean skippable;

    public boolean isNonTerminal() {
        return false;
    }
    Terminal(String naming, String regexp, boolean skippable) {
        this.naming = naming;
        this.pattern = Pattern.compile(regexp);
        this.skippable = skippable;
    }

    private Terminal(String naming, Pattern pattern, boolean skippable) {
        this.naming = naming;
        this.pattern = pattern;
        this.skippable = skippable;
    }

    public static String generateName(String prefix) {
        final Random random = new Random();
        return prefix + "_" + Math.abs(random.nextLong());
    }

    public static final Terminal EPSILON = new Terminal("~_7911745207894147684", "", true);
    public static final Terminal EXIT = new Terminal("$_6207967798290200467", "^$", false);

    public int hashCode() {
        return naming.hashCode();
    }

    public boolean equals(Object object) {
        return object instanceof Terminal && ((Terminal) object).naming.equals(naming);
    }

    public Terminal copy() {
        return new Terminal(naming, pattern, skippable);
    }

    public String toString() {
        String toReturn = naming.substring(0, naming.indexOf('_') == -1 ? naming.length() : naming.indexOf('_'));
        if (string != null) {
            return toReturn + '[' + string + ']';
        } else {
            return toReturn;
        }
    }

    public String getName() {
        return naming;
    }

    public String getString() {
        return string;
    }

    public boolean isSkippable() {
        return skippable;
    }

    public void applyOperation(List<Element> elements) {}

    public Object get(int index) {
        if (index == 0) {
            return new Wrapper<>(string);
        } else {
            throw new NoSuchElementException();
        }
    }

    public String getObjectsTypes() {
        return "Wrapper<java.lang.String>";
    }
}
