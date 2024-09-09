package io.compiler.core.ast;

public class ExpressionFormater {
    public static String formatExpression(String input) {
        String resultString = input;
        resultString = resultString.replace("e também", " && ");
        resultString = resultString.replace("ou também", " || ");
        return resultString;
    }
}
