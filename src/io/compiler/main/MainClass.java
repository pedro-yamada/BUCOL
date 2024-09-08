package io.compiler.main;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.CharStreams;

import io.compiler.core.BUCOLGrammarLexer;
import io.compiler.core.BUCOLGrammarParser;

public class MainClass {
	public static void main(String[] args) {
		try {
			BUCOLGrammarLexer lexer;
			BUCOLGrammarParser parser;
			
			// crio o analisador léxico a partir da leitura de um arquivo
			lexer = new BUCOLGrammarLexer(CharStreams.fromFileName("input.in"));
			
			// agora a partir do analisador lexico, obtenho um fluxo de tokens
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			// crio o parser a partir do tokenStream
			parser = new BUCOLGrammarParser(tokenStream);
			
			
			// agora eu quero chamar do meu jeito
			System.out.println("Bucol Compiler");
			parser.programa();
			System.out.println("Compilation Successfully - Good Job");
			parser.exibirVar();
		}
		catch(Exception ex) {
			System.err.println("Error: "+ex.getMessage());
			//ex.printStackTrace();
		}
	}
}
