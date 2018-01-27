// Generated from /home/nikita/Документы/methods_of_translation/LALR-parser/src/main/antlr4/ParserGenerator.g4 by ANTLR 4.7

    import java.util.*;
    import java.util.stream.Collectors;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ParserGeneratorLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, NNAME=14, TNAME=15, TEXT=16, ATTRIBUTES=17, 
		WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "NNAME", "TNAME", "TEXT", "ATTRIBUTES", 
		"WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'@header'", "'@members'", "';'", "'['", "','", "']'", "'returns'", 
		"'locals'", "':'", "'|'", "'->'", "'$'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "NNAME", "TNAME", "TEXT", "ATTRIBUTES", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ParserGeneratorLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ParserGenerator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u0095\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\7\17]\n\17\f\17\16\17`\13\17\3\20\3\20\7\20d"+
		"\n\20\f\20\16\20g\13\20\3\21\3\21\7\21k\n\21\f\21\16\21n\13\21\3\21\5"+
		"\21q\n\21\3\21\3\21\7\21u\n\21\f\21\16\21x\13\21\3\21\3\21\3\22\3\22\7"+
		"\22~\n\22\f\22\16\22\u0081\13\22\3\22\5\22\u0084\n\22\3\22\3\22\7\22\u0088"+
		"\n\22\f\22\16\22\u008b\13\22\3\22\3\22\3\23\6\23\u0090\n\23\r\23\16\23"+
		"\u0091\3\23\3\23\4l\177\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\3\2\7\3\2c|\6\2\62;C\\"+
		"aac|\3\2C\\\3\2^^\4\2\13\f\"\"\2\u009d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5/\3"+
		"\2\2\2\78\3\2\2\2\t:\3\2\2\2\13<\3\2\2\2\r>\3\2\2\2\17@\3\2\2\2\21H\3"+
		"\2\2\2\23O\3\2\2\2\25Q\3\2\2\2\27S\3\2\2\2\31V\3\2\2\2\33X\3\2\2\2\35"+
		"Z\3\2\2\2\37a\3\2\2\2!h\3\2\2\2#{\3\2\2\2%\u008f\3\2\2\2\'(\7B\2\2()\7"+
		"j\2\2)*\7g\2\2*+\7c\2\2+,\7f\2\2,-\7g\2\2-.\7t\2\2.\4\3\2\2\2/\60\7B\2"+
		"\2\60\61\7o\2\2\61\62\7g\2\2\62\63\7o\2\2\63\64\7d\2\2\64\65\7g\2\2\65"+
		"\66\7t\2\2\66\67\7u\2\2\67\6\3\2\2\289\7=\2\29\b\3\2\2\2:;\7]\2\2;\n\3"+
		"\2\2\2<=\7.\2\2=\f\3\2\2\2>?\7_\2\2?\16\3\2\2\2@A\7t\2\2AB\7g\2\2BC\7"+
		"v\2\2CD\7w\2\2DE\7t\2\2EF\7p\2\2FG\7u\2\2G\20\3\2\2\2HI\7n\2\2IJ\7q\2"+
		"\2JK\7e\2\2KL\7c\2\2LM\7n\2\2MN\7u\2\2N\22\3\2\2\2OP\7<\2\2P\24\3\2\2"+
		"\2QR\7~\2\2R\26\3\2\2\2ST\7/\2\2TU\7@\2\2U\30\3\2\2\2VW\7&\2\2W\32\3\2"+
		"\2\2XY\7\60\2\2Y\34\3\2\2\2Z^\t\2\2\2[]\t\3\2\2\\[\3\2\2\2]`\3\2\2\2^"+
		"\\\3\2\2\2^_\3\2\2\2_\36\3\2\2\2`^\3\2\2\2ae\t\4\2\2bd\t\3\2\2cb\3\2\2"+
		"\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f \3\2\2\2ge\3\2\2\2hp\7$\2\2ik\13\2\2"+
		"\2ji\3\2\2\2kn\3\2\2\2lm\3\2\2\2lj\3\2\2\2mo\3\2\2\2nl\3\2\2\2oq\n\5\2"+
		"\2pl\3\2\2\2pq\3\2\2\2qv\3\2\2\2rs\7^\2\2su\7^\2\2tr\3\2\2\2ux\3\2\2\2"+
		"vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\7$\2\2z\"\3\2\2\2{\u0083\7"+
		")\2\2|~\13\2\2\2}|\3\2\2\2~\u0081\3\2\2\2\177\u0080\3\2\2\2\177}\3\2\2"+
		"\2\u0080\u0082\3\2\2\2\u0081\177\3\2\2\2\u0082\u0084\n\5\2\2\u0083\177"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0089\3\2\2\2\u0085\u0086\7^\2\2\u0086"+
		"\u0088\7^\2\2\u0087\u0085\3\2\2\2\u0088\u008b\3\2\2\2\u0089\u0087\3\2"+
		"\2\2\u0089\u008a\3\2\2\2\u008a\u008c\3\2\2\2\u008b\u0089\3\2\2\2\u008c"+
		"\u008d\7)\2\2\u008d$\3\2\2\2\u008e\u0090\t\6\2\2\u008f\u008e\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2"+
		"\2\2\u0093\u0094\b\23\2\2\u0094&\3\2\2\2\f\2^elpv\177\u0083\u0089\u0091"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}