// Generated from BUCOLGrammar.g4 by ANTLR 4.13.2
package io.compiler.core;

	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.HashMap;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;
	import io.compiler.core.ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class BUCOLGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, OP=31, OP_AT=32, 
		OPREL=33, ID=34, NUM=35, BOOLEAN=36, VIRG=37, QL=38, AP=39, FP=40, PI=41, 
		DP=42, TEXTO=43, WS=44;
	public static final int
		RULE_programa = 0, RULE_declaravar = 1, RULE_declarativo = 2, RULE_comando = 3, 
		RULE_cmdIF = 4, RULE_cmdWhile = 5, RULE_cmdDoWhile = 6, RULE_cmdAttrib = 7, 
		RULE_cmdLeitura = 8, RULE_cmdEscrita = 9, RULE_expr = 10, RULE_termo = 11, 
		RULE_exprl = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaravar", "declarativo", "comando", "cmdIF", "cmdWhile", 
			"cmdDoWhile", "cmdAttrib", "cmdLeitura", "cmdEscrita", "expr", "termo", 
			"exprl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'poema'", "'inicio'", "'fim'", "'fimpoema'", "'integro'", "'integros'", 
			"'integra'", "'integras'", "'verboso'", "'verbosos'", "'verbosa'", "'verbosas'", 
			"'discreto'", "'discretos'", "'discreta'", "'discretas'", "'Atentai ao'", 
			"'Atentai \\u00E0'", "'Atentai aos'", "'Atentai \\u00E0s'", "'Ao acaso, tendo'", 
			"', tenho que'", "'Mas, se o destino n\\u00E3o permite,'", "'E esta \\u00E9 a solu\\u00E7\\u00F5es para minhas indaga\\u00E7\\u00F5es'", 
			"'Continuamente, ao caso de'", "', busco'", "'O que continuamente trar\\u00E1 meu sossego'", 
			"'Busco'", "'Continuamente, em caso de'", "'escreva'", null, null, null, 
			null, null, null, "','", "'\\n'", "'('", "')'", "'?'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "OP", "OP_AT", "OPREL", "ID", 
			"NUM", "BOOLEAN", "VIRG", "QL", "AP", "FP", "PI", "DP", "TEXTO", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "BUCOLGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    private HashMap<String,Var> symbolTable = new HashMap<String, Var>();
	    private ArrayList<Var> currentDecl = new ArrayList<Var>();
	    private Types currentType;
	    private Types leftType=null, rightType=null;
	    private Program program = new Program();
	    private String strExpr = "";
	    private IfCommand currentIfCommand;
	    private WhileCommand currentWhileCommand;
	    private AtribCommand currentAtribCommand;
	    
	    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
	    
	    
	    public void updateType(){
	    	for(Var v: currentDecl){
	    	   v.setType(currentType);
	    	   symbolTable.put(v.getId(), v);
	    	}
	    }
	    public void exibirVar(){
	        for (String id: symbolTable.keySet()){
	        	System.out.println(symbolTable.get(id));
	        }
	    }
	    
	    public Program getProgram(){
	    	return this.program;
	    	}
	    
	    public boolean isDeclared(String id){
	    	return symbolTable.get(id) != null;
	    }

	public BUCOLGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BUCOLGrammarParser.ID, 0); }
		public List<TerminalNode> QL() { return getTokens(BUCOLGrammarParser.QL); }
		public TerminalNode QL(int i) {
			return getToken(BUCOLGrammarParser.QL, i);
		}
		public List<DeclaravarContext> declaravar() {
			return getRuleContexts(DeclaravarContext.class);
		}
		public DeclaravarContext declaravar(int i) {
			return getRuleContext(DeclaravarContext.class,i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			match(T__0);
			setState(27);
			match(ID);
			 program.setName(_input.LT(-1).getText());
			                               stack.push(new ArrayList<Command>()); 
			                             
			setState(29);
			match(QL);
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				declaravar();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1966080L) != 0) );
			setState(35);
			match(T__1);
			setState(36);
			match(QL);
			setState(38); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(37);
				comando();
				}
				}
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8917729935360L) != 0) );
			setState(42);
			match(T__2);
			setState(43);
			match(QL);
			setState(44);
			match(T__3);

			               program.setSymbolTable(symbolTable);
			               program.setCommandList(stack.pop());
			            
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaravarContext extends ParserRuleContext {
		public DeclarativoContext declarativo() {
			return getRuleContext(DeclarativoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(BUCOLGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(BUCOLGrammarParser.ID, i);
		}
		public TerminalNode QL() { return getToken(BUCOLGrammarParser.QL, 0); }
		public List<TerminalNode> VIRG() { return getTokens(BUCOLGrammarParser.VIRG); }
		public TerminalNode VIRG(int i) {
			return getToken(BUCOLGrammarParser.VIRG, i);
		}
		public DeclaravarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaravar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).enterDeclaravar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).exitDeclaravar(this);
		}
	}

	public final DeclaravarContext declaravar() throws RecognitionException {
		DeclaravarContext _localctx = new DeclaravarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaravar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			declarativo();
			 currentDecl.clear(); 
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(49);
				match(T__4);
				currentType = Types.NUMBER;
				}
				break;
			case T__5:
				{
				setState(51);
				match(T__5);
				currentType = Types.NUMBER;
				}
				break;
			case T__6:
				{
				setState(53);
				match(T__6);
				currentType = Types.NUMBER;
				}
				break;
			case T__7:
				{
				setState(55);
				match(T__7);
				currentType = Types.NUMBER;
				}
				break;
			case T__8:
				{
				setState(57);
				match(T__8);
				currentType = Types.TEXT;
				}
				break;
			case T__9:
				{
				setState(59);
				match(T__9);
				currentType = Types.TEXT;
				}
				break;
			case T__10:
				{
				setState(61);
				match(T__10);
				currentType = Types.TEXT;
				}
				break;
			case T__11:
				{
				setState(63);
				match(T__11);
				currentType = Types.TEXT;
				}
				break;
			case T__12:
				{
				setState(65);
				match(T__12);
				currentType = Types.BOOLEAN;
				}
				break;
			case T__13:
				{
				setState(67);
				match(T__13);
				currentType = Types.BOOLEAN;
				}
				break;
			case T__14:
				{
				setState(69);
				match(T__14);
				currentType = Types.BOOLEAN;
				}
				break;
			case T__15:
				{
				setState(71);
				match(T__15);
				currentType = Types.BOOLEAN;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 updateType(); 
			setState(76);
			match(ID);
			 currentDecl.add(new Var(_input.LT(-1).getText()));
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(78);
				match(VIRG);
				setState(79);
				match(ID);
				 currentDecl.add(new Var(_input.LT(-1).getText()));
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 updateType(); 
			setState(87);
			match(QL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarativoContext extends ParserRuleContext {
		public DeclarativoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declarativo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).enterDeclarativo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).exitDeclarativo(this);
		}
	}

	public final DeclarativoContext declarativo() throws RecognitionException {
		DeclarativoContext _localctx = new DeclarativoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declarativo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1966080L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	@SuppressWarnings("CheckReturnValue")
	public static class ComandoContext extends ParserRuleContext {
		public CmdAttribContext cmdAttrib() {
			return getRuleContext(CmdAttribContext.class,0);
		}
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public CmdEscritaContext cmdEscrita() {
			return getRuleContext(CmdEscritaContext.class,0);
		}
		public CmdIFContext cmdIF() {
			return getRuleContext(CmdIFContext.class,0);
		}
		public CmdWhileContext cmdWhile() {
			return getRuleContext(CmdWhileContext.class,0);
		}
		public CmdDoWhileContext cmdDoWhile() {
			return getRuleContext(CmdDoWhileContext.class,0);
		}
		public ComandoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comando; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).enterComando(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).exitComando(this);
		}
	}

	public final ComandoContext comando() throws RecognitionException {
		ComandoContext _localctx = new ComandoContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_comando);
		try {
			setState(97);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				cmdAttrib();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(92);
				cmdLeitura();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(93);
				cmdEscrita();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(94);
				cmdIF();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(95);
				cmdWhile();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(96);
				cmdDoWhile();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdIFContext extends ParserRuleContext {
		public TerminalNode DP() { return getToken(BUCOLGrammarParser.DP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(BUCOLGrammarParser.OPREL, 0); }
		public List<TerminalNode> QL() { return getTokens(BUCOLGrammarParser.QL); }
		public TerminalNode QL(int i) {
			return getToken(BUCOLGrammarParser.QL, i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdIFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdIF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).enterCmdIF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).exitCmdIF(this);
		}
	}

	public final CmdIFContext cmdIF() throws RecognitionException {
		CmdIFContext _localctx = new CmdIFContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdIF);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__20);
			 stack.push(new ArrayList<Command>());
			                      strExpr = "";
			                      currentIfCommand = new IfCommand();
			                    
			setState(101);
			match(DP);
			setState(102);
			expr();
			setState(103);
			match(OPREL);
			 strExpr += _input.LT(-1).getText(); 
			setState(105);
			expr();
			 currentIfCommand.setExpression(strExpr); 
			setState(107);
			match(T__21);
			setState(108);
			match(QL);
			setState(110); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(109);
				comando();
				}
				}
				setState(112); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8917729935360L) != 0) );
			 
			                  currentIfCommand.setTrueList(stack.pop());                            
			               
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(115);
				match(T__22);
				 stack.push(new ArrayList<Command>()); 
				setState(117);
				match(QL);
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(118);
					comando();
					}
					}
					setState(121); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8917729935360L) != 0) );
				 currentIfCommand.setFalseList(stack.pop()); 
				}
			}

			setState(127);
			match(T__23);
			setState(128);
			match(QL);

			               	   stack.peek().add(currentIfCommand);
			               
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdWhileContext extends ParserRuleContext {
		public TerminalNode DP() { return getToken(BUCOLGrammarParser.DP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(BUCOLGrammarParser.OPREL, 0); }
		public List<TerminalNode> QL() { return getTokens(BUCOLGrammarParser.QL); }
		public TerminalNode QL(int i) {
			return getToken(BUCOLGrammarParser.QL, i);
		}
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).enterCmdWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).exitCmdWhile(this);
		}
	}

	public final CmdWhileContext cmdWhile() throws RecognitionException {
		CmdWhileContext _localctx = new CmdWhileContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(T__24);
			 stack.push(new ArrayList<Command>());
			                      strExpr = "";
			                      currentWhileCommand = new WhileCommand();
			                    
			setState(133);
			match(DP);
			setState(134);
			expr();
			setState(135);
			match(OPREL);
			 strExpr += _input.LT(-1).getText(); 
			setState(137);
			expr();
			 currentWhileCommand.setExpression(strExpr); 
			setState(139);
			match(T__25);
			setState(140);
			match(QL);
			setState(142); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(141);
				comando();
				}
				}
				setState(144); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8917729935360L) != 0) );
			 
			               currentWhileCommand.setCommandList(stack.pop());                            
			            
			setState(147);
			match(T__26);
			setState(148);
			match(QL);

			                  stack.peek().add(currentWhileCommand);
			            
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdDoWhileContext extends ParserRuleContext {
		public List<TerminalNode> QL() { return getTokens(BUCOLGrammarParser.QL); }
		public TerminalNode QL(int i) {
			return getToken(BUCOLGrammarParser.QL, i);
		}
		public TerminalNode DP() { return getToken(BUCOLGrammarParser.DP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OPREL() { return getToken(BUCOLGrammarParser.OPREL, 0); }
		public List<ComandoContext> comando() {
			return getRuleContexts(ComandoContext.class);
		}
		public ComandoContext comando(int i) {
			return getRuleContext(ComandoContext.class,i);
		}
		public CmdDoWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdDoWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).enterCmdDoWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).exitCmdDoWhile(this);
		}
	}

	public final CmdDoWhileContext cmdDoWhile() throws RecognitionException {
		CmdDoWhileContext _localctx = new CmdDoWhileContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdDoWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__27);
			 stack.push(new ArrayList<Command>());
			                      currentWhileCommand = new WhileCommand();
			                    
			setState(153);
			match(QL);
			setState(155); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(154);
				comando();
				}
				}
				setState(157); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8917729935360L) != 0) );
			 
			               currentWhileCommand.setCommandList(stack.pop());    
			               strExpr = "";                        
			            
			setState(160);
			match(T__28);
			setState(161);
			match(DP);
			setState(162);
			expr();
			setState(163);
			match(OPREL);
			 strExpr += _input.LT(-1).getText(); 
			setState(165);
			expr();
			setState(166);
			match(QL);
			 currentWhileCommand.setExpression(strExpr); 
			setState(168);
			match(T__26);
			setState(169);
			match(QL);

			                  stack.peek().add(currentWhileCommand);
			            
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdAttribContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode VIRG() { return getToken(BUCOLGrammarParser.VIRG, 0); }
		public TerminalNode OP_AT() { return getToken(BUCOLGrammarParser.OP_AT, 0); }
		public TerminalNode ID() { return getToken(BUCOLGrammarParser.ID, 0); }
		public TerminalNode QL() { return getToken(BUCOLGrammarParser.QL, 0); }
		public CmdAttribContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAttrib; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).enterCmdAttrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).exitCmdAttrib(this);
		}
	}

	public final CmdAttribContext cmdAttrib() throws RecognitionException {
		CmdAttribContext _localctx = new CmdAttribContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdAttrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			strExpr = "";
			setState(173);
			expr();

			                  AtribCommand cmdRead = new AtribCommand();
			                  cmdRead.setRightSide(strExpr);
			               
			setState(175);
			match(VIRG);
			setState(176);
			match(OP_AT);
			setState(177);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new BUCOLSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                   }
			                   symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                   leftType = symbolTable.get(_input.LT(-1).getText()).getType();
			                   cmdRead.setLeftSide(symbolTable.get(_input.LT(-1).getText()));
			                 
			setState(179);
			match(QL);

			                 System.out.println("Left  Side Expression Type = "+leftType);
			                 System.out.println("Right Side Expression Type = "+rightType);
			                 if (leftType.getValue() < rightType.getValue()){
			                    throw new BUCOLSemanticException("Type Mismatchig on Assignment");
			                 }
			                 stack.peek().add(cmdRead);
			              
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BUCOLGrammarParser.ID, 0); }
		public TerminalNode PI() { return getToken(BUCOLGrammarParser.PI, 0); }
		public TerminalNode QL() { return getToken(BUCOLGrammarParser.QL, 0); }
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).enterCmdLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).exitCmdLeitura(this);
		}
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new BUCOLSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                    }
			                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                    Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
			                    stack.peek().add(cmdRead);
			                  
			setState(184);
			match(PI);
			setState(185);
			match(QL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEscritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(BUCOLGrammarParser.AP, 0); }
		public TerminalNode FP() { return getToken(BUCOLGrammarParser.FP, 0); }
		public TerminalNode QL() { return getToken(BUCOLGrammarParser.QL, 0); }
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).enterCmdEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).exitCmdEscrita(this);
		}
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			match(T__29);
			setState(188);
			match(AP);
			{
			setState(189);
			termo();
			 Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
			                         stack.peek().add(cmdWrite);
			                       
			}
			setState(192);
			match(FP);
			setState(193);
			match(QL);
			 rightType = null;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExprlContext exprl() {
			return getRuleContext(ExprlContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			termo();
			 strExpr += _input.LT(-1).getText(); 
			setState(198);
			exprl();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(BUCOLGrammarParser.ID, 0); }
		public TerminalNode NUM() { return getToken(BUCOLGrammarParser.NUM, 0); }
		public TerminalNode TEXTO() { return getToken(BUCOLGrammarParser.TEXTO, 0); }
		public TerminalNode BOOLEAN() { return getToken(BUCOLGrammarParser.BOOLEAN, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_termo);
		try {
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				match(ID);
				 if (!isDeclared(_input.LT(-1).getText())) {
				                       throw new BUCOLSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
				                    }
				                    if (!symbolTable.get(_input.LT(-1).getText()).isInitialized()){
				                       throw new BUCOLSemanticException("Variable "+_input.LT(-1).getText()+" has no value assigned");
				                    }
				                    if (rightType == null){
				                       rightType = symbolTable.get(_input.LT(-1).getText()).getType();
				                       //System.out.println("Encontrei pela 1a vez uma variavel = "+rightType);
				                    }   
				                    else{
				                       if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()){
				                          rightType = symbolTable.get(_input.LT(-1).getText()).getType();
				                          //System.out.println("Ja havia tipo declarado e mudou para = "+rightType);
				                          
				                       }
				                    }
				                  
				}
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				match(NUM);
				  if (rightType == null) {
							 				rightType = Types.NUMBER;
							 				//System.out.println("Encontrei um numero pela 1a vez "+rightType);
							            }
							            else{
							                if (rightType.getValue() < Types.NUMBER.getValue()){			                    			                   
							                	rightType = Types.NUMBER;
							                	//System.out.println("Mudei o tipo para Number = "+rightType);
							                }
							            }
							         
				}
				break;
			case TEXTO:
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
				match(TEXTO);
				  if (rightType == null) {
							 				rightType = Types.TEXT;
							 				//System.out.println("Encontrei pela 1a vez um texto ="+ rightType);
							            }
							            else{
							                if (rightType.getValue() < Types.TEXT.getValue()){			                    
							                	rightType = Types.TEXT;
							                	//System.out.println("Mudei o tipo para TEXT = "+rightType);
							                }
							            }
							         
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(206);
				match(BOOLEAN);
				  if (rightType == null) {
							 				rightType = Types.BOOLEAN;
							 				//System.out.println("Encontrei pela 1a vez um booleano ="+ rightType);
							            }
							            else{
							                if (rightType.getValue() < Types.BOOLEAN.getValue()){			                    
							                	rightType = Types.BOOLEAN;
							                	//System.out.println("Mudei o tipo para BOOLEAN = "+rightType);
							                }
							            }
							         
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprlContext extends ParserRuleContext {
		public List<TerminalNode> OP() { return getTokens(BUCOLGrammarParser.OP); }
		public TerminalNode OP(int i) {
			return getToken(BUCOLGrammarParser.OP, i);
		}
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public ExprlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).enterExprl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).exitExprl(this);
		}
	}

	public final ExprlContext exprl() throws RecognitionException {
		ExprlContext _localctx = new ExprlContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(210);
				match(OP);
				 strExpr += _input.LT(-1).getText(); 
				setState(212);
				termo();
				 strExpr += _input.LT(-1).getText(); 
				}
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		"\u0004\u0001,\u00dd\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0004\u0000 \b\u0000\u000b\u0000\f\u0000!\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0004\u0000\'\b\u0000\u000b\u0000\f\u0000(\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"J\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001R\b\u0001\n\u0001\f\u0001U\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003b\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004"+
		"o\b\u0004\u000b\u0004\f\u0004p\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0004\u0004x\b\u0004\u000b\u0004\f\u0004y\u0001\u0004"+
		"\u0001\u0004\u0003\u0004~\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0004\u0005\u008f\b\u0005\u000b\u0005\f\u0005\u0090\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0004\u0006\u009c\b\u0006\u000b\u0006\f\u0006\u009d"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00d1\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0001\f\u0005\f\u00d8\b\f\n\f\f\f\u00db\t\f\u0001\f\u0000\u0000\r\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u0000\u0001"+
		"\u0001\u0000\u0011\u0014\u00eb\u0000\u001a\u0001\u0000\u0000\u0000\u0002"+
		"/\u0001\u0000\u0000\u0000\u0004Y\u0001\u0000\u0000\u0000\u0006a\u0001"+
		"\u0000\u0000\u0000\bc\u0001\u0000\u0000\u0000\n\u0083\u0001\u0000\u0000"+
		"\u0000\f\u0097\u0001\u0000\u0000\u0000\u000e\u00ac\u0001\u0000\u0000\u0000"+
		"\u0010\u00b6\u0001\u0000\u0000\u0000\u0012\u00bb\u0001\u0000\u0000\u0000"+
		"\u0014\u00c4\u0001\u0000\u0000\u0000\u0016\u00d0\u0001\u0000\u0000\u0000"+
		"\u0018\u00d9\u0001\u0000\u0000\u0000\u001a\u001b\u0005\u0001\u0000\u0000"+
		"\u001b\u001c\u0005\"\u0000\u0000\u001c\u001d\u0006\u0000\uffff\uffff\u0000"+
		"\u001d\u001f\u0005&\u0000\u0000\u001e \u0003\u0002\u0001\u0000\u001f\u001e"+
		"\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\u001f\u0001\u0000"+
		"\u0000\u0000!\"\u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#$\u0005"+
		"\u0002\u0000\u0000$&\u0005&\u0000\u0000%\'\u0003\u0006\u0003\u0000&%\u0001"+
		"\u0000\u0000\u0000\'(\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000"+
		"()\u0001\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*+\u0005\u0003\u0000"+
		"\u0000+,\u0005&\u0000\u0000,-\u0005\u0004\u0000\u0000-.\u0006\u0000\uffff"+
		"\uffff\u0000.\u0001\u0001\u0000\u0000\u0000/0\u0003\u0004\u0002\u0000"+
		"0I\u0006\u0001\uffff\uffff\u000012\u0005\u0005\u0000\u00002J\u0006\u0001"+
		"\uffff\uffff\u000034\u0005\u0006\u0000\u00004J\u0006\u0001\uffff\uffff"+
		"\u000056\u0005\u0007\u0000\u00006J\u0006\u0001\uffff\uffff\u000078\u0005"+
		"\b\u0000\u00008J\u0006\u0001\uffff\uffff\u00009:\u0005\t\u0000\u0000:"+
		"J\u0006\u0001\uffff\uffff\u0000;<\u0005\n\u0000\u0000<J\u0006\u0001\uffff"+
		"\uffff\u0000=>\u0005\u000b\u0000\u0000>J\u0006\u0001\uffff\uffff\u0000"+
		"?@\u0005\f\u0000\u0000@J\u0006\u0001\uffff\uffff\u0000AB\u0005\r\u0000"+
		"\u0000BJ\u0006\u0001\uffff\uffff\u0000CD\u0005\u000e\u0000\u0000DJ\u0006"+
		"\u0001\uffff\uffff\u0000EF\u0005\u000f\u0000\u0000FJ\u0006\u0001\uffff"+
		"\uffff\u0000GH\u0005\u0010\u0000\u0000HJ\u0006\u0001\uffff\uffff\u0000"+
		"I1\u0001\u0000\u0000\u0000I3\u0001\u0000\u0000\u0000I5\u0001\u0000\u0000"+
		"\u0000I7\u0001\u0000\u0000\u0000I9\u0001\u0000\u0000\u0000I;\u0001\u0000"+
		"\u0000\u0000I=\u0001\u0000\u0000\u0000I?\u0001\u0000\u0000\u0000IA\u0001"+
		"\u0000\u0000\u0000IC\u0001\u0000\u0000\u0000IE\u0001\u0000\u0000\u0000"+
		"IG\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KL\u0006\u0001\uffff"+
		"\uffff\u0000LM\u0005\"\u0000\u0000MS\u0006\u0001\uffff\uffff\u0000NO\u0005"+
		"%\u0000\u0000OP\u0005\"\u0000\u0000PR\u0006\u0001\uffff\uffff\u0000QN"+
		"\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000"+
		"\u0000ST\u0001\u0000\u0000\u0000TV\u0001\u0000\u0000\u0000US\u0001\u0000"+
		"\u0000\u0000VW\u0006\u0001\uffff\uffff\u0000WX\u0005&\u0000\u0000X\u0003"+
		"\u0001\u0000\u0000\u0000YZ\u0007\u0000\u0000\u0000Z\u0005\u0001\u0000"+
		"\u0000\u0000[b\u0003\u000e\u0007\u0000\\b\u0003\u0010\b\u0000]b\u0003"+
		"\u0012\t\u0000^b\u0003\b\u0004\u0000_b\u0003\n\u0005\u0000`b\u0003\f\u0006"+
		"\u0000a[\u0001\u0000\u0000\u0000a\\\u0001\u0000\u0000\u0000a]\u0001\u0000"+
		"\u0000\u0000a^\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000a`\u0001"+
		"\u0000\u0000\u0000b\u0007\u0001\u0000\u0000\u0000cd\u0005\u0015\u0000"+
		"\u0000de\u0006\u0004\uffff\uffff\u0000ef\u0005*\u0000\u0000fg\u0003\u0014"+
		"\n\u0000gh\u0005!\u0000\u0000hi\u0006\u0004\uffff\uffff\u0000ij\u0003"+
		"\u0014\n\u0000jk\u0006\u0004\uffff\uffff\u0000kl\u0005\u0016\u0000\u0000"+
		"ln\u0005&\u0000\u0000mo\u0003\u0006\u0003\u0000nm\u0001\u0000\u0000\u0000"+
		"op\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000"+
		"\u0000qr\u0001\u0000\u0000\u0000r}\u0006\u0004\uffff\uffff\u0000st\u0005"+
		"\u0017\u0000\u0000tu\u0006\u0004\uffff\uffff\u0000uw\u0005&\u0000\u0000"+
		"vx\u0003\u0006\u0003\u0000wv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000"+
		"\u0000yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0001\u0000"+
		"\u0000\u0000{|\u0006\u0004\uffff\uffff\u0000|~\u0001\u0000\u0000\u0000"+
		"}s\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u007f\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0005\u0018\u0000\u0000\u0080\u0081\u0005&\u0000"+
		"\u0000\u0081\u0082\u0006\u0004\uffff\uffff\u0000\u0082\t\u0001\u0000\u0000"+
		"\u0000\u0083\u0084\u0005\u0019\u0000\u0000\u0084\u0085\u0006\u0005\uffff"+
		"\uffff\u0000\u0085\u0086\u0005*\u0000\u0000\u0086\u0087\u0003\u0014\n"+
		"\u0000\u0087\u0088\u0005!\u0000\u0000\u0088\u0089\u0006\u0005\uffff\uffff"+
		"\u0000\u0089\u008a\u0003\u0014\n\u0000\u008a\u008b\u0006\u0005\uffff\uffff"+
		"\u0000\u008b\u008c\u0005\u001a\u0000\u0000\u008c\u008e\u0005&\u0000\u0000"+
		"\u008d\u008f\u0003\u0006\u0003\u0000\u008e\u008d\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0006\u0005\uffff\uffff\u0000\u0093\u0094\u0005\u001b\u0000"+
		"\u0000\u0094\u0095\u0005&\u0000\u0000\u0095\u0096\u0006\u0005\uffff\uffff"+
		"\u0000\u0096\u000b\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u001c\u0000"+
		"\u0000\u0098\u0099\u0006\u0006\uffff\uffff\u0000\u0099\u009b\u0005&\u0000"+
		"\u0000\u009a\u009c\u0003\u0006\u0003\u0000\u009b\u009a\u0001\u0000\u0000"+
		"\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000"+
		"\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000"+
		"\u0000\u009f\u00a0\u0006\u0006\uffff\uffff\u0000\u00a0\u00a1\u0005\u001d"+
		"\u0000\u0000\u00a1\u00a2\u0005*\u0000\u0000\u00a2\u00a3\u0003\u0014\n"+
		"\u0000\u00a3\u00a4\u0005!\u0000\u0000\u00a4\u00a5\u0006\u0006\uffff\uffff"+
		"\u0000\u00a5\u00a6\u0003\u0014\n\u0000\u00a6\u00a7\u0005&\u0000\u0000"+
		"\u00a7\u00a8\u0006\u0006\uffff\uffff\u0000\u00a8\u00a9\u0005\u001b\u0000"+
		"\u0000\u00a9\u00aa\u0005&\u0000\u0000\u00aa\u00ab\u0006\u0006\uffff\uffff"+
		"\u0000\u00ab\r\u0001\u0000\u0000\u0000\u00ac\u00ad\u0006\u0007\uffff\uffff"+
		"\u0000\u00ad\u00ae\u0003\u0014\n\u0000\u00ae\u00af\u0006\u0007\uffff\uffff"+
		"\u0000\u00af\u00b0\u0005%\u0000\u0000\u00b0\u00b1\u0005 \u0000\u0000\u00b1"+
		"\u00b2\u0005\"\u0000\u0000\u00b2\u00b3\u0006\u0007\uffff\uffff\u0000\u00b3"+
		"\u00b4\u0005&\u0000\u0000\u00b4\u00b5\u0006\u0007\uffff\uffff\u0000\u00b5"+
		"\u000f\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005\"\u0000\u0000\u00b7\u00b8"+
		"\u0006\b\uffff\uffff\u0000\u00b8\u00b9\u0005)\u0000\u0000\u00b9\u00ba"+
		"\u0005&\u0000\u0000\u00ba\u0011\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005"+
		"\u001e\u0000\u0000\u00bc\u00bd\u0005\'\u0000\u0000\u00bd\u00be\u0003\u0016"+
		"\u000b\u0000\u00be\u00bf\u0006\t\uffff\uffff\u0000\u00bf\u00c0\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0005(\u0000\u0000\u00c1\u00c2\u0005&\u0000\u0000"+
		"\u00c2\u00c3\u0006\t\uffff\uffff\u0000\u00c3\u0013\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\u0003\u0016\u000b\u0000\u00c5\u00c6\u0006\n\uffff\uffff\u0000"+
		"\u00c6\u00c7\u0003\u0018\f\u0000\u00c7\u0015\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c9\u0005\"\u0000\u0000\u00c9\u00d1\u0006\u000b\uffff\uffff\u0000\u00ca"+
		"\u00cb\u0005#\u0000\u0000\u00cb\u00d1\u0006\u000b\uffff\uffff\u0000\u00cc"+
		"\u00cd\u0005+\u0000\u0000\u00cd\u00d1\u0006\u000b\uffff\uffff\u0000\u00ce"+
		"\u00cf\u0005$\u0000\u0000\u00cf\u00d1\u0006\u000b\uffff\uffff\u0000\u00d0"+
		"\u00c8\u0001\u0000\u0000\u0000\u00d0\u00ca\u0001\u0000\u0000\u0000\u00d0"+
		"\u00cc\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d1"+
		"\u0017\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005\u001f\u0000\u0000\u00d3"+
		"\u00d4\u0006\f\uffff\uffff\u0000\u00d4\u00d5\u0003\u0016\u000b\u0000\u00d5"+
		"\u00d6\u0006\f\uffff\uffff\u0000\u00d6\u00d8\u0001\u0000\u0000\u0000\u00d7"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da"+
		"\u0019\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\f!"+
		"(ISapy}\u0090\u009d\u00d0\u00d9";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}