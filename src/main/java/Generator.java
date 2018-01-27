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
    private static final String header =
            "import java.util.*;\n" +
            "import java.io.IOException;\n" +
            "import java.nio.file.*;\n";
    private static final String classDecl =
            "@SuppressWarnings(\"unchecked\")\n" +
            "public class Implementation {\n";
    private static final String prefix =
            "    public static void main(String[] ___args) throws IOException {\n" +
            "        byte[] ___encoded = Files.readAllBytes(Paths.get(\"Input\"));\n" +
            "        String ___content = new String(___encoded, \"UTF-8\");\n";
    private static final String suffix =
            "        try {\n" +
            "            Element ___element = TreeBuilder.build(___table, ___names, ___terminals, ___rules, ___content);\n" +
            "            System.out.println(___element);\n" +
            "        } catch (TokenizerException | ParserException ___ex) {\n" +
            "            ___ex.printStackTrace();\n" +
            "        }\n" +
            "    }\n" +
            "}\n";
    public static void main(String[] args) throws IOException {
        CharStream stream = CharStreams.fromFileName("Example");
        ParserGeneratorLexer lexer = new ParserGeneratorLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ParserGeneratorParser parser = new ParserGeneratorParser(tokens);
        ParserGeneratorParser.GramContext gram = parser.gram();
        final String pText = gram.parserText;
        final String pHeader = gram.headerText;
        final String pMembers = gram.membersText;

        Path p = Paths.get("./src/main/java/Implementation.java");
        try {
            if (p.getParent() != null) {
                Files.createDirectories(p.getParent());
            }
            PrintWriter writer = new PrintWriter(p.toFile());

            writer.write(header);
            writer.write(pHeader);
            writer.write('\n');
            writer.write(classDecl);
            writer.write(pMembers);
            writer.write('\n');
            writer.write(prefix);
            writer.write(pText);
            writer.write('\n');
            writer.write(suffix);
            writer.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}