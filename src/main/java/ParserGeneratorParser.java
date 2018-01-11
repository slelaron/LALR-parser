// Generated from /home/nikita/Документы/methods_of_translation/LALR-parser/src/main/antlr4/ParserGenerator.g4 by ANTLR 4.7

    import java.util.*;
    import java.util.stream.Collectors;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ParserGeneratorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, NNAME=5, TNAME=6, TEXT=7, WS=8;
	public static final int
		RULE_gram = 0, RULE_nonterm_rule = 1, RULE_term_rule = 2, RULE_subrule = 3;
	public static final String[] ruleNames = {
		"gram", "nonterm_rule", "term_rule", "subrule"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "':'", "'|'", "'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "NNAME", "TNAME", "TEXT", "WS"
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

	@Override
	public String getGrammarFileName() { return "ParserGenerator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private final Map<String, Wrapper<String>> elements = new HashMap<>();
	    private final Set<String> terminals = new HashSet<>();
	    private final List<Rule> rules = new ArrayList<>();

	    private class Wrapper<T> {
	        private final String name;
	        private final T element;

	        Wrapper(String name, T element) {
	            this.name = name;
	            this.element = element;
	        }

	        String getName() {
	            return name;
	        }

	        T getElement() {
	            return element;
	        }
	    }

	public ParserGeneratorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class GramContext extends ParserRuleContext {
		public String pText;
		public StringBuilder builder = new StringBuilder();
		public Nonterm_ruleContext nonterm_rule;
		public List<Nonterm_ruleContext> nonterm_rule() {
			return getRuleContexts(Nonterm_ruleContext.class);
		}
		public Nonterm_ruleContext nonterm_rule(int i) {
			return getRuleContext(Nonterm_ruleContext.class,i);
		}
		public List<Term_ruleContext> term_rule() {
			return getRuleContexts(Term_ruleContext.class);
		}
		public Term_ruleContext term_rule(int i) {
			return getRuleContext(Term_ruleContext.class,i);
		}
		public GramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gram; }
	}

	public final GramContext gram() throws RecognitionException {
		GramContext _localctx = new GramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_gram);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NNAME || _la==TNAME) {
				{
				{
				setState(12);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NNAME:
					{
					setState(8);
					((GramContext)_localctx).nonterm_rule = nonterm_rule();

					        _localctx.builder.append(((GramContext)_localctx).nonterm_rule.pText);
					    
					}
					break;
				case TNAME:
					{
					setState(11);
					term_rule();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(14);
				match(T__0);
				}
				}
				setState(20);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			_ctx.stop = _input.LT(-1);

			    StringBuilder builder1 = new StringBuilder();
			    for (Map.Entry<String, Wrapper<String>> entry: elements.entrySet()) {
			        builder1.append("        ");
			        builder1.append(entry.getValue().getElement());
			        builder1.append('\n');
			    }
			    builder1.append("        List<Rule> ______rules = new ArrayList<>();\n");
			    builder1.append(_localctx.builder);
			    System.err.println(rules);
			    try {
			        ControlTable controlTable = new ControlTable(new NonTerminal("start"), rules);
			        ControlTable.Wrapper<Element, SuperState<State>> wrapper = controlTable.getTable();
			        builder1.append("        int[][] ______table = new int[][] ");
			        builder1.append(wrapper.getTable());
			        builder1.append(";\n");
			        String string = wrapper.getElements().stream().map(a -> '"' + a.getName() + '"').collect(Collectors.toList()).toString();
			        builder1.append("        String[] ______names = new String[] ");
			        builder1.append("{" + string.substring(1, string.length() - 1) + "};\n");
			    } catch (GeneratorException e) {
			        e.printStackTrace();
			    }
			    builder1.append("        List<Terminal> ______terminals = Arrays.asList(");
			    Iterator<String> iterator = terminals.iterator();
			    while (iterator.hasNext()) {
			        String cur = iterator.next();
			        builder1.append(cur);
			        if (iterator.hasNext()) {
			            builder1.append(", ");
			        }
			    }
			    builder1.append(");\n");
			    ((GramContext)_localctx).pText =  builder1.toString();

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Nonterm_ruleContext extends ParserRuleContext {
		public String pText;
		public StringBuilder builder = new StringBuilder();
		public Token NNAME;
		public SubruleContext subrule;
		public TerminalNode NNAME() { return getToken(ParserGeneratorParser.NNAME, 0); }
		public List<SubruleContext> subrule() {
			return getRuleContexts(SubruleContext.class);
		}
		public SubruleContext subrule(int i) {
			return getRuleContext(SubruleContext.class,i);
		}
		public Nonterm_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonterm_rule; }
	}

	public final Nonterm_ruleContext nonterm_rule() throws RecognitionException {
		Nonterm_ruleContext _localctx = new Nonterm_ruleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_nonterm_rule);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			((Nonterm_ruleContext)_localctx).NNAME = match(NNAME);

			        elements.put((((Nonterm_ruleContext)_localctx).NNAME!=null?((Nonterm_ruleContext)_localctx).NNAME.getText():null), new Wrapper((((Nonterm_ruleContext)_localctx).NNAME!=null?((Nonterm_ruleContext)_localctx).NNAME.getText():null), "NonTerminal " + (((Nonterm_ruleContext)_localctx).NNAME!=null?((Nonterm_ruleContext)_localctx).NNAME.getText():null) + " = new NonTerminal(\"" + (((Nonterm_ruleContext)_localctx).NNAME!=null?((Nonterm_ruleContext)_localctx).NNAME.getText():null) + "\");"));
			    
			setState(23);
			match(T__1);
			setState(30);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(24);
					((Nonterm_ruleContext)_localctx).subrule = subrule();
					setState(25);
					match(T__2);

					        _localctx.builder.append("        ______rules.add(new Rule(" + (((Nonterm_ruleContext)_localctx).NNAME!=null?((Nonterm_ruleContext)_localctx).NNAME.getText():null) + ", Arrays.asList(");
					        for (int i = 0; i < ((Nonterm_ruleContext)_localctx).subrule.textList.size(); i++) {
					            _localctx.builder.append(((Nonterm_ruleContext)_localctx).subrule.textList.get(i).getName());
					            if (i != ((Nonterm_ruleContext)_localctx).subrule.textList.size() - 1) {
					                _localctx.builder.append(", ");
					            }
					        }
					        _localctx.builder.append(")));\n");
					        rules.add(new Rule(new NonTerminal((((Nonterm_ruleContext)_localctx).NNAME!=null?((Nonterm_ruleContext)_localctx).NNAME.getText():null)), ((Nonterm_ruleContext)_localctx).subrule.textList.stream().map(Wrapper<Element>::getElement).collect(Collectors.toList())));
					    
					}
					} 
				}
				setState(32);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(33);
			((Nonterm_ruleContext)_localctx).subrule = subrule();

			        _localctx.builder.append("        ______rules.add(new Rule(" + (((Nonterm_ruleContext)_localctx).NNAME!=null?((Nonterm_ruleContext)_localctx).NNAME.getText():null) + ", Arrays.asList(");
			        for (int i = 0; i < ((Nonterm_ruleContext)_localctx).subrule.textList.size(); i++) {
			            _localctx.builder.append(((Nonterm_ruleContext)_localctx).subrule.textList.get(i).getName());
			            if (i != ((Nonterm_ruleContext)_localctx).subrule.textList.size() - 1) {
			                _localctx.builder.append(", ");
			            }
			        }
			        _localctx.builder.append(")));\n");
			        rules.add(new Rule(new NonTerminal((((Nonterm_ruleContext)_localctx).NNAME!=null?((Nonterm_ruleContext)_localctx).NNAME.getText():null)), ((Nonterm_ruleContext)_localctx).subrule.textList.stream().map(Wrapper<Element>::getElement).collect(Collectors.toList())));
			    
			}
			_ctx.stop = _input.LT(-1);

			    ((Nonterm_ruleContext)_localctx).pText =  _localctx.builder.toString();

		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Term_ruleContext extends ParserRuleContext {
		public boolean needToSkip = false;
		public Token TNAME;
		public Token TEXT;
		public Token NNAME;
		public TerminalNode TNAME() { return getToken(ParserGeneratorParser.TNAME, 0); }
		public TerminalNode TEXT() { return getToken(ParserGeneratorParser.TEXT, 0); }
		public TerminalNode NNAME() { return getToken(ParserGeneratorParser.NNAME, 0); }
		public Term_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term_rule; }
	}

	public final Term_ruleContext term_rule() throws RecognitionException {
		Term_ruleContext _localctx = new Term_ruleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_term_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			((Term_ruleContext)_localctx).TNAME = match(TNAME);
			setState(37);
			match(T__1);
			setState(38);
			((Term_ruleContext)_localctx).TEXT = match(TEXT);
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(39);
				match(T__3);
				setState(40);
				((Term_ruleContext)_localctx).NNAME = match(NNAME);
				if ((((Term_ruleContext)_localctx).NNAME!=null?((Term_ruleContext)_localctx).NNAME.getText():null).equals("skip")) {((Term_ruleContext)_localctx).needToSkip =  true;}
				}
			}


			        String pattern = (((Term_ruleContext)_localctx).TEXT!=null?((Term_ruleContext)_localctx).TEXT.getText():null).substring(1, (((Term_ruleContext)_localctx).TEXT!=null?((Term_ruleContext)_localctx).TEXT.getText():null).length() - 1);
			        elements.put((((Term_ruleContext)_localctx).TNAME!=null?((Term_ruleContext)_localctx).TNAME.getText():null), new Wrapper<String>((((Term_ruleContext)_localctx).TNAME!=null?((Term_ruleContext)_localctx).TNAME.getText():null), "Terminal " + (((Term_ruleContext)_localctx).TNAME!=null?((Term_ruleContext)_localctx).TNAME.getText():null) + " = new Terminal(\"" + (((Term_ruleContext)_localctx).TNAME!=null?((Term_ruleContext)_localctx).TNAME.getText():null) +
			         "\", \"" + pattern + "\", " +
			          (_localctx.needToSkip ? "true" : "false") + ");"));
			        terminals.add((((Term_ruleContext)_localctx).TNAME!=null?((Term_ruleContext)_localctx).TNAME.getText():null));
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SubruleContext extends ParserRuleContext {
		public List<Wrapper<Element>> textList;
		public Token TNAME;
		public Token NNAME;
		public Token TEXT;
		public List<TerminalNode> TNAME() { return getTokens(ParserGeneratorParser.TNAME); }
		public TerminalNode TNAME(int i) {
			return getToken(ParserGeneratorParser.TNAME, i);
		}
		public List<TerminalNode> NNAME() { return getTokens(ParserGeneratorParser.NNAME); }
		public TerminalNode NNAME(int i) {
			return getToken(ParserGeneratorParser.NNAME, i);
		}
		public List<TerminalNode> TEXT() { return getTokens(ParserGeneratorParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(ParserGeneratorParser.TEXT, i);
		}
		public SubruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subrule; }
	}

	public final SubruleContext subrule() throws RecognitionException {
		SubruleContext _localctx = new SubruleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_subrule);

		    ((SubruleContext)_localctx).textList =  new ArrayList<Wrapper<Element>>();

		int _la;
		try {
			setState(57);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NNAME:
			case TNAME:
			case TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(52); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(52);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case TNAME:
						{
						setState(46);
						((SubruleContext)_localctx).TNAME = match(TNAME);

						        String name = (((SubruleContext)_localctx).TNAME!=null?((SubruleContext)_localctx).TNAME.getText():null);
						        _localctx.textList.add(new Wrapper((((SubruleContext)_localctx).TNAME!=null?((SubruleContext)_localctx).TNAME.getText():null), new Terminal((((SubruleContext)_localctx).TNAME!=null?((SubruleContext)_localctx).TNAME.getText():null), "", false)));
						        terminals.add((((SubruleContext)_localctx).TNAME!=null?((SubruleContext)_localctx).TNAME.getText():null));
						    
						}
						break;
					case NNAME:
						{
						setState(48);
						((SubruleContext)_localctx).NNAME = match(NNAME);

						        _localctx.textList.add(new Wrapper((((SubruleContext)_localctx).NNAME!=null?((SubruleContext)_localctx).NNAME.getText():null), new NonTerminal((((SubruleContext)_localctx).NNAME!=null?((SubruleContext)_localctx).NNAME.getText():null))));
						    
						}
						break;
					case TEXT:
						{
						setState(50);
						((SubruleContext)_localctx).TEXT = match(TEXT);

						        String name = (((SubruleContext)_localctx).TEXT!=null?((SubruleContext)_localctx).TEXT.getText():null).substring(1, (((SubruleContext)_localctx).TEXT!=null?((SubruleContext)_localctx).TEXT.getText():null).length() - 1);
						        String realName = Terminal.getName("PRODUCED");
						        if (!elements.containsKey((((SubruleContext)_localctx).TEXT!=null?((SubruleContext)_localctx).TEXT.getText():null))) {
						            elements.put((((SubruleContext)_localctx).TEXT!=null?((SubruleContext)_localctx).TEXT.getText():null), new Wrapper<String>(realName, "Terminal " + realName + " = new Terminal(\"" + name + "\", \"" + name + "\", false);"));
						            terminals.add(realName);
						        } else {
						            realName = elements.get((((SubruleContext)_localctx).TEXT!=null?((SubruleContext)_localctx).TEXT.getText():null)).getName();
						        }
						        _localctx.textList.add(new Wrapper(realName, new Terminal(name, "", false)));
						    
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(54); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NNAME) | (1L << TNAME) | (1L << TEXT))) != 0) );
				}
				break;
			case T__0:
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\n>\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\5\2\17\n\2\3\2\3\2\7\2\23\n\2\f\2\16"+
		"\2\26\13\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\37\n\3\f\3\16\3\"\13\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4-\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\6\5\67\n\5\r\5\16\58\3\5\5\5<\n\5\3\5\2\2\6\2\4\6\b\2\2\2A\2\24\3"+
		"\2\2\2\4\27\3\2\2\2\6&\3\2\2\2\b;\3\2\2\2\n\13\5\4\3\2\13\f\b\2\1\2\f"+
		"\17\3\2\2\2\r\17\5\6\4\2\16\n\3\2\2\2\16\r\3\2\2\2\17\20\3\2\2\2\20\21"+
		"\7\3\2\2\21\23\3\2\2\2\22\16\3\2\2\2\23\26\3\2\2\2\24\22\3\2\2\2\24\25"+
		"\3\2\2\2\25\3\3\2\2\2\26\24\3\2\2\2\27\30\7\7\2\2\30\31\b\3\1\2\31 \7"+
		"\4\2\2\32\33\5\b\5\2\33\34\7\5\2\2\34\35\b\3\1\2\35\37\3\2\2\2\36\32\3"+
		"\2\2\2\37\"\3\2\2\2 \36\3\2\2\2 !\3\2\2\2!#\3\2\2\2\" \3\2\2\2#$\5\b\5"+
		"\2$%\b\3\1\2%\5\3\2\2\2&\'\7\b\2\2\'(\7\4\2\2(,\7\t\2\2)*\7\6\2\2*+\7"+
		"\7\2\2+-\b\4\1\2,)\3\2\2\2,-\3\2\2\2-.\3\2\2\2./\b\4\1\2/\7\3\2\2\2\60"+
		"\61\7\b\2\2\61\67\b\5\1\2\62\63\7\7\2\2\63\67\b\5\1\2\64\65\7\t\2\2\65"+
		"\67\b\5\1\2\66\60\3\2\2\2\66\62\3\2\2\2\66\64\3\2\2\2\678\3\2\2\28\66"+
		"\3\2\2\289\3\2\2\29<\3\2\2\2:<\3\2\2\2;\66\3\2\2\2;:\3\2\2\2<\t\3\2\2"+
		"\2\t\16\24 ,\668;";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}