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
		OP=18, OP_AT=19, OPREL=20, ID=21, NUM=22, BOOLEAN=23, VIRG=24, QL=25, 
		AP=26, FP=27, DP=28, TEXTO=29, WS=30;
	public static final int
		RULE_programa = 0, RULE_declaravar = 1, RULE_comando = 2, RULE_cmdIF = 3, 
		RULE_cmdWhile = 4, RULE_cmdAttrib = 5, RULE_cmdLeitura = 6, RULE_cmdEscrita = 7, 
		RULE_expr = 8, RULE_termo = 9, RULE_exprl = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declaravar", "comando", "cmdIF", "cmdWhile", "cmdAttrib", 
			"cmdLeitura", "cmdEscrita", "expr", "termo", "exprl"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'poema'", "'inicio'", "'fim'", "'fimpoema'", "'declare'", "'number'", 
			"'text'", "'boolean'", "'Ao acaso, tendo'", "', tenho que'", "'Mas, se o destino n\\u00E3o permite,'", 
			"'E esta \\u00E9 a solu\\u00E7\\u00F5es para minhas indaga\\u00E7\\u00F5es'", 
			"'Continuamente, ao caso de'", "', busco'", "'O que continuamente trar\\u00E1 meu sossego'", 
			"'leia'", "'escreva'", null, "':='", null, null, null, null, "','", "'\\n'", 
			"'('", "')'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "OP", "OP_AT", "OPREL", "ID", "NUM", 
			"BOOLEAN", "VIRG", "QL", "AP", "FP", "DP", "TEXTO", "WS"
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
			setState(22);
			match(T__0);
			setState(23);
			match(ID);
			 program.setName(_input.LT(-1).getText());
			                               stack.push(new ArrayList<Command>()); 
			                             
			setState(25);
			match(QL);
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				declaravar();
				}
				}
				setState(29); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
			setState(31);
			match(T__1);
			setState(32);
			match(QL);
			setState(34); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(33);
				comando();
				}
				}
				setState(36); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2302464L) != 0) );
			setState(38);
			match(T__2);
			setState(39);
			match(QL);
			setState(40);
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
		public List<TerminalNode> ID() { return getTokens(BUCOLGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(BUCOLGrammarParser.ID, i);
		}
		public TerminalNode DP() { return getToken(BUCOLGrammarParser.DP, 0); }
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
			setState(43);
			match(T__4);
			 currentDecl.clear(); 
			setState(45);
			match(ID);
			 currentDecl.add(new Var(_input.LT(-1).getText()));
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRG) {
				{
				{
				setState(47);
				match(VIRG);
				setState(48);
				match(ID);
				 currentDecl.add(new Var(_input.LT(-1).getText()));
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(DP);
			setState(62);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(56);
				match(T__5);
				currentType = Types.NUMBER;
				}
				break;
			case T__6:
				{
				setState(58);
				match(T__6);
				currentType = Types.TEXT;
				}
				break;
			case T__7:
				{
				setState(60);
				match(T__7);
				currentType = Types.BOOLEAN;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 updateType(); 
			setState(65);
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
		enterRule(_localctx, 4, RULE_comando);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				cmdAttrib();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				cmdLeitura();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				cmdEscrita();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				cmdIF();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				cmdWhile();
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
		enterRule(_localctx, 6, RULE_cmdIF);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__8);
			 stack.push(new ArrayList<Command>());
			                      strExpr = "";
			                      currentIfCommand = new IfCommand();
			                    
			setState(76);
			match(DP);
			setState(77);
			expr();
			setState(78);
			match(OPREL);
			 strExpr += _input.LT(-1).getText(); 
			setState(80);
			expr();
			 currentIfCommand.setExpression(strExpr); 
			setState(82);
			match(T__9);
			setState(83);
			match(QL);
			setState(85); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(84);
				comando();
				}
				}
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2302464L) != 0) );
			 
			                  currentIfCommand.setTrueList(stack.pop());                            
			               
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(90);
				match(T__10);
				 stack.push(new ArrayList<Command>()); 
				setState(92);
				match(QL);
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(93);
					comando();
					}
					}
					setState(96); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2302464L) != 0) );
				 currentIfCommand.setFalseList(stack.pop()); 
				}
			}

			setState(102);
			match(T__11);
			setState(103);
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
		enterRule(_localctx, 8, RULE_cmdWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__12);
			 stack.push(new ArrayList<Command>());
			                      strExpr = "";
			                      currentWhileCommand = new WhileCommand();
			                    
			setState(108);
			match(DP);
			setState(109);
			expr();
			setState(110);
			match(OPREL);
			 strExpr += _input.LT(-1).getText(); 
			setState(112);
			expr();
			 currentWhileCommand.setExpression(strExpr); 
			setState(114);
			match(T__13);
			setState(115);
			match(QL);
			setState(117); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(116);
				comando();
				}
				}
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2302464L) != 0) );
			 
			               currentWhileCommand.setCommandList(stack.pop());                            
			            
			setState(122);
			match(T__14);
			setState(123);
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
		public TerminalNode ID() { return getToken(BUCOLGrammarParser.ID, 0); }
		public TerminalNode OP_AT() { return getToken(BUCOLGrammarParser.OP_AT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
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
		enterRule(_localctx, 10, RULE_cmdAttrib);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new BUCOLSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                   }
			                   symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                   leftType = symbolTable.get(_input.LT(-1).getText()).getType();
			                 
			setState(128);
			match(OP_AT);
			setState(129);
			expr();
			setState(130);
			match(QL);

			                 System.out.println("Left  Side Expression Type = "+leftType);
			                 System.out.println("Right Side Expression Type = "+rightType);
			                 if (leftType.getValue() < rightType.getValue()){
			                    throw new BUCOLSemanticException("Type Mismatchig on Assignment");
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
	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(BUCOLGrammarParser.AP, 0); }
		public TerminalNode ID() { return getToken(BUCOLGrammarParser.ID, 0); }
		public TerminalNode FP() { return getToken(BUCOLGrammarParser.FP, 0); }
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
		enterRule(_localctx, 12, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(T__15);
			setState(134);
			match(AP);
			setState(135);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                       throw new BUCOLSemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                    }
			                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                    Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
			                    stack.peek().add(cmdRead);
			                  
			setState(137);
			match(FP);
			setState(138);
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
		enterRule(_localctx, 14, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__16);
			setState(141);
			match(AP);
			{
			setState(142);
			termo();
			 Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
			                         stack.peek().add(cmdWrite);
			                       
			}
			setState(145);
			match(FP);
			setState(146);
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
		enterRule(_localctx, 16, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			termo();
			 strExpr += _input.LT(-1).getText(); 
			setState(151);
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
		enterRule(_localctx, 18, RULE_termo);
		try {
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
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
				setState(155);
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
				setState(157);
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
				setState(159);
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
		enterRule(_localctx, 20, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP) {
				{
				{
				setState(163);
				match(OP);
				 strExpr += _input.LT(-1).getText(); 
				setState(165);
				termo();
				 strExpr += _input.LT(-1).getText(); 
				}
				}
				setState(172);
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
		"\u0004\u0001\u001e\u00ae\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u001c\b\u0000\u000b\u0000"+
		"\f\u0000\u001d\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000#\b\u0000"+
		"\u000b\u0000\f\u0000$\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0005\u00013\b\u0001\n\u0001\f\u00016\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001?\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"I\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0004\u0003V\b\u0003\u000b\u0003\f\u0003W\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0004\u0003_\b\u0003\u000b\u0003\f\u0003"+
		"`\u0001\u0003\u0001\u0003\u0003\u0003e\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0004\u0004v\b\u0004\u000b\u0004\f\u0004w\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00a2"+
		"\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00a9\b\n\n\n\f\n"+
		"\u00ac\t\n\u0001\n\u0000\u0000\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0000\u0000\u00b3\u0000\u0016\u0001\u0000\u0000\u0000"+
		"\u0002+\u0001\u0000\u0000\u0000\u0004H\u0001\u0000\u0000\u0000\u0006J"+
		"\u0001\u0000\u0000\u0000\bj\u0001\u0000\u0000\u0000\n~\u0001\u0000\u0000"+
		"\u0000\f\u0085\u0001\u0000\u0000\u0000\u000e\u008c\u0001\u0000\u0000\u0000"+
		"\u0010\u0095\u0001\u0000\u0000\u0000\u0012\u00a1\u0001\u0000\u0000\u0000"+
		"\u0014\u00aa\u0001\u0000\u0000\u0000\u0016\u0017\u0005\u0001\u0000\u0000"+
		"\u0017\u0018\u0005\u0015\u0000\u0000\u0018\u0019\u0006\u0000\uffff\uffff"+
		"\u0000\u0019\u001b\u0005\u0019\u0000\u0000\u001a\u001c\u0003\u0002\u0001"+
		"\u0000\u001b\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000"+
		"\u0000\u001d\u001b\u0001\u0000\u0000\u0000\u001d\u001e\u0001\u0000\u0000"+
		"\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f \u0005\u0002\u0000\u0000"+
		" \"\u0005\u0019\u0000\u0000!#\u0003\u0004\u0002\u0000\"!\u0001\u0000\u0000"+
		"\u0000#$\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000$%\u0001\u0000"+
		"\u0000\u0000%&\u0001\u0000\u0000\u0000&\'\u0005\u0003\u0000\u0000\'(\u0005"+
		"\u0019\u0000\u0000()\u0005\u0004\u0000\u0000)*\u0006\u0000\uffff\uffff"+
		"\u0000*\u0001\u0001\u0000\u0000\u0000+,\u0005\u0005\u0000\u0000,-\u0006"+
		"\u0001\uffff\uffff\u0000-.\u0005\u0015\u0000\u0000.4\u0006\u0001\uffff"+
		"\uffff\u0000/0\u0005\u0018\u0000\u000001\u0005\u0015\u0000\u000013\u0006"+
		"\u0001\uffff\uffff\u00002/\u0001\u0000\u0000\u000036\u0001\u0000\u0000"+
		"\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000057\u0001\u0000"+
		"\u0000\u000064\u0001\u0000\u0000\u00007>\u0005\u001c\u0000\u000089\u0005"+
		"\u0006\u0000\u00009?\u0006\u0001\uffff\uffff\u0000:;\u0005\u0007\u0000"+
		"\u0000;?\u0006\u0001\uffff\uffff\u0000<=\u0005\b\u0000\u0000=?\u0006\u0001"+
		"\uffff\uffff\u0000>8\u0001\u0000\u0000\u0000>:\u0001\u0000\u0000\u0000"+
		"><\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@A\u0006\u0001\uffff"+
		"\uffff\u0000AB\u0005\u0019\u0000\u0000B\u0003\u0001\u0000\u0000\u0000"+
		"CI\u0003\n\u0005\u0000DI\u0003\f\u0006\u0000EI\u0003\u000e\u0007\u0000"+
		"FI\u0003\u0006\u0003\u0000GI\u0003\b\u0004\u0000HC\u0001\u0000\u0000\u0000"+
		"HD\u0001\u0000\u0000\u0000HE\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000"+
		"\u0000HG\u0001\u0000\u0000\u0000I\u0005\u0001\u0000\u0000\u0000JK\u0005"+
		"\t\u0000\u0000KL\u0006\u0003\uffff\uffff\u0000LM\u0005\u001c\u0000\u0000"+
		"MN\u0003\u0010\b\u0000NO\u0005\u0014\u0000\u0000OP\u0006\u0003\uffff\uffff"+
		"\u0000PQ\u0003\u0010\b\u0000QR\u0006\u0003\uffff\uffff\u0000RS\u0005\n"+
		"\u0000\u0000SU\u0005\u0019\u0000\u0000TV\u0003\u0004\u0002\u0000UT\u0001"+
		"\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000"+
		"WX\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000Yd\u0006\u0003\uffff"+
		"\uffff\u0000Z[\u0005\u000b\u0000\u0000[\\\u0006\u0003\uffff\uffff\u0000"+
		"\\^\u0005\u0019\u0000\u0000]_\u0003\u0004\u0002\u0000^]\u0001\u0000\u0000"+
		"\u0000_`\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000"+
		"\u0000\u0000ab\u0001\u0000\u0000\u0000bc\u0006\u0003\uffff\uffff\u0000"+
		"ce\u0001\u0000\u0000\u0000dZ\u0001\u0000\u0000\u0000de\u0001\u0000\u0000"+
		"\u0000ef\u0001\u0000\u0000\u0000fg\u0005\f\u0000\u0000gh\u0005\u0019\u0000"+
		"\u0000hi\u0006\u0003\uffff\uffff\u0000i\u0007\u0001\u0000\u0000\u0000"+
		"jk\u0005\r\u0000\u0000kl\u0006\u0004\uffff\uffff\u0000lm\u0005\u001c\u0000"+
		"\u0000mn\u0003\u0010\b\u0000no\u0005\u0014\u0000\u0000op\u0006\u0004\uffff"+
		"\uffff\u0000pq\u0003\u0010\b\u0000qr\u0006\u0004\uffff\uffff\u0000rs\u0005"+
		"\u000e\u0000\u0000su\u0005\u0019\u0000\u0000tv\u0003\u0004\u0002\u0000"+
		"ut\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000"+
		"\u0000wx\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0006\u0004"+
		"\uffff\uffff\u0000z{\u0005\u000f\u0000\u0000{|\u0005\u0019\u0000\u0000"+
		"|}\u0006\u0004\uffff\uffff\u0000}\t\u0001\u0000\u0000\u0000~\u007f\u0005"+
		"\u0015\u0000\u0000\u007f\u0080\u0006\u0005\uffff\uffff\u0000\u0080\u0081"+
		"\u0005\u0013\u0000\u0000\u0081\u0082\u0003\u0010\b\u0000\u0082\u0083\u0005"+
		"\u0019\u0000\u0000\u0083\u0084\u0006\u0005\uffff\uffff\u0000\u0084\u000b"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u0010\u0000\u0000\u0086\u0087"+
		"\u0005\u001a\u0000\u0000\u0087\u0088\u0005\u0015\u0000\u0000\u0088\u0089"+
		"\u0006\u0006\uffff\uffff\u0000\u0089\u008a\u0005\u001b\u0000\u0000\u008a"+
		"\u008b\u0005\u0019\u0000\u0000\u008b\r\u0001\u0000\u0000\u0000\u008c\u008d"+
		"\u0005\u0011\u0000\u0000\u008d\u008e\u0005\u001a\u0000\u0000\u008e\u008f"+
		"\u0003\u0012\t\u0000\u008f\u0090\u0006\u0007\uffff\uffff\u0000\u0090\u0091"+
		"\u0001\u0000\u0000\u0000\u0091\u0092\u0005\u001b\u0000\u0000\u0092\u0093"+
		"\u0005\u0019\u0000\u0000\u0093\u0094\u0006\u0007\uffff\uffff\u0000\u0094"+
		"\u000f\u0001\u0000\u0000\u0000\u0095\u0096\u0003\u0012\t\u0000\u0096\u0097"+
		"\u0006\b\uffff\uffff\u0000\u0097\u0098\u0003\u0014\n\u0000\u0098\u0011"+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0005\u0015\u0000\u0000\u009a\u00a2"+
		"\u0006\t\uffff\uffff\u0000\u009b\u009c\u0005\u0016\u0000\u0000\u009c\u00a2"+
		"\u0006\t\uffff\uffff\u0000\u009d\u009e\u0005\u001d\u0000\u0000\u009e\u00a2"+
		"\u0006\t\uffff\uffff\u0000\u009f\u00a0\u0005\u0017\u0000\u0000\u00a0\u00a2"+
		"\u0006\t\uffff\uffff\u0000\u00a1\u0099\u0001\u0000\u0000\u0000\u00a1\u009b"+
		"\u0001\u0000\u0000\u0000\u00a1\u009d\u0001\u0000\u0000\u0000\u00a1\u009f"+
		"\u0001\u0000\u0000\u0000\u00a2\u0013\u0001\u0000\u0000\u0000\u00a3\u00a4"+
		"\u0005\u0012\u0000\u0000\u00a4\u00a5\u0006\n\uffff\uffff\u0000\u00a5\u00a6"+
		"\u0003\u0012\t\u0000\u00a6\u00a7\u0006\n\uffff\uffff\u0000\u00a7\u00a9"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a3\u0001\u0000\u0000\u0000\u00a9\u00ac"+
		"\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ab\u0015\u0001\u0000\u0000\u0000\u00ac\u00aa"+
		"\u0001\u0000\u0000\u0000\u000b\u001d$4>HW`dw\u00a1\u00aa";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}