package io.compiler.core.ast;

public class WriteCommand extends Command {
	private String content;
	private boolean nl;

	@Override
	public String generateTarget() {
		// TODO Auto-generated method stub
		return "System.out.print"+ (nl ? "ln(" : "(") + content + ");\n";
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public WriteCommand(String content, boolean nl) {
		super();
		this.content = content;
		this.nl = nl;
	}

	public WriteCommand() {
		super();
	}

	
}
