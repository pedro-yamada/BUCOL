// Generated from BUCOLGrammar.g4 by ANTLR 4.13.2
package io.compiler.core;

	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.HashMap;
   import java.util.Map;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;
	import io.compiler.core.ast.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BUCOLGrammarParser}.
 */
public interface BUCOLGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BUCOLGrammarParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(BUCOLGrammarParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link BUCOLGrammarParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(BUCOLGrammarParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link BUCOLGrammarParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void enterDeclaravar(BUCOLGrammarParser.DeclaravarContext ctx);
	/**
	 * Exit a parse tree produced by {@link BUCOLGrammarParser#declaravar}.
	 * @param ctx the parse tree
	 */
	void exitDeclaravar(BUCOLGrammarParser.DeclaravarContext ctx);
	/**
	 * Enter a parse tree produced by {@link BUCOLGrammarParser#declarativo}.
	 * @param ctx the parse tree
	 */
	void enterDeclarativo(BUCOLGrammarParser.DeclarativoContext ctx);
	/**
	 * Exit a parse tree produced by {@link BUCOLGrammarParser#declarativo}.
	 * @param ctx the parse tree
	 */
	void exitDeclarativo(BUCOLGrammarParser.DeclarativoContext ctx);
	/**
	 * Enter a parse tree produced by {@link BUCOLGrammarParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(BUCOLGrammarParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link BUCOLGrammarParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(BUCOLGrammarParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link BUCOLGrammarParser#cmdIF}.
	 * @param ctx the parse tree
	 */
	void enterCmdIF(BUCOLGrammarParser.CmdIFContext ctx);
	/**
	 * Exit a parse tree produced by {@link BUCOLGrammarParser#cmdIF}.
	 * @param ctx the parse tree
	 */
	void exitCmdIF(BUCOLGrammarParser.CmdIFContext ctx);
	/**
	 * Enter a parse tree produced by {@link BUCOLGrammarParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdWhile(BUCOLGrammarParser.CmdWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link BUCOLGrammarParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdWhile(BUCOLGrammarParser.CmdWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link BUCOLGrammarParser#cmdDoWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdDoWhile(BUCOLGrammarParser.CmdDoWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link BUCOLGrammarParser#cmdDoWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdDoWhile(BUCOLGrammarParser.CmdDoWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link BUCOLGrammarParser#cmdAttrib}.
	 * @param ctx the parse tree
	 */
	void enterCmdAttrib(BUCOLGrammarParser.CmdAttribContext ctx);
	/**
	 * Exit a parse tree produced by {@link BUCOLGrammarParser#cmdAttrib}.
	 * @param ctx the parse tree
	 */
	void exitCmdAttrib(BUCOLGrammarParser.CmdAttribContext ctx);
	/**
	 * Enter a parse tree produced by {@link BUCOLGrammarParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(BUCOLGrammarParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link BUCOLGrammarParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(BUCOLGrammarParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link BUCOLGrammarParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(BUCOLGrammarParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link BUCOLGrammarParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(BUCOLGrammarParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link BUCOLGrammarParser#cmdEscritaNL}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscritaNL(BUCOLGrammarParser.CmdEscritaNLContext ctx);
	/**
	 * Exit a parse tree produced by {@link BUCOLGrammarParser#cmdEscritaNL}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscritaNL(BUCOLGrammarParser.CmdEscritaNLContext ctx);
	/**
	 * Enter a parse tree produced by {@link BUCOLGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(BUCOLGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BUCOLGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(BUCOLGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BUCOLGrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(BUCOLGrammarParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link BUCOLGrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(BUCOLGrammarParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link BUCOLGrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void enterExprl(BUCOLGrammarParser.ExprlContext ctx);
	/**
	 * Exit a parse tree produced by {@link BUCOLGrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void exitExprl(BUCOLGrammarParser.ExprlContext ctx);
}