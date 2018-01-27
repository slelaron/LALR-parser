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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, NNAME=14, TNAME=15, TEXT=16, ATTRIBUTES=17, 
		WS=18;
	public static final int
		RULE_gram = 0, RULE_nonterm_rule = 1, RULE_term_rule = 2, RULE_subrule = 3;
	public static final String[] ruleNames = {
		"gram", "nonterm_rule", "term_rule", "subrule"
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

	@Override
	public String getGrammarFileName() { return "ParserGenerator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    List<Pair<String, Integer>> nonTerminals = new ArrayList<>();
	    List<Pair<String, Pair<String, Boolean>>> terminals = new ArrayList<>();
	    Map<String, String> inContext = new HashMap<>();
	    Map<String, Element> elements = new HashMap<>();
	    List<Pair<String, List<Pair<String, String>>>> rules = new ArrayList<>();
	    Map <String, Map<String, Pair<String, Integer>>> params = new HashMap<>();
	    Map <String, Map<String, Pair<String, Integer>>> rets = new HashMap<>();
	    Map <String, Map<String, Pair<String, Integer>>> locals = new HashMap<>();

	public ParserGeneratorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class GramContext extends ParserRuleContext {
		public String parserText;
		public String headerText;
		public String membersText;
		public Token ATTRIBUTES;
		public List<TerminalNode> ATTRIBUTES() { return getTokens(ParserGeneratorParser.ATTRIBUTES); }
		public TerminalNode ATTRIBUTES(int i) {
			return getToken(ParserGeneratorParser.ATTRIBUTES, i);
		}
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

		    ((GramContext)_localctx).headerText =  "";
		    ((GramContext)_localctx).membersText =  "";

		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(8);
				match(T__0);
				setState(9);
				((GramContext)_localctx).ATTRIBUTES = match(ATTRIBUTES);

				        ((GramContext)_localctx).headerText =  (((GramContext)_localctx).ATTRIBUTES!=null?((GramContext)_localctx).ATTRIBUTES.getText():null).substring(1, (((GramContext)_localctx).ATTRIBUTES!=null?((GramContext)_localctx).ATTRIBUTES.getText():null).length() - 1);
				    
				}
			}

			setState(16);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(13);
				match(T__1);
				setState(14);
				((GramContext)_localctx).ATTRIBUTES = match(ATTRIBUTES);

				        ((GramContext)_localctx).membersText =  (((GramContext)_localctx).ATTRIBUTES!=null?((GramContext)_localctx).ATTRIBUTES.getText():null).substring(1, (((GramContext)_localctx).ATTRIBUTES!=null?((GramContext)_localctx).ATTRIBUTES.getText():null).length() - 1);
				    
				}
			}

			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NNAME || _la==TNAME) {
				{
				{
				setState(20);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NNAME:
					{
					setState(18);
					nonterm_rule();
					}
					break;
				case TNAME:
					{
					setState(19);
					term_rule();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(22);
				match(T__2);
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			_ctx.stop = _input.LT(-1);

			    GenerateAttributes gen = new GenerateAttributes();
			    rules.stream().forEach(a -> gen.resolve(a.second(), a.first(), params, rets, locals.get(a.first())));
			    List<Rule> r = rules.stream().map(b -> new Rule(new NonTerminal(b.first()), b.second().stream().map(a -> elements.get(a.first())).collect(Collectors.toList()))).collect(Collectors.toList());
			    //r.stream().forEach(System.err::println);
			    StringBuilder builder = new StringBuilder();
			    nonTerminals.stream().forEach(a -> {
			        builder.append("        ");
			        builder.append("NonTerminal ");
			        builder.append(a.first());
			        builder.append(" = new NonTerminal(\"");
			        builder.append(a.first());
			        builder.append("\", (___objects, ___elements) -> {");
			        builder.append(gen.getResult().get(a.first()));
			        builder.append("}, ");
			        builder.append(a.second());
			        builder.append(");\n");
			    });

			    terminals.stream().forEach(a -> {
			        builder.append("        ");
			        builder.append("Terminal ");
			        builder.append(a.first());
			        builder.append(" = new Terminal(\"");
			        builder.append(a.first());
			        builder.append("\", \"");
			        builder.append(a.second().first());
			        builder.append("\", ");
			        builder.append(a.second().second());
			        builder.append(");\n");
			    });

			    inContext.entrySet().stream().forEach(a -> {
			        builder.append("        ");
			        builder.append("Terminal ");
			        builder.append(a.getValue());
			        builder.append(" = new Terminal(\"");
			        builder.append(a.getKey());
			        builder.append("\", \"");
			        builder.append(a.getKey());
			        builder.append("\", ");
			        builder.append("false);\n");
			    });

			    builder.append("        List<Rule> ___rules = new ArrayList<>();\n");

			    try {
			        ControlTable controlTable = new ControlTable(new NonTerminal("start"), r);
			        ControlTable.Wrapper<Element, SuperState<State>> wrapper = controlTable.getTable();
			        //wrapper.getSuperStates().forEach(System.err::println);
			        builder.append("        int[][] ___table = new int[][] ");
			        builder.append(wrapper.getTable());
			        builder.append(";\n");
			        String string = wrapper.getElements().stream().map(a -> '"' + a.getName() + '"').collect(Collectors.toList()).toString();
			        builder.append("        String[] ___names = new String[] ");
			        builder.append("{" + string.substring(1, string.length() - 1) + "};\n");
			    } catch (GeneratorException e) {
			        e.printStackTrace();
			        throw new NullPointerException();
			    }

			    rules.stream().forEach(a -> {
			        builder.append("        ");
			        builder.append("___rules.add(new Rule(");
			        builder.append(a.first());
			        builder.append(", ");
			        if (a.second().isEmpty()) {
			            builder.append("Collections.emptyList(");
			        } else if (a.second().size() == 1) {
			            builder.append("Collections.singletonList(");
			        } else {
			            builder.append("Arrays.asList(");
			        }
			        Iterator<Pair<String, String>> iterator = a.second().iterator();
			        while (iterator.hasNext()) {
			            builder.append(iterator.next().first());
			            if (iterator.hasNext()) {
			                builder.append(", ");
			            }
			        }
			        builder.append(")));\n");
			    });

			    builder.append("        List<Terminal> ___terminals = Arrays.asList(");
			    Iterator<Map.Entry<String, String>> mapIterator = inContext.entrySet().iterator();
			    while (mapIterator.hasNext()) {
			        String cur = mapIterator.next().getValue();
			        builder.append(cur);
			        builder.append(", ");
			    }
			    Iterator<Pair<String, Pair<String, Boolean>>> iterator = terminals.iterator();
			    while (iterator.hasNext()) {
			        String cur = iterator.next().first();
			        builder.append(cur);
			        if (iterator.hasNext()) {
			            builder.append(", ");
			        }
			    }
			    builder.append(");\n");
			    ((GramContext)_localctx).parserText =  builder.toString();


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
		public List<Pair<String, String>> attributes = new ArrayList<>();
		public int border = 0;
		public List<Pair<String, String>> local = new ArrayList<>();
		public int index = 1;
		public List<Pair<String, String>> names = new ArrayList<>();
		public Token name;
		public Token TNAME;
		public Token NNAME;
		public List<SubruleContext> subrule() {
			return getRuleContexts(SubruleContext.class);
		}
		public SubruleContext subrule(int i) {
			return getRuleContext(SubruleContext.class,i);
		}
		public List<TerminalNode> NNAME() { return getTokens(ParserGeneratorParser.NNAME); }
		public TerminalNode NNAME(int i) {
			return getToken(ParserGeneratorParser.NNAME, i);
		}
		public List<TerminalNode> TNAME() { return getTokens(ParserGeneratorParser.TNAME); }
		public TerminalNode TNAME(int i) {
			return getToken(ParserGeneratorParser.TNAME, i);
		}
		public Nonterm_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonterm_rule; }
	}

	public final Nonterm_ruleContext nonterm_rule() throws RecognitionException {
		Nonterm_ruleContext _localctx = new Nonterm_ruleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_nonterm_rule);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			((Nonterm_ruleContext)_localctx).name = match(NNAME);
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(30);
				match(T__3);
				setState(37);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(31);
						((Nonterm_ruleContext)_localctx).TNAME = match(TNAME);
						setState(32);
						((Nonterm_ruleContext)_localctx).NNAME = match(NNAME);
						_localctx.attributes.add(new Pair<>((((Nonterm_ruleContext)_localctx).TNAME!=null?((Nonterm_ruleContext)_localctx).TNAME.getText():null), (((Nonterm_ruleContext)_localctx).NNAME!=null?((Nonterm_ruleContext)_localctx).NNAME.getText():null)));
						setState(34);
						match(T__4);
						}
						} 
					}
					setState(39);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				{
				setState(40);
				((Nonterm_ruleContext)_localctx).TNAME = match(TNAME);
				setState(41);
				((Nonterm_ruleContext)_localctx).NNAME = match(NNAME);
				_localctx.attributes.add(new Pair<>((((Nonterm_ruleContext)_localctx).TNAME!=null?((Nonterm_ruleContext)_localctx).TNAME.getText():null), (((Nonterm_ruleContext)_localctx).NNAME!=null?((Nonterm_ruleContext)_localctx).NNAME.getText():null)));
				}
				setState(44);
				match(T__5);

				        Map<String, Pair<String, Integer>> map = new HashMap<>();
				        for (Pair<String, String> pair: _localctx.attributes) {
				            map.put(pair.second(), new Pair<>(pair.first(), _localctx.index++));
				        }
				        params.put((((Nonterm_ruleContext)_localctx).name!=null?((Nonterm_ruleContext)_localctx).name.getText():null), map);
				        _localctx.attributes.clear();
				    
				}
			}

			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(48);
				match(T__6);
				setState(49);
				match(T__3);
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(50);
						((Nonterm_ruleContext)_localctx).TNAME = match(TNAME);
						setState(51);
						((Nonterm_ruleContext)_localctx).NNAME = match(NNAME);
						_localctx.attributes.add(new Pair<>((((Nonterm_ruleContext)_localctx).TNAME!=null?((Nonterm_ruleContext)_localctx).TNAME.getText():null), (((Nonterm_ruleContext)_localctx).NNAME!=null?((Nonterm_ruleContext)_localctx).NNAME.getText():null)));
						setState(53);
						match(T__4);
						}
						} 
					}
					setState(58);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				{
				setState(59);
				((Nonterm_ruleContext)_localctx).TNAME = match(TNAME);
				setState(60);
				((Nonterm_ruleContext)_localctx).NNAME = match(NNAME);
				_localctx.attributes.add(new Pair<>((((Nonterm_ruleContext)_localctx).TNAME!=null?((Nonterm_ruleContext)_localctx).TNAME.getText():null), (((Nonterm_ruleContext)_localctx).NNAME!=null?((Nonterm_ruleContext)_localctx).NNAME.getText():null)));
				}
				setState(63);
				match(T__5);

				        Map<String, Pair<String, Integer>> map = new HashMap<>();
				        int lBorder = _localctx.index;
				        for (Pair<String, String> pair: _localctx.attributes) {
				            map.put(pair.second(), new Pair<>(pair.first(), _localctx.index++));
				        }
				        ((Nonterm_ruleContext)_localctx).border =  _localctx.index - lBorder;
				        rets.put((((Nonterm_ruleContext)_localctx).name!=null?((Nonterm_ruleContext)_localctx).name.getText():null), map);
				        _localctx.local.addAll(_localctx.attributes);
				        _localctx.attributes.clear();
				    
				}
			}

			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(67);
				match(T__7);
				setState(68);
				match(T__3);
				setState(75);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(69);
						((Nonterm_ruleContext)_localctx).TNAME = match(TNAME);
						setState(70);
						((Nonterm_ruleContext)_localctx).NNAME = match(NNAME);
						_localctx.attributes.add(new Pair<>((((Nonterm_ruleContext)_localctx).TNAME!=null?((Nonterm_ruleContext)_localctx).TNAME.getText():null), (((Nonterm_ruleContext)_localctx).NNAME!=null?((Nonterm_ruleContext)_localctx).NNAME.getText():null)));
						setState(72);
						match(T__4);
						}
						} 
					}
					setState(77);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				{
				setState(78);
				((Nonterm_ruleContext)_localctx).TNAME = match(TNAME);
				setState(79);
				((Nonterm_ruleContext)_localctx).NNAME = match(NNAME);
				_localctx.attributes.add(new Pair<>((((Nonterm_ruleContext)_localctx).TNAME!=null?((Nonterm_ruleContext)_localctx).TNAME.getText():null), (((Nonterm_ruleContext)_localctx).NNAME!=null?((Nonterm_ruleContext)_localctx).NNAME.getText():null)));
				}
				setState(82);
				match(T__5);

				        Map<String, Pair<String, Integer>> map = new HashMap<>();
				        for (Pair<String, String> pair: _localctx.attributes) {
				            map.put(pair.second(), new Pair<>(pair.first(), _localctx.index++));
				        }
				        locals.put((((Nonterm_ruleContext)_localctx).name!=null?((Nonterm_ruleContext)_localctx).name.getText():null), map);
				        _localctx.local.addAll(_localctx.attributes);
				        _localctx.attributes.clear();
				    
				}
			}

			setState(86);
			match(T__8);

			        if (!_localctx.local.isEmpty()) {
			            String curName = Terminal.generateName("LOCALS");
			            StringBuilder builder = new StringBuilder();
			            for (Pair<String, String> pair: _localctx.local) {
			                 builder.append("___objects.add(new Wrapper<");
			                 builder.append(pair.first());
			                 builder.append(">());");
			            }
			            _localctx.names.add(new Pair<>(curName, builder.toString()));
			            elements.put(curName, new NonTerminal(curName));
			            nonTerminals.add(new Pair<>(curName, 0));
			            rules.add(new Pair<>(curName, Collections.emptyList()));
			        }
			        nonTerminals.add(new Pair<>((((Nonterm_ruleContext)_localctx).name!=null?((Nonterm_ruleContext)_localctx).name.getText():null), _localctx.border));
			        elements.put((((Nonterm_ruleContext)_localctx).name!=null?((Nonterm_ruleContext)_localctx).name.getText():null), new NonTerminal((((Nonterm_ruleContext)_localctx).name!=null?((Nonterm_ruleContext)_localctx).name.getText():null)));
			    
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(88);
					subrule((((Nonterm_ruleContext)_localctx).name!=null?((Nonterm_ruleContext)_localctx).name.getText():null), new ArrayList<Pair<String, String>>(_localctx.names));
					setState(89);
					match(T__9);
					}
					} 
				}
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(96);
			subrule((((Nonterm_ruleContext)_localctx).name!=null?((Nonterm_ruleContext)_localctx).name.getText():null), new ArrayList<Pair<String, String>>(_localctx.names));
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

	public static class Term_ruleContext extends ParserRuleContext {
		public boolean skip = false;
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
			setState(98);
			((Term_ruleContext)_localctx).TNAME = match(TNAME);
			setState(99);
			match(T__8);
			setState(100);
			((Term_ruleContext)_localctx).TEXT = match(TEXT);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(101);
				match(T__10);
				setState(102);
				((Term_ruleContext)_localctx).NNAME = match(NNAME);
				if ((((Term_ruleContext)_localctx).NNAME!=null?((Term_ruleContext)_localctx).NNAME.getText():null).equals("skip")) {((Term_ruleContext)_localctx).skip =  true;}
				}
			}


			        String curText = (((Term_ruleContext)_localctx).TEXT!=null?((Term_ruleContext)_localctx).TEXT.getText():null).substring(1, (((Term_ruleContext)_localctx).TEXT!=null?((Term_ruleContext)_localctx).TEXT.getText():null).length() - 1);
			        terminals.add(new Pair<>((((Term_ruleContext)_localctx).TNAME!=null?((Term_ruleContext)_localctx).TNAME.getText():null), new Pair<>(curText, _localctx.skip)));
			        elements.put((((Term_ruleContext)_localctx).TNAME!=null?((Term_ruleContext)_localctx).TNAME.getText():null), new Terminal((((Term_ruleContext)_localctx).TNAME!=null?((Term_ruleContext)_localctx).TNAME.getText():null), "", _localctx.skip));
			    
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
		public String nonTermName;
		public List<Pair<String, String>> names;
		public List<String> attributes = new ArrayList<>();
		public Token TNAME;
		public Token name;
		public Token NNAME;
		public Token ATTRIBUTES;
		public Token TEXT;
		public List<TerminalNode> TNAME() { return getTokens(ParserGeneratorParser.TNAME); }
		public TerminalNode TNAME(int i) {
			return getToken(ParserGeneratorParser.TNAME, i);
		}
		public List<TerminalNode> ATTRIBUTES() { return getTokens(ParserGeneratorParser.ATTRIBUTES); }
		public TerminalNode ATTRIBUTES(int i) {
			return getToken(ParserGeneratorParser.ATTRIBUTES, i);
		}
		public List<TerminalNode> TEXT() { return getTokens(ParserGeneratorParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(ParserGeneratorParser.TEXT, i);
		}
		public List<TerminalNode> NNAME() { return getTokens(ParserGeneratorParser.NNAME); }
		public TerminalNode NNAME(int i) {
			return getToken(ParserGeneratorParser.NNAME, i);
		}
		public SubruleContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public SubruleContext(ParserRuleContext parent, int invokingState, String nonTermName, List<Pair<String, String>> names) {
			super(parent, invokingState);
			this.nonTermName = nonTermName;
			this.names = names;
		}
		@Override public int getRuleIndex() { return RULE_subrule; }
	}

	public final SubruleContext subrule(String nonTermName,List<Pair<String, String>> names) throws RecognitionException {
		SubruleContext _localctx = new SubruleContext(_ctx, getState(), nonTermName, names);
		enterRule(_localctx, 6, RULE_subrule);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NNAME:
			case TNAME:
			case TEXT:
			case ATTRIBUTES:
				{
				setState(148); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(148);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case TNAME:
						{
						setState(108);
						((SubruleContext)_localctx).TNAME = match(TNAME);

						        _localctx.names.add(new Pair<>((((SubruleContext)_localctx).TNAME!=null?((SubruleContext)_localctx).TNAME.getText():null), ""));
						    
						}
						break;
					case NNAME:
						{
						setState(110);
						((SubruleContext)_localctx).name = match(NNAME);
						setState(141);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__3) {
							{
							setState(111);
							match(T__3);
							setState(126);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
							while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
								if ( _alt==1 ) {
									{
									{
									setState(112);
									match(T__11);
									setState(113);
									((SubruleContext)_localctx).NNAME = match(NNAME);
									_localctx.attributes.add((((SubruleContext)_localctx).NNAME!=null?((SubruleContext)_localctx).NNAME.getText():null));
									setState(120);
									_errHandler.sync(this);
									_la = _input.LA(1);
									while (_la==T__12) {
										{
										{
										setState(115);
										match(T__12);
										setState(116);
										((SubruleContext)_localctx).NNAME = match(NNAME);
										_localctx.attributes.set(_localctx.attributes.size() - 1, _localctx.attributes.get(_localctx.attributes.size() - 1) + "." + (((SubruleContext)_localctx).NNAME!=null?((SubruleContext)_localctx).NNAME.getText():null));
										}
										}
										setState(122);
										_errHandler.sync(this);
										_la = _input.LA(1);
									}
									setState(123);
									match(T__4);
									}
									} 
								}
								setState(128);
								_errHandler.sync(this);
								_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
							}
							setState(129);
							match(T__11);
							setState(130);
							((SubruleContext)_localctx).NNAME = match(NNAME);
							_localctx.attributes.add((((SubruleContext)_localctx).NNAME!=null?((SubruleContext)_localctx).NNAME.getText():null));
							setState(137);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==T__12) {
								{
								{
								setState(132);
								match(T__12);
								setState(133);
								((SubruleContext)_localctx).NNAME = match(NNAME);
								_localctx.attributes.set(_localctx.attributes.size() - 1, _localctx.attributes.get(_localctx.attributes.size() - 1) + "." + (((SubruleContext)_localctx).NNAME!=null?((SubruleContext)_localctx).NNAME.getText():null));
								}
								}
								setState(139);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							setState(140);
							match(T__5);
							}
						}


						        if (!_localctx.attributes.isEmpty()) {
						            String curName = Terminal.generateName("MARKER");
						            StringBuilder builder = new StringBuilder();
						            for (int i = 0; i < _localctx.attributes.size(); i++) {
						                builder.append("___objects.add(new Wrapper<>($");
						                builder.append(_localctx.attributes.get(i));
						                builder.append("));");
						            }
						            _localctx.names.add(new Pair<>(curName, builder.toString()));
						            elements.put(curName, new NonTerminal(curName));
						            nonTerminals.add(new Pair<>(curName, 0));
						            rules.add(new Pair<>(curName, Collections.emptyList()));
						        }
						        _localctx.attributes.clear();
						        _localctx.names.add(new Pair<>((((SubruleContext)_localctx).name!=null?((SubruleContext)_localctx).name.getText():null), ""));
						    
						}
						break;
					case ATTRIBUTES:
						{
						setState(144);
						((SubruleContext)_localctx).ATTRIBUTES = match(ATTRIBUTES);

						        String curName = Terminal.generateName("ATTRIBUTE");
						        rules.add(new Pair<>(curName, Collections.emptyList()));
						        elements.put(curName, new NonTerminal(curName));
						        nonTerminals.add(new Pair<>(curName, 0));
						        _localctx.names.add(new Pair<>(curName, (((SubruleContext)_localctx).ATTRIBUTES!=null?((SubruleContext)_localctx).ATTRIBUTES.getText():null).substring(1, (((SubruleContext)_localctx).ATTRIBUTES!=null?((SubruleContext)_localctx).ATTRIBUTES.getText():null).length() - 1)));
						    
						}
						break;
					case TEXT:
						{
						setState(146);
						((SubruleContext)_localctx).TEXT = match(TEXT);

						        String curName = Terminal.generateName("PRODUCED");
						        String curText = (((SubruleContext)_localctx).TEXT!=null?((SubruleContext)_localctx).TEXT.getText():null).substring(1, (((SubruleContext)_localctx).TEXT!=null?((SubruleContext)_localctx).TEXT.getText():null).length() - 1);
						        if (inContext.containsKey(curText)) {
						            curName = inContext.get(curText);
						        } else {
						            inContext.put(curText, curName);
						            elements.put(curName, new Terminal(curText, "", false));
						        }
						        _localctx.names.add(new Pair<>(curName, ""));
						    
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(150); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NNAME) | (1L << TNAME) | (1L << TEXT) | (1L << ATTRIBUTES))) != 0) );
				}
				break;
			case T__2:
			case T__9:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}

			        rules.add(new Pair<>(nonTermName, _localctx.names));
			    
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24\u00a0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\5\2\16\n\2\3\2\3\2\3\2\5\2\23\n\2"+
		"\3\2\3\2\5\2\27\n\2\3\2\3\2\7\2\33\n\2\f\2\16\2\36\13\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\7\3&\n\3\f\3\16\3)\13\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\61\n\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\7\39\n\3\f\3\16\3<\13\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\5\3D\n\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3L\n\3\f\3\16\3O\13\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\5\3W\n\3\3\3\3\3\3\3\3\3\3\3\7\3^\n\3\f\3\16\3a\13\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4k\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\7\5y\n\5\f\5\16\5|\13\5\3\5\7\5\177\n\5\f\5\16\5\u0082"+
		"\13\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u008a\n\5\f\5\16\5\u008d\13\5\3\5\5"+
		"\5\u0090\n\5\3\5\3\5\3\5\3\5\3\5\6\5\u0097\n\5\r\5\16\5\u0098\3\5\5\5"+
		"\u009c\n\5\3\5\3\5\3\5\2\2\6\2\4\6\b\2\2\2\u00b0\2\r\3\2\2\2\4\37\3\2"+
		"\2\2\6d\3\2\2\2\b\u009b\3\2\2\2\n\13\7\3\2\2\13\f\7\23\2\2\f\16\b\2\1"+
		"\2\r\n\3\2\2\2\r\16\3\2\2\2\16\22\3\2\2\2\17\20\7\4\2\2\20\21\7\23\2\2"+
		"\21\23\b\2\1\2\22\17\3\2\2\2\22\23\3\2\2\2\23\34\3\2\2\2\24\27\5\4\3\2"+
		"\25\27\5\6\4\2\26\24\3\2\2\2\26\25\3\2\2\2\27\30\3\2\2\2\30\31\7\5\2\2"+
		"\31\33\3\2\2\2\32\26\3\2\2\2\33\36\3\2\2\2\34\32\3\2\2\2\34\35\3\2\2\2"+
		"\35\3\3\2\2\2\36\34\3\2\2\2\37\60\7\20\2\2 \'\7\6\2\2!\"\7\21\2\2\"#\7"+
		"\20\2\2#$\b\3\1\2$&\7\7\2\2%!\3\2\2\2&)\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2"+
		"(*\3\2\2\2)\'\3\2\2\2*+\7\21\2\2+,\7\20\2\2,-\b\3\1\2-.\3\2\2\2./\7\b"+
		"\2\2/\61\b\3\1\2\60 \3\2\2\2\60\61\3\2\2\2\61C\3\2\2\2\62\63\7\t\2\2\63"+
		":\7\6\2\2\64\65\7\21\2\2\65\66\7\20\2\2\66\67\b\3\1\2\679\7\7\2\28\64"+
		"\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2\2=>\7\21\2\2"+
		">?\7\20\2\2?@\b\3\1\2@A\3\2\2\2AB\7\b\2\2BD\b\3\1\2C\62\3\2\2\2CD\3\2"+
		"\2\2DV\3\2\2\2EF\7\n\2\2FM\7\6\2\2GH\7\21\2\2HI\7\20\2\2IJ\b\3\1\2JL\7"+
		"\7\2\2KG\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2\2\2PQ\7"+
		"\21\2\2QR\7\20\2\2RS\b\3\1\2ST\3\2\2\2TU\7\b\2\2UW\b\3\1\2VE\3\2\2\2V"+
		"W\3\2\2\2WX\3\2\2\2XY\7\13\2\2Y_\b\3\1\2Z[\5\b\5\2[\\\7\f\2\2\\^\3\2\2"+
		"\2]Z\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a_\3\2\2\2bc\5\b\5"+
		"\2c\5\3\2\2\2de\7\21\2\2ef\7\13\2\2fj\7\22\2\2gh\7\r\2\2hi\7\20\2\2ik"+
		"\b\4\1\2jg\3\2\2\2jk\3\2\2\2kl\3\2\2\2lm\b\4\1\2m\7\3\2\2\2no\7\21\2\2"+
		"o\u0097\b\5\1\2p\u008f\7\20\2\2q\u0080\7\6\2\2rs\7\16\2\2st\7\20\2\2t"+
		"z\b\5\1\2uv\7\17\2\2vw\7\20\2\2wy\b\5\1\2xu\3\2\2\2y|\3\2\2\2zx\3\2\2"+
		"\2z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}\177\7\7\2\2~r\3\2\2\2\177\u0082\3\2"+
		"\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0083\u0084\7\16\2\2\u0084\u0085\7\20\2\2\u0085\u008b\b\5\1\2"+
		"\u0086\u0087\7\17\2\2\u0087\u0088\7\20\2\2\u0088\u008a\b\5\1\2\u0089\u0086"+
		"\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0090\7\b\2\2\u008fq\3\2\2\2"+
		"\u008f\u0090\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0097\b\5\1\2\u0092\u0093"+
		"\7\23\2\2\u0093\u0097\b\5\1\2\u0094\u0095\7\22\2\2\u0095\u0097\b\5\1\2"+
		"\u0096n\3\2\2\2\u0096p\3\2\2\2\u0096\u0092\3\2\2\2\u0096\u0094\3\2\2\2"+
		"\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009c"+
		"\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0096\3\2\2\2\u009b\u009a\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009e\b\5\1\2\u009e\t\3\2\2\2\25\r\22\26\34\'\60"+
		":CMV_jz\u0080\u008b\u008f\u0096\u0098\u009b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}