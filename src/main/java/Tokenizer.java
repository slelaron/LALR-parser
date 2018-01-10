import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikita on 09.01.18.
 */
public class Tokenizer {
    public static List<Terminal> tokenize(List<Terminal> terminals, String string) throws TokenizerException {
        List<Terminal> tokens = new ArrayList<>();
        retry: while (string.length() != 0) {
            for (Terminal terminal: terminals) {
                Terminal curTerminal = terminal.copy();
                String cur = curTerminal.addString(string);
                if (!string.equals(cur)) {
                    string = cur;
                    tokens.add(curTerminal);
                    continue retry;
                }
            }
            throw new TokenizerException("Can't split string on tokens " + string);
        }
        tokens.add(Terminal.EXIT.copy());
        return tokens;
    }
}
