package interpret;

public class AndExpression implements Expression {//双目运算符“and”
	
	private Expression expr1=null;
	private Expression expr2=null;
	public AndExpression(Expression expr1,Expression expr2) {
		this.expr1=expr1;
		this.expr2=expr2;
	}

	@Override
	public boolean interpret(String context) {//按情况自定义
		// TODO Auto-generated method stub
		return expr1.interpret(context)&&expr2.interpret(context);
	}

}
