package interpret;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {//����һ��������һ�����⣬ͨ���Զ����߼����ش������
		// TODO Auto-generated method stub
		Expression isMale = getMaleExpression();
		Expression isMarriedWoman = getMarriedWomanExpression();
		
		System.out.println("John is male?"+isMale.interpret("John"));//�ж�John�ǲ�������
		System.out.println("Julie is a married women?"+
		isMarriedWoman.interpret("Married Julie"));
	
	}

	private static Expression getMarriedWomanExpression() {//ֻҪ����context����Julie��Married�������Ϊ��
		// TODO Auto-generated method stub
		Expression julie =new TerminalExpression("Julie");
		Expression married =new TerminalExpression("Married");
		return new AndExpression(julie,married);
	}

	private static Expression getMaleExpression() {//ֻҪ����context����John����Robert�����Ϊ����
		// TODO Auto-generated method stub
		Expression robert =new TerminalExpression("Robert");
		Expression john =new TerminalExpression("John");
		return new OrExpression(robert,john);
	}

}
