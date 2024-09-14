// Generated from BUCOLGrammar.g4 by ANTLR 4.13.2
package io.compiler.core;

	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.HashMap;
   import java.util.Map;
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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		OP=32, OP_AT=33, OPREL=34, ID=35, NUM=36, BOOLEAN=37, VIRG=38, QL=39, 
		AP=40, FP=41, PI=42, DP=43, TEXTO=44, WS=45;
	public static final int
		RULE_programa = 0, RULE_declaravar = 1, RULE_declarativo = 2, RULE_comando = 3, 
		RULE_cmdIF = 4, RULE_cmdWhile = 5, RULE_cmdDoWhile = 6, RULE_cmdAttrib = 7, 
		RULE_cmdLeitura = 8, RULE_cmdEscrita = 9, RULE_cmdEscritaNL = 10, RULE_expr = 11, 
		RULE_termo = 12, RULE_exprl = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaravar", "declarativo", "comando", "cmdIF", "cmdWhile", 
			"cmdDoWhile", "cmdAttrib", "cmdLeitura", "cmdEscrita", "cmdEscritaNL", 
			"expr", "termo", "exprl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'poema'", "'inicio'", "'fim'", "'fimpoema'", "'integro'", "'integros'", 
			"'integra'", "'integras'", "'verboso'", "'verbosos'", "'verbosa'", "'verbosas'", 
			"'discreto'", "'discretos'", "'discreta'", "'discretas'", "'Atentai ao'", 
			"'Atentai \\u00E0'", "'Atentai aos'", "'Atentai \\u00E0s'", "'Ao acaso, tendo'", 
			"', tenho que'", "'Mas, se o destino n\\u00E3o permite,'", "'E esta \\u00E9 a solu\\u00E7\\u00E3o para minhas indaga\\u00E7\\u00F5es'", 
			"'Continuamente, ao caso de'", "', busco'", "'O que continuamente trar\\u00E1 meu sossego'", 
			"'Busco'", "'Continuamente, em caso de'", "'Rogai ao mundo'", "'Rogai ao mundo!'", 
			null, null, null, null, null, null, "','", "'\\n'", "'('", "')'", "'?'", 
			"':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "OP", "OP_AT", "OPREL", 
			"ID", "NUM", "BOOLEAN", "VIRG", "QL", "AP", "FP", "PI", "DP", "TEXTO", 
			"WS"
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

	    public static void checkAllInitialized(HashMap<String, Var> symbolTable) {
	        for (Map.Entry<String, Var> entry : symbolTable.entrySet()) {
	            String key = entry.getKey();
	            Var var = entry.getValue();

	            // Check if the variable is initialized
	            if (!var.isInitialized()) {
	                System.out.println("Ó, autor, a variável '" + key + "' foi declarada, contudo não inicializada.");
	            }
	        }
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
			setState(28);
			match(T__0);
			setState(29);
			match(ID);
			 program.setName(_input.LT(-1).getText());
			                               stack.push(new ArrayList<Command>()); 
			                             
			setState(31);
			match(QL);
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				declaravar();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1966080L) != 0) );
			setState(37);
			match(T__1);
			setState(38);
			match(QL);
			setState(40); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(39);
				comando();
				}
				}
				setState(42); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17836229525504L) != 0) );
			setState(44);
			match(T__2);
			setState(45);
			match(QL);
			setState(46);
			match(T__3);

			               program.setSymbolTable(symbolTable);
			               program.setCommandList(stack.pop());
			               checkAllInitialized(symbolTable);
			            
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
			setState(49);
			declarativo();
			 currentDecl.clear(); 
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(51);
				match(T__4);
				currentType = Types.NUMBER;
				}
				break;
			case T__5:
				{
				setState(53);
				match(T__5);
				currentType = Types.NUMBER;
				}
				break;
			case T__6:
				{
				setState(55);
				match(T__6);
				currentType = Types.NUMBER;
				}
				break;
			case T__7:
				{
				setState(57);
				match(T__7);
				currentType = Types.NUMBER;
				}
				break;
			case T__8:
				{
				setState(59);
				match(T__8);
				currentType = Types.TEXT;
				}
				break;
			case T__9:
				{
				setState(61);
				match(T__9);
				currentType = Types.TEXT;
				}
				break;
			case T__10:
				{
				setState(63);
				match(T__10);
				currentType = Types.TEXT;
				}
				break;
			case T__11:
				{
				setState(65);
				match(T__11);
				currentType = Types.TEXT;
				}
				break;
			case T__12:
				{
				setState(67);
				match(T__12);
				currentType = Types.BOOLEAN;
				}
				break;
			case T__13:
				{
				setState(69);
				match(T__13);
				currentType = Types.BOOLEAN;
				}
				break;
			case T__14:
				{
				setState(71);
				match(T__14);
				currentType = Types.BOOLEAN;
				}
				break;
			case T__15:
				{
				setState(73);
				match(T__15);
				currentType = Types.BOOLEAN;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 updateType(); 
			setState(78);
			match(ID);
			 currentDecl.add(new Var(_input.LT(-1).getText()));
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(80);
				match(VIRG);
				setState(81);
				match(ID);
				 currentDecl.add(new Var(_input.LT(-1).getText()));
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 updateType(); 
			setState(89);
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
			setState(91);
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
		public CmdEscritaNLContext cmdEscritaNL() {
			return getRuleContext(CmdEscritaNLContext.class,0);
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
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				cmdAttrib();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				cmdLeitura();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				cmdEscrita();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				cmdEscritaNL();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(97);
				cmdIF();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(98);
				cmdWhile();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(99);
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
			setState(102);
			match(T__20);
			 stack.push(new ArrayList<Command>());
			                      strExpr = "";
			                      currentIfCommand = new IfCommand();
			                    
			setState(104);
			match(DP);
			setState(105);
			expr();
			setState(106);
			match(OPREL);
			 strExpr += _input.LT(-1).getText(); 
			setState(108);
			expr();
			 currentIfCommand.setExpression(strExpr); 
			setState(110);
			match(T__21);
			setState(111);
			match(QL);
			setState(113); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(112);
				comando();
				}
				}
				setState(115); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17836229525504L) != 0) );
			 
			                  currentIfCommand.setTrueList(stack.pop());                            
			               
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__22) {
				{
				setState(118);
				match(T__22);
				 stack.push(new ArrayList<Command>()); 
				setState(120);
				match(QL);
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(121);
					comando();
					}
					}
					setState(124); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17836229525504L) != 0) );
				 currentIfCommand.setFalseList(stack.pop()); 
				}
			}

			setState(130);
			match(T__23);
			setState(131);
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
			setState(134);
			match(T__24);
			 stack.push(new ArrayList<Command>());
			                      strExpr = "";
			                      currentWhileCommand = new WhileCommand();
			                    
			setState(136);
			match(DP);
			setState(137);
			expr();
			setState(138);
			match(OPREL);
			 strExpr += _input.LT(-1).getText(); 
			setState(140);
			expr();
			 currentWhileCommand.setExpression(strExpr); 
			setState(142);
			match(T__25);
			setState(143);
			match(QL);
			setState(145); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(144);
				comando();
				}
				}
				setState(147); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17836229525504L) != 0) );
			 
			               currentWhileCommand.setCommandList(stack.pop());                            
			            
			setState(150);
			match(T__26);
			setState(151);
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
			setState(154);
			match(T__27);
			 stack.push(new ArrayList<Command>());
			                      currentWhileCommand = new WhileCommand();
			                    
			setState(156);
			match(QL);
			setState(158); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(157);
				comando();
				}
				}
				setState(160); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 17836229525504L) != 0) );
			 
			               currentWhileCommand.setCommandList(stack.pop());    
			               strExpr = "";                        
			            
			setState(163);
			match(T__28);
			setState(164);
			match(DP);
			setState(165);
			expr();
			setState(166);
			match(OPREL);
			 strExpr += _input.LT(-1).getText(); 
			setState(168);
			expr();
			setState(169);
			match(QL);
			 currentWhileCommand.setExpression(strExpr); 
			setState(171);
			match(T__26);
			setState(172);
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
			setState(176);
			expr();

			                  AtribCommand cmdRead = new AtribCommand();
			                  cmdRead.setRightSide(strExpr);
			               
			setState(178);
			match(VIRG);
			setState(179);
			match(OP_AT);
			setState(180);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new BUCOLSemanticException("Ó autor, variável utilizada não foi declarada: "+_input.LT(-1).getText());
			                   }
			                   symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                   leftType = symbolTable.get(_input.LT(-1).getText()).getType();
			                   cmdRead.setLeftSide(symbolTable.get(_input.LT(-1).getText()));
			                 
			setState(182);
			match(QL);

			                 System.out.println("Left  Side Expression Type = "+leftType);
			                 System.out.println("Right Side Expression Type = "+rightType);
			                 if (leftType.getValue() < rightType.getValue()){
			                    throw new BUCOLSemanticException("Ó autor, variável "+_input.LT(-1).getText()+" possui tipos distintos:"+ leftType +" e "+ rightType);
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
			setState(185);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new BUCOLSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                    }
			                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                    Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
			                    stack.peek().add(cmdRead);
			                  
			setState(187);
			match(PI);
			setState(188);
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
		public TerminalNode DP() { return getToken(BUCOLGrammarParser.DP, 0); }
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
			setState(190);
			match(T__29);
			setState(191);
			match(DP);
			{
			setState(192);
			termo();
			 Command cmdWrite = new WriteCommand(_input.LT(-1).getText(), false);
			                         stack.peek().add(cmdWrite);
			                       
			}
			setState(195);
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
	public static class CmdEscritaNLContext extends ParserRuleContext {
		public TerminalNode DP() { return getToken(BUCOLGrammarParser.DP, 0); }
		public TerminalNode QL() { return getToken(BUCOLGrammarParser.QL, 0); }
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public CmdEscritaNLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscritaNL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).enterCmdEscritaNL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BUCOLGrammarListener ) ((BUCOLGrammarListener)listener).exitCmdEscritaNL(this);
		}
	}

	public final CmdEscritaNLContext cmdEscritaNL() throws RecognitionException {
		CmdEscritaNLContext _localctx = new CmdEscritaNLContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdEscritaNL);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(T__30);
			setState(199);
			match(DP);
			{
			setState(200);
			termo();
			 Command cmdWrite = new WriteCommand(_input.LT(-1).getText(), true);
			                         stack.peek().add(cmdWrite);
			                       
			}
			setState(203);
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
		enterRule(_localctx, 22, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			termo();
			 strExpr += _input.LT(-1).getText(); 
			setState(208);
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
		enterRule(_localctx, 24, RULE_termo);
		try {
			setState(218);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				match(ID);
				 if (!isDeclared(_input.LT(-1).getText())) {
				                       throw new BUCOLSemanticException("Ó autor, tentais utilizar de uma variável não declarada: "+_input.LT(-1).getText());
				                    }
				                    if (!symbolTable.get(_input.LT(-1).getText()).isInitialized()){
				                       throw new BUCOLSemanticException("Ó autor, tentais utilizar de uma variável sem valor: "+_input.LT(-1).getText());
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
				setState(212);
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
				setState(214);
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
				setState(216);
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
		enterRule(_localctx, 26, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(220);
				match(OP);
				 strExpr += _input.LT(-1).getText(); 
				setState(222);
				termo();
				 strExpr += _input.LT(-1).getText(); 
				}
				}
				setState(229);
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
		"\u0004\u0001-\u00e7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0004\u0000\"\b\u0000\u000b\u0000\f\u0000#\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0004\u0000)\b\u0000\u000b\u0000\f\u0000*\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001L\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u0001T\b\u0001\n\u0001\f\u0001W\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003e\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0004\u0004r\b\u0004\u000b\u0004\f\u0004s\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0004\u0004{\b\u0004\u000b"+
		"\u0004\f\u0004|\u0001\u0004\u0001\u0004\u0003\u0004\u0081\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0004\u0005\u0092\b\u0005\u000b\u0005\f"+
		"\u0005\u0093\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006\u009f\b\u0006"+
		"\u000b\u0006\f\u0006\u00a0\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u00db\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00e2"+
		"\b\r\n\r\f\r\u00e5\t\r\u0001\r\u0000\u0000\u000e\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0001\u0001\u0000"+
		"\u0011\u0014\u00f5\u0000\u001c\u0001\u0000\u0000\u0000\u00021\u0001\u0000"+
		"\u0000\u0000\u0004[\u0001\u0000\u0000\u0000\u0006d\u0001\u0000\u0000\u0000"+
		"\bf\u0001\u0000\u0000\u0000\n\u0086\u0001\u0000\u0000\u0000\f\u009a\u0001"+
		"\u0000\u0000\u0000\u000e\u00af\u0001\u0000\u0000\u0000\u0010\u00b9\u0001"+
		"\u0000\u0000\u0000\u0012\u00be\u0001\u0000\u0000\u0000\u0014\u00c6\u0001"+
		"\u0000\u0000\u0000\u0016\u00ce\u0001\u0000\u0000\u0000\u0018\u00da\u0001"+
		"\u0000\u0000\u0000\u001a\u00e3\u0001\u0000\u0000\u0000\u001c\u001d\u0005"+
		"\u0001\u0000\u0000\u001d\u001e\u0005#\u0000\u0000\u001e\u001f\u0006\u0000"+
		"\uffff\uffff\u0000\u001f!\u0005\'\u0000\u0000 \"\u0003\u0002\u0001\u0000"+
		"! \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000"+
		"\u0000#$\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%&\u0005\u0002"+
		"\u0000\u0000&(\u0005\'\u0000\u0000\')\u0003\u0006\u0003\u0000(\'\u0001"+
		"\u0000\u0000\u0000)*\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000"+
		"*+\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,-\u0005\u0003\u0000"+
		"\u0000-.\u0005\'\u0000\u0000./\u0005\u0004\u0000\u0000/0\u0006\u0000\uffff"+
		"\uffff\u00000\u0001\u0001\u0000\u0000\u000012\u0003\u0004\u0002\u0000"+
		"2K\u0006\u0001\uffff\uffff\u000034\u0005\u0005\u0000\u00004L\u0006\u0001"+
		"\uffff\uffff\u000056\u0005\u0006\u0000\u00006L\u0006\u0001\uffff\uffff"+
		"\u000078\u0005\u0007\u0000\u00008L\u0006\u0001\uffff\uffff\u00009:\u0005"+
		"\b\u0000\u0000:L\u0006\u0001\uffff\uffff\u0000;<\u0005\t\u0000\u0000<"+
		"L\u0006\u0001\uffff\uffff\u0000=>\u0005\n\u0000\u0000>L\u0006\u0001\uffff"+
		"\uffff\u0000?@\u0005\u000b\u0000\u0000@L\u0006\u0001\uffff\uffff\u0000"+
		"AB\u0005\f\u0000\u0000BL\u0006\u0001\uffff\uffff\u0000CD\u0005\r\u0000"+
		"\u0000DL\u0006\u0001\uffff\uffff\u0000EF\u0005\u000e\u0000\u0000FL\u0006"+
		"\u0001\uffff\uffff\u0000GH\u0005\u000f\u0000\u0000HL\u0006\u0001\uffff"+
		"\uffff\u0000IJ\u0005\u0010\u0000\u0000JL\u0006\u0001\uffff\uffff\u0000"+
		"K3\u0001\u0000\u0000\u0000K5\u0001\u0000\u0000\u0000K7\u0001\u0000\u0000"+
		"\u0000K9\u0001\u0000\u0000\u0000K;\u0001\u0000\u0000\u0000K=\u0001\u0000"+
		"\u0000\u0000K?\u0001\u0000\u0000\u0000KA\u0001\u0000\u0000\u0000KC\u0001"+
		"\u0000\u0000\u0000KE\u0001\u0000\u0000\u0000KG\u0001\u0000\u0000\u0000"+
		"KI\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MN\u0006\u0001\uffff"+
		"\uffff\u0000NO\u0005#\u0000\u0000OU\u0006\u0001\uffff\uffff\u0000PQ\u0005"+
		"&\u0000\u0000QR\u0005#\u0000\u0000RT\u0006\u0001\uffff\uffff\u0000SP\u0001"+
		"\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000"+
		"UV\u0001\u0000\u0000\u0000VX\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000"+
		"\u0000XY\u0006\u0001\uffff\uffff\u0000YZ\u0005\'\u0000\u0000Z\u0003\u0001"+
		"\u0000\u0000\u0000[\\\u0007\u0000\u0000\u0000\\\u0005\u0001\u0000\u0000"+
		"\u0000]e\u0003\u000e\u0007\u0000^e\u0003\u0010\b\u0000_e\u0003\u0012\t"+
		"\u0000`e\u0003\u0014\n\u0000ae\u0003\b\u0004\u0000be\u0003\n\u0005\u0000"+
		"ce\u0003\f\u0006\u0000d]\u0001\u0000\u0000\u0000d^\u0001\u0000\u0000\u0000"+
		"d_\u0001\u0000\u0000\u0000d`\u0001\u0000\u0000\u0000da\u0001\u0000\u0000"+
		"\u0000db\u0001\u0000\u0000\u0000dc\u0001\u0000\u0000\u0000e\u0007\u0001"+
		"\u0000\u0000\u0000fg\u0005\u0015\u0000\u0000gh\u0006\u0004\uffff\uffff"+
		"\u0000hi\u0005+\u0000\u0000ij\u0003\u0016\u000b\u0000jk\u0005\"\u0000"+
		"\u0000kl\u0006\u0004\uffff\uffff\u0000lm\u0003\u0016\u000b\u0000mn\u0006"+
		"\u0004\uffff\uffff\u0000no\u0005\u0016\u0000\u0000oq\u0005\'\u0000\u0000"+
		"pr\u0003\u0006\u0003\u0000qp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000"+
		"\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0001\u0000"+
		"\u0000\u0000u\u0080\u0006\u0004\uffff\uffff\u0000vw\u0005\u0017\u0000"+
		"\u0000wx\u0006\u0004\uffff\uffff\u0000xz\u0005\'\u0000\u0000y{\u0003\u0006"+
		"\u0003\u0000zy\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|z\u0001"+
		"\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000"+
		"~\u007f\u0006\u0004\uffff\uffff\u0000\u007f\u0081\u0001\u0000\u0000\u0000"+
		"\u0080v\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081"+
		"\u0082\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u0018\u0000\u0000\u0083"+
		"\u0084\u0005\'\u0000\u0000\u0084\u0085\u0006\u0004\uffff\uffff\u0000\u0085"+
		"\t\u0001\u0000\u0000\u0000\u0086\u0087\u0005\u0019\u0000\u0000\u0087\u0088"+
		"\u0006\u0005\uffff\uffff\u0000\u0088\u0089\u0005+\u0000\u0000\u0089\u008a"+
		"\u0003\u0016\u000b\u0000\u008a\u008b\u0005\"\u0000\u0000\u008b\u008c\u0006"+
		"\u0005\uffff\uffff\u0000\u008c\u008d\u0003\u0016\u000b\u0000\u008d\u008e"+
		"\u0006\u0005\uffff\uffff\u0000\u008e\u008f\u0005\u001a\u0000\u0000\u008f"+
		"\u0091\u0005\'\u0000\u0000\u0090\u0092\u0003\u0006\u0003\u0000\u0091\u0090"+
		"\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0091"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0001\u0000\u0000\u0000\u0095\u0096\u0006\u0005\uffff\uffff\u0000\u0096"+
		"\u0097\u0005\u001b\u0000\u0000\u0097\u0098\u0005\'\u0000\u0000\u0098\u0099"+
		"\u0006\u0005\uffff\uffff\u0000\u0099\u000b\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0005\u001c\u0000\u0000\u009b\u009c\u0006\u0006\uffff\uffff\u0000"+
		"\u009c\u009e\u0005\'\u0000\u0000\u009d\u009f\u0003\u0006\u0003\u0000\u009e"+
		"\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0"+
		"\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0006\u0006\uffff\uffff\u0000"+
		"\u00a3\u00a4\u0005\u001d\u0000\u0000\u00a4\u00a5\u0005+\u0000\u0000\u00a5"+
		"\u00a6\u0003\u0016\u000b\u0000\u00a6\u00a7\u0005\"\u0000\u0000\u00a7\u00a8"+
		"\u0006\u0006\uffff\uffff\u0000\u00a8\u00a9\u0003\u0016\u000b\u0000\u00a9"+
		"\u00aa\u0005\'\u0000\u0000\u00aa\u00ab\u0006\u0006\uffff\uffff\u0000\u00ab"+
		"\u00ac\u0005\u001b\u0000\u0000\u00ac\u00ad\u0005\'\u0000\u0000\u00ad\u00ae"+
		"\u0006\u0006\uffff\uffff\u0000\u00ae\r\u0001\u0000\u0000\u0000\u00af\u00b0"+
		"\u0006\u0007\uffff\uffff\u0000\u00b0\u00b1\u0003\u0016\u000b\u0000\u00b1"+
		"\u00b2\u0006\u0007\uffff\uffff\u0000\u00b2\u00b3\u0005&\u0000\u0000\u00b3"+
		"\u00b4\u0005!\u0000\u0000\u00b4\u00b5\u0005#\u0000\u0000\u00b5\u00b6\u0006"+
		"\u0007\uffff\uffff\u0000\u00b6\u00b7\u0005\'\u0000\u0000\u00b7\u00b8\u0006"+
		"\u0007\uffff\uffff\u0000\u00b8\u000f\u0001\u0000\u0000\u0000\u00b9\u00ba"+
		"\u0005#\u0000\u0000\u00ba\u00bb\u0006\b\uffff\uffff\u0000\u00bb\u00bc"+
		"\u0005*\u0000\u0000\u00bc\u00bd\u0005\'\u0000\u0000\u00bd\u0011\u0001"+
		"\u0000\u0000\u0000\u00be\u00bf\u0005\u001e\u0000\u0000\u00bf\u00c0\u0005"+
		"+\u0000\u0000\u00c0\u00c1\u0003\u0018\f\u0000\u00c1\u00c2\u0006\t\uffff"+
		"\uffff\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005\'\u0000"+
		"\u0000\u00c4\u00c5\u0006\t\uffff\uffff\u0000\u00c5\u0013\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c7\u0005\u001f\u0000\u0000\u00c7\u00c8\u0005+\u0000\u0000"+
		"\u00c8\u00c9\u0003\u0018\f\u0000\u00c9\u00ca\u0006\n\uffff\uffff\u0000"+
		"\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005\'\u0000\u0000\u00cc"+
		"\u00cd\u0006\n\uffff\uffff\u0000\u00cd\u0015\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cf\u0003\u0018\f\u0000\u00cf\u00d0\u0006\u000b\uffff\uffff\u0000\u00d0"+
		"\u00d1\u0003\u001a\r\u0000\u00d1\u0017\u0001\u0000\u0000\u0000\u00d2\u00d3"+
		"\u0005#\u0000\u0000\u00d3\u00db\u0006\f\uffff\uffff\u0000\u00d4\u00d5"+
		"\u0005$\u0000\u0000\u00d5\u00db\u0006\f\uffff\uffff\u0000\u00d6\u00d7"+
		"\u0005,\u0000\u0000\u00d7\u00db\u0006\f\uffff\uffff\u0000\u00d8\u00d9"+
		"\u0005%\u0000\u0000\u00d9\u00db\u0006\f\uffff\uffff\u0000\u00da\u00d2"+
		"\u0001\u0000\u0000\u0000\u00da\u00d4\u0001\u0000\u0000\u0000\u00da\u00d6"+
		"\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u0019"+
		"\u0001\u0000\u0000\u0000\u00dc\u00dd\u0005 \u0000\u0000\u00dd\u00de\u0006"+
		"\r\uffff\uffff\u0000\u00de\u00df\u0003\u0018\f\u0000\u00df\u00e0\u0006"+
		"\r\uffff\uffff\u0000\u00e0\u00e2\u0001\u0000\u0000\u0000\u00e1\u00dc\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e5\u0001\u0000\u0000\u0000\u00e3\u00e1\u0001"+
		"\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4\u001b\u0001"+
		"\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\f#*KUds|\u0080"+
		"\u0093\u00a0\u00da\u00e3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}