package io.compiler.core.ast;

public class ExpressionFormater {
    public static String formatExpression(String input) {
        String resultString = input;
        resultString = resultString.replace("e também", " && ");
        resultString = resultString.replace("ou também", " || ");
        resultString = resultString.replace("absoluto paraíso", "true");
        resultString = resultString.replace("terrível inferno", "false");
        return resultString;
    }
}
