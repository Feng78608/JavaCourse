package visitor;

public class Saler extends AVisitor {

	@Override
	public void visit(Apple apple) {
		// TODO Auto-generated method stub
		System.out.println("收银员"+name+"给苹果过秤");
	}

	@Override
	public void visit(Book book) {
		// TODO Auto-generated method stub

		System.out.println("收银员"+name+"直接计算书的价格");
	}

}
