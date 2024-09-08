java -cp antlr-4.13.2-complete.jar org.antlr.v4.Tool BUCOLGrammar.g4 -o src/io/compiler/core -package io.compiler.core

javac -cp antlr-4.13.2-complete.jar -d out $(find src -name "*.java")

java -cp out:antlr-4.13.2-complete.jar io.compiler.main.MainClass