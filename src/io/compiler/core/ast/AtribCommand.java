package io.compiler.core.ast;

import io.compiler.types.Types;
import io.compiler.types.Var;

public class AtribCommand extends Command {
    private Var leftSide;
    private String rightSide;

    public AtribCommand() {
		super();
	}

	public AtribCommand(Var leftSide, String rightSide) {
		super();
		this.leftSide = leftSide;
        this.rightSide = rightSide;
	}

    public void setRightSide(String expr) {
        this.rightSide = expr;
    }

    public void setLeftSide(Var var) {
        this.leftSide = var;
    }

    public Var getLeftSide() {
        return this.leftSide;
    }

    public String getRightSide() {
        return this.rightSide;
    }

    @Override
	public String generateTarget() {
		return this.leftSide.getId() + " = " + ExpressionFormater.formatExpression(this.rightSide) + ";" + "\n";
	}
}