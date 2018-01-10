import org.antlr.v4.runtime.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by nikita on 07.01.18.
 */
public class Generator {
    private static final String prefix =
            "import java.util.*;\n" +
            "import java.io.IOException;\n" +
            "import java.nio.file.*;\n" +
            "public class Implementation {\n" +
            "    public static void main(String[] args) throws IOException {\n" +
            "        byte[] encoded = Files.readAllBytes(Paths.get(\"Input\"));\n" +
            "        String content = new String(encoded, \"UTF-8\");\n";
    private static final String suffix =
            "        try {\n" +
            "            Element element = TreeBuilder.build(table, names, terminals, rules, content);\n" +
            "            System.out.println(element);\n" +
            "        } catch (TokenizerException | ParserException ex) {\n" +
            "            ex.printStackTrace();\n" +
            "        }\n" +
            "    }\n" +
            "}\n";
    public static void main(String[] args) throws IOException {
        CharStream stream = CharStreams.fromFileName("Example");
        ParserGeneratorLexer lexer = new ParserGeneratorLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParserGeneratorParser parser = new ParserGeneratorParser(tokens);
        final String text = parser.gram().pText;

        Path p = Paths.get("./src/main/java/Implementation.java");
        try {
            if (p.getParent() != null) {
                Files.createDirectories(p.getParent());
            }
            PrintWriter writer = new PrintWriter(p.toFile());

            writer.write(prefix);
            writer.write(text);
            writer.write(suffix);
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
