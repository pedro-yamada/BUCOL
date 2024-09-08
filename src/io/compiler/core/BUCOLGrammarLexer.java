// Generated from BUCOLGrammar.g4 by ANTLR 4.13.2
package io.compiler.core;

	import java.util.ArrayList;
	import java.util.HashMap;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class BUCOLGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		OP=10, OP_AT=11, ID=12, NUM=13, VIRG=14, PV=15, AP=16, FP=17, DP=18, TEXTO=19, 
		WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"OP", "OP_AT", "ID", "NUM", "VIRG", "PV", "AP", "FP", "DP", "TEXTO", 
			"WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'inicio'", "'fim'", "'fimprog'", "'declare'", "'number'", 
			"'text'", "'leia'", "'escreva'", null, "':='", null, null, "','", "';'", 
			"'('", "')'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, "OP", "OP_AT", 
			"ID", "NUM", "VIRG", "PV", "AP", "FP", "DP", "TEXTO", "WS"
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


	    private HashMap<String,Var> symbolTable = new HashMap<String, Var>();
	    private ArrayList<Var> currentDecl = new ArrayList<Var>();
	    private Types currentType;
	    private Types leftType=null, rightType=null;
	    
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
	    
	    public boolean isDeclared(String id){
	    	return symbolTable.get(id) != null;
	    }


	public BUCOLGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BUCOLGrammar.g4"; }

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
		"\u0004\u0000\u0014\u0096\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0005\u000bn\b\u000b\n\u000b\f\u000bq\t\u000b\u0001"+
		"\f\u0004\ft\b\f\u000b\f\f\fu\u0001\f\u0001\f\u0004\fz\b\f\u000b\f\f\f"+
		"{\u0003\f~\b\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0005\u0012\u008c\b\u0012\n\u0012\f\u0012\u008f\t\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0000\u0000"+
		"\u0014\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014\u0001\u0000\u0006"+
		"\u0003\u0000*+--//\u0001\u0000az\u0003\u000009AZaz\u0001\u000009\u0005"+
		"\u0000  ,.09AZaz\u0003\u0000\t\n\r\r  \u009a\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0001)\u0001\u0000\u0000\u0000\u00032\u0001\u0000\u0000\u0000"+
		"\u00059\u0001\u0000\u0000\u0000\u0007=\u0001\u0000\u0000\u0000\tE\u0001"+
		"\u0000\u0000\u0000\u000bM\u0001\u0000\u0000\u0000\rT\u0001\u0000\u0000"+
		"\u0000\u000fY\u0001\u0000\u0000\u0000\u0011^\u0001\u0000\u0000\u0000\u0013"+
		"f\u0001\u0000\u0000\u0000\u0015h\u0001\u0000\u0000\u0000\u0017k\u0001"+
		"\u0000\u0000\u0000\u0019s\u0001\u0000\u0000\u0000\u001b\u007f\u0001\u0000"+
		"\u0000\u0000\u001d\u0081\u0001\u0000\u0000\u0000\u001f\u0083\u0001\u0000"+
		"\u0000\u0000!\u0085\u0001\u0000\u0000\u0000#\u0087\u0001\u0000\u0000\u0000"+
		"%\u0089\u0001\u0000\u0000\u0000\'\u0092\u0001\u0000\u0000\u0000)*\u0005"+
		"p\u0000\u0000*+\u0005r\u0000\u0000+,\u0005o\u0000\u0000,-\u0005g\u0000"+
		"\u0000-.\u0005r\u0000\u0000./\u0005a\u0000\u0000/0\u0005m\u0000\u0000"+
		"01\u0005a\u0000\u00001\u0002\u0001\u0000\u0000\u000023\u0005i\u0000\u0000"+
		"34\u0005n\u0000\u000045\u0005i\u0000\u000056\u0005c\u0000\u000067\u0005"+
		"i\u0000\u000078\u0005o\u0000\u00008\u0004\u0001\u0000\u0000\u00009:\u0005"+
		"f\u0000\u0000:;\u0005i\u0000\u0000;<\u0005m\u0000\u0000<\u0006\u0001\u0000"+
		"\u0000\u0000=>\u0005f\u0000\u0000>?\u0005i\u0000\u0000?@\u0005m\u0000"+
		"\u0000@A\u0005p\u0000\u0000AB\u0005r\u0000\u0000BC\u0005o\u0000\u0000"+
		"CD\u0005g\u0000\u0000D\b\u0001\u0000\u0000\u0000EF\u0005d\u0000\u0000"+
		"FG\u0005e\u0000\u0000GH\u0005c\u0000\u0000HI\u0005l\u0000\u0000IJ\u0005"+
		"a\u0000\u0000JK\u0005r\u0000\u0000KL\u0005e\u0000\u0000L\n\u0001\u0000"+
		"\u0000\u0000MN\u0005n\u0000\u0000NO\u0005u\u0000\u0000OP\u0005m\u0000"+
		"\u0000PQ\u0005b\u0000\u0000QR\u0005e\u0000\u0000RS\u0005r\u0000\u0000"+
		"S\f\u0001\u0000\u0000\u0000TU\u0005t\u0000\u0000UV\u0005e\u0000\u0000"+
		"VW\u0005x\u0000\u0000WX\u0005t\u0000\u0000X\u000e\u0001\u0000\u0000\u0000"+
		"YZ\u0005l\u0000\u0000Z[\u0005e\u0000\u0000[\\\u0005i\u0000\u0000\\]\u0005"+
		"a\u0000\u0000]\u0010\u0001\u0000\u0000\u0000^_\u0005e\u0000\u0000_`\u0005"+
		"s\u0000\u0000`a\u0005c\u0000\u0000ab\u0005r\u0000\u0000bc\u0005e\u0000"+
		"\u0000cd\u0005v\u0000\u0000de\u0005a\u0000\u0000e\u0012\u0001\u0000\u0000"+
		"\u0000fg\u0007\u0000\u0000\u0000g\u0014\u0001\u0000\u0000\u0000hi\u0005"+
		":\u0000\u0000ij\u0005=\u0000\u0000j\u0016\u0001\u0000\u0000\u0000ko\u0007"+
		"\u0001\u0000\u0000ln\u0007\u0002\u0000\u0000ml\u0001\u0000\u0000\u0000"+
		"nq\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000op\u0001\u0000\u0000"+
		"\u0000p\u0018\u0001\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000rt\u0007"+
		"\u0003\u0000\u0000sr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000v}\u0001\u0000\u0000"+
		"\u0000wy\u0005.\u0000\u0000xz\u0007\u0003\u0000\u0000yx\u0001\u0000\u0000"+
		"\u0000z{\u0001\u0000\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000"+
		"\u0000\u0000|~\u0001\u0000\u0000\u0000}w\u0001\u0000\u0000\u0000}~\u0001"+
		"\u0000\u0000\u0000~\u001a\u0001\u0000\u0000\u0000\u007f\u0080\u0005,\u0000"+
		"\u0000\u0080\u001c\u0001\u0000\u0000\u0000\u0081\u0082\u0005;\u0000\u0000"+
		"\u0082\u001e\u0001\u0000\u0000\u0000\u0083\u0084\u0005(\u0000\u0000\u0084"+
		" \u0001\u0000\u0000\u0000\u0085\u0086\u0005)\u0000\u0000\u0086\"\u0001"+
		"\u0000\u0000\u0000\u0087\u0088\u0005:\u0000\u0000\u0088$\u0001\u0000\u0000"+
		"\u0000\u0089\u008d\u0005\"\u0000\u0000\u008a\u008c\u0007\u0004\u0000\u0000"+
		"\u008b\u008a\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000"+
		"\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000"+
		"\u008e\u0090\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0005\"\u0000\u0000\u0091&\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0007\u0005\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094"+
		"\u0095\u0006\u0013\u0000\u0000\u0095(\u0001\u0000\u0000\u0000\b\u0000"+
		"mou{}\u008b\u008d\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}