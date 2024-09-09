package io.compiler.core.ast;

import java.util.List;

public class WhileCommand extends Command{

	private String expression;
	private List<Command> commandList;
	
	public WhileCommand() {
		super();
	}

	public WhileCommand(String expression, List<Command> commandList) {
		super();
		this.expression = expression;
		this.commandList = commandList;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public List<Command> getCommandList() {
		return this.commandList;
	}

	public void setCommandList(List<Command> commandList) {
		this.commandList = commandList;
	}

	@Override
	public String generateTarget() {
		
		StringBuilder str = new StringBuilder();
		str.append("while ("+expression+") {");
		for (Command cmd: commandList) {
			str.append(cmd.generateTarget());
		}
		str.append("}");

		return str.toString();
	}
}
