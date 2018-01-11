import java.util.*;
import java.io.IOException;
import java.nio.file.*;
public class Implementation {
    public static void main(String[] ______args) throws IOException {
        byte[] ______encoded = Files.readAllBytes(Paths.get("Input"));
        String ______content = new String(______encoded, "UTF-8");
        Terminal PRODUCED_3294857353687057909 = new Terminal(",", ",", false);
        Terminal WORD = new Terminal("WORD", "(var[a-zA-z]|va[a-zA-Z&&[^r]]|v[a-zA-Z&&[^a]]|[a-zA-Z&&[^v]])[a-zA-Z]*", false);
        NonTerminal start = new NonTerminal("start");
        NonTerminal groupRest = new NonTerminal("groupRest");
        NonTerminal namesRest = new NonTerminal("namesRest");
        NonTerminal type = new NonTerminal("type");
        Terminal PRODUCED_932931441864510178 = new Terminal(";", ";", false);
        NonTerminal names = new NonTerminal("names");
        Terminal PRODUCED_4250632841794966363 = new Terminal(":", ":", false);
        NonTerminal name = new NonTerminal("name");
        Terminal PRODUCED_2113217886100251284 = new Terminal("var", "var", false);
        NonTerminal vars = new NonTerminal("vars");
        Terminal WS = new Terminal("WS", "[ \n\t]+", true);
        NonTerminal group = new NonTerminal("group");
        List<Rule> ______rules = new ArrayList<>();
        ______rules.add(new Rule(start, Arrays.asList(PRODUCED_2113217886100251284, group)));
        ______rules.add(new Rule(group, Arrays.asList(vars, groupRest)));
        ______rules.add(new Rule(groupRest, Arrays.asList(vars, groupRest)));
        ______rules.add(new Rule(groupRest, Arrays.asList()));
        ______rules.add(new Rule(vars, Arrays.asList(names, PRODUCED_4250632841794966363, type, PRODUCED_932931441864510178)));
        ______rules.add(new Rule(names, Arrays.asList(name, namesRest)));
        ______rules.add(new Rule(namesRest, Arrays.asList(PRODUCED_3294857353687057909, name, namesRest)));
        ______rules.add(new Rule(namesRest, Arrays.asList()));
        ______rules.add(new Rule(name, Arrays.asList(WORD)));
        ______rules.add(new Rule(type, Arrays.asList(WORD)));
        int[][] ______table = new int[][] {{0, 3, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {-3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, -9, 0, 0, 0, 14, 5, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 8}, {0, 0, 0, 17, 13, 0, 12, 0, 0, 0, 16, 0, 0, 8}, {-6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -6}, {0, 0, 0, 0, 0, 0, 0, -10, 0, 0, 0, 0, -10, 0}, {-5, 0, 0, 0, 9, 15, 12, 0, 0, 0, 16, 0, 0, 8}, {0, 0, 0, 0, 0, 0, 0, 0, 0, -11, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 19, 0, 0, 0, 0, 0, 0}, {-5, 0, 0, 0, 9, 2, 12, 0, 0, 0, 16, 0, 0, 8}, {0, 0, 0, 0, 0, 0, 0, -8, 0, 0, 0, 0, 0, 0}, {-4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, -9, 0, 0, 0, 18, 5, 0}, {-2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, -7, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 11, 0, 0, 0, 0, 10}};
        String[] ______names = new String[] {"$_6207967798290200467", "start", "var", "group", "vars", "groupRest", "names", ":", "type", ";", "name", "namesRest", ",", "WORD"};
        List<Terminal> ______terminals = Arrays.asList(PRODUCED_2113217886100251284, PRODUCED_4250632841794966363, WORD, PRODUCED_932931441864510178, PRODUCED_3294857353687057909, WS);
        try {
            Element ______element = TreeBuilder.build(______table, ______names, ______terminals, ______rules, ______content);
            System.out.println(______element);
        } catch (TokenizerException | ParserException ______ex) {
            ______ex.printStackTrace();
        }
    }
}
