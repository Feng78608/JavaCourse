package interpret;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {//↓对一段文字提一个问题，通过自定义逻辑来回答该问题
		// TODO Auto-generated method stub
		Expression isMale = getMaleExpression();
		Expression isMarriedWoman = getMarriedWomanExpression();
		
		System.out.println("John is male?"+isMale.interpret("John"));//判断John是不是男性
		System.out.println("Julie is a married women?"+
		isMarriedWoman.interpret("Married Julie"));
	
	}

	private static Expression getMarriedWomanExpression() {//只要参数context包含Julie与Married，结果就为真
		// TODO Auto-generated method stub
		Expression julie =new TerminalExpression("Julie");
		Expression married =new TerminalExpression("Married");
		return new AndExpression(julie,married);
	}

	private static Expression getMaleExpression() {//只要参数context包含John或者Robert结果就为男性
		// TODO Auto-generated method stub
		Expression robert =new TerminalExpression("Robert");
		Expression john =new TerminalExpression("John");
		return new OrExpression(robert,john);
	}

}
