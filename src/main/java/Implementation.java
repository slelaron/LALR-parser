import java.util.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Collectors;
@SuppressWarnings("unchecked")
public class Implementation {

    public static void main(String[] ___args) throws IOException {
        byte[] ___encoded = Files.readAllBytes(Paths.get("Input"));
        String ___content = new String(___encoded, "UTF-8");
        NonTerminal start = new NonTerminal("start", (___objects, ___elements) -> {}, 0);
        NonTerminal MARKER_7199386389309953282 = new NonTerminal("MARKER_7199386389309953282", (___objects, ___elements) -> {___objects.add(new Wrapper<>(((Wrapper<Integer>)___elements.get(___elements.size() - 1).get(1)).object));}, 0);
        NonTerminal ATTRIBUTE_3183407250562072484 = new NonTerminal("ATTRIBUTE_3183407250562072484", (___objects, ___elements) -> {System.err.println(((Wrapper<String>)___elements.get(___elements.size() - 3).get(0)).object + ((Wrapper<String>)___elements.get(___elements.size() - 1).get(0)).object + "=" + ((Wrapper<Integer>)___elements.get(___elements.size() - 1).get(1)).object);}, 0);
        NonTerminal LOCALS_3981085472975619037 = new NonTerminal("LOCALS_3981085472975619037", (___objects, ___elements) -> {___objects.add(new Wrapper<Integer>());___objects.add(new Wrapper<Integer>());}, 0);
        NonTerminal another = new NonTerminal("another", (___objects, ___elements) -> {}, 1);
        NonTerminal ATTRIBUTE_5191922267991436204 = new NonTerminal("ATTRIBUTE_5191922267991436204", (___objects, ___elements) -> {((Wrapper<Integer>)___elements.get(___elements.size() - 3).get(2)).object = ((Wrapper<Integer>)___elements.get(___elements.size() - 1).get(1)).object + ((Wrapper<Integer>)___elements.get(___elements.size() - 4).get(1)).object;}, 0);
        NonTerminal MARKER_4061208818266393127 = new NonTerminal("MARKER_4061208818266393127", (___objects, ___elements) -> {___objects.add(new Wrapper<>(((Wrapper<Integer>)___elements.get(___elements.size() - 4).get(2)).object));}, 0);
        NonTerminal ATTRIBUTE_145026931330863882 = new NonTerminal("ATTRIBUTE_145026931330863882", (___objects, ___elements) -> {((Wrapper<Integer>)___elements.get(___elements.size() - 6).get(1)).object = ((Wrapper<Integer>)___elements.get(___elements.size() - 1).get(1)).object;}, 0);
        NonTerminal ATTRIBUTE_550873239580309384 = new NonTerminal("ATTRIBUTE_550873239580309384", (___objects, ___elements) -> {((Wrapper<Integer>)___elements.get(___elements.size() - 1).get(1)).object = ((Wrapper<Integer>)___elements.get(___elements.size() - 2).get(1)).object;}, 0);
        NonTerminal LOCALS_6176492176687352993 = new NonTerminal("LOCALS_6176492176687352993", (___objects, ___elements) -> {___objects.add(new Wrapper<Integer>());}, 0);
        NonTerminal number = new NonTerminal("number", (___objects, ___elements) -> {}, 1);
        NonTerminal ATTRIBUTE_3329692143317404214 = new NonTerminal("ATTRIBUTE_3329692143317404214", (___objects, ___elements) -> {((Wrapper<Integer>)___elements.get(___elements.size() - 3).get(1)).object = -Integer.parseInt(((Wrapper<String>)___elements.get(___elements.size() - 1).get(0)).object);}, 0);
        NonTerminal ATTRIBUTE_2574221823836680835 = new NonTerminal("ATTRIBUTE_2574221823836680835", (___objects, ___elements) -> {((Wrapper<Integer>)___elements.get(___elements.size() - 2).get(1)).object = Integer.parseInt(((Wrapper<String>)___elements.get(___elements.size() - 1).get(0)).object);}, 0);
        Terminal NUMBER = new Terminal("NUMBER", "([1-9][0-9]*)|0", false);
        Terminal WS = new Terminal("WS", "[ \n\t]", true);
        Terminal PRODUCED_4285644843195397254 = new Terminal("\\+", "\\+", false);
        Terminal PRODUCED_7436389799766192726 = new Terminal("-", "-", false);
        List<Rule> ___rules = new ArrayList<>();
        int[][] ___table = new int[][] {{0, 5, 0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 11, 0, -12, -12, 0}, {-15, 0, 0, 0, 0, 0, 0, 0, 0, 0, -15, 0, 0, 0, 0, 0, 17}, {-4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {-5, 0, 0, 0, 0, 13, 16, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0}, {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {-9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18, 0}, {0, 0, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 11, 0, -12, -12, 0}, {-5, 0, 0, 0, 0, 10, 16, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0}, {-8, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 2, 0}, {-7, 0, 0, 0, 0, 0, 0, 0, 9, 0, -7, 0, 0, 0, 0, 0, 0}, {-3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {-11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {-2, 0, 4, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0}, {-10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 14, 0, 0, 0, 0, 0}, {-16, 0, 0, 0, 0, 0, 0, 0, 0, 0, -16, 0, 0, 0, 0, 0, 0}, {-13, 0, 0, 0, 0, 0, 0, 0, 0, 0, -13, 0, 0, 19, 0, 0, 0}, {-14, 0, 0, 0, 0, 0, 0, 0, 0, 0, -14, 0, 0, 0, 0, 0, 0}, {-6, 0, 0, 0, 0, 0, 0, 12, 0, 0, -6, 0, 0, 0, 0, 0, 0}};
        String[] ___names = new String[] {"$_6207967798290200467", "start", "MARKER_7199386389309953282", "ATTRIBUTE_3183407250562072484", "number", "another", "LOCALS_3981085472975619037", "ATTRIBUTE_5191922267991436204", "MARKER_4061208818266393127", "ATTRIBUTE_145026931330863882", "\\+", "ATTRIBUTE_550873239580309384", "LOCALS_6176492176687352993", "ATTRIBUTE_3329692143317404214", "-", "NUMBER", "ATTRIBUTE_2574221823836680835"};
        ___rules.add(new Rule(MARKER_7199386389309953282, Collections.emptyList()));
        ___rules.add(new Rule(ATTRIBUTE_3183407250562072484, Collections.emptyList()));
        ___rules.add(new Rule(start, Arrays.asList(number, MARKER_7199386389309953282, another, ATTRIBUTE_3183407250562072484)));
        ___rules.add(new Rule(LOCALS_3981085472975619037, Collections.emptyList()));
        ___rules.add(new Rule(ATTRIBUTE_5191922267991436204, Collections.emptyList()));
        ___rules.add(new Rule(MARKER_4061208818266393127, Collections.emptyList()));
        ___rules.add(new Rule(ATTRIBUTE_145026931330863882, Collections.emptyList()));
        ___rules.add(new Rule(another, Arrays.asList(LOCALS_3981085472975619037, PRODUCED_4285644843195397254, number, ATTRIBUTE_5191922267991436204, MARKER_4061208818266393127, another, ATTRIBUTE_145026931330863882)));
        ___rules.add(new Rule(ATTRIBUTE_550873239580309384, Collections.emptyList()));
        ___rules.add(new Rule(another, Arrays.asList(LOCALS_3981085472975619037, ATTRIBUTE_550873239580309384)));
        ___rules.add(new Rule(LOCALS_6176492176687352993, Collections.emptyList()));
        ___rules.add(new Rule(ATTRIBUTE_3329692143317404214, Collections.emptyList()));
        ___rules.add(new Rule(number, Arrays.asList(LOCALS_6176492176687352993, PRODUCED_7436389799766192726, NUMBER, ATTRIBUTE_3329692143317404214)));
        ___rules.add(new Rule(ATTRIBUTE_2574221823836680835, Collections.emptyList()));
        ___rules.add(new Rule(number, Arrays.asList(LOCALS_6176492176687352993, NUMBER, ATTRIBUTE_2574221823836680835)));
        List<Terminal> ___terminals = Arrays.asList(PRODUCED_4285644843195397254, PRODUCED_7436389799766192726, NUMBER, WS);

        try {
            Element ___element = TreeBuilder.build(___table, ___names, ___terminals, ___rules, ___content);
            System.out.println(___element);
        } catch (TokenizerException | ParserException ___ex) {
            ___ex.printStackTrace();
        }
    }
}
