package interpret;

public class TerminalExpression implements Expression {

	private String data;
	public TerminalExpression(String data) {
		this.data=data;
	}
	@Override
	public boolean interpret(String context) {
		// TODO Auto-generated method stub
		if(context.contains(data))//表达式是否包含data
			return true;
		return false;
	}

}
