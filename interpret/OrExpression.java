package interpret;

public class OrExpression implements Expression {//双目运算符“or”
	
	private Expression expr1=null;
	private Expression expr2=null;
	public OrExpression(Expression expr1,Expression expr2) {
		this.expr1=expr1;
		this.expr2=expr2;
	}

	@Override
	public boolean interpret(String context) {//按情况自定义
		// TODO Auto-generated method stub
		return expr1.interpret(context)||expr2.interpret(context);
	}

}
