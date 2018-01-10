import java.util.*;
import java.io.IOException;
import java.nio.file.*;
public class Implementation {
    public static void main(String[] args) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get("Input"));
        String content = new String(encoded, "UTF-8");
        Terminal WS = new Terminal("WS", "[ \n\t]", true);
        NonTerminal start = new NonTerminal("start");
        NonTerminal num = new NonTerminal("num");
        Terminal Number = new Terminal("Number", "[1-9][0-9]*", false);
        Terminal PRODUCED_1763455310040578945 = new Terminal("PRODUCED_1763455310040578945", "\\(", false);
        Terminal PRODUCED_4070597129311678799 = new Terminal("PRODUCED_4070597129311678799", "\\+", false);
        Terminal PRODUCED_3077156768121188350 = new Terminal("PRODUCED_3077156768121188350", "\\)", false);
        List<Rule> rules = new ArrayList<>();
        rules.add(new Rule(start, Arrays.asList(start, PRODUCED_4070597129311678799, num)));
        rules.add(new Rule(start, Arrays.asList(num)));
        rules.add(new Rule(num, Arrays.asList(Number)));
        rules.add(new Rule(num, Arrays.asList(PRODUCED_1763455310040578945, start, PRODUCED_3077156768121188350)));
        int[][] table = new int[][] {{0, 8, 0, 4, 9, 2, 0}, {0, 3, 0, 4, 9, 2, 0}, {0, 0, 5, 0, 0, 0, 6}, {-3, 0, -3, 0, 0, 0, -3}, {0, 0, 0, 7, 9, 2, 0}, {-5, 0, -5, 0, 0, 0, -5}, {-2, 0, -2, 0, 0, 0, -2}, {-1, 0, 5, 0, 0, 0, 0}, {-4, 0, -4, 0, 0, 0, -4}};
        String[] names = new String[] {"$_6207967798290200467", "start", "PRODUCED_4070597129311678799", "num", "Number", "PRODUCED_1763455310040578945", "PRODUCED_3077156768121188350"};
        List<Terminal> terminals = Arrays.asList(Number, PRODUCED_4070597129311678799, PRODUCED_1763455310040578945, WS, PRODUCED_3077156768121188350);
        try {
            Element element = TreeBuilder.build(table, names, terminals, rules, content);
            System.out.println(element);
        } catch (TokenizerException | ParserException ex) {
            ex.printStackTrace();
        }
    }
}
