package visitor;

public class Customer extends AVisitor {

	@Override
	public void visit(Apple apple) {
		// TODO Auto-generated method stub
		System.out.println("顾客"+name+"选苹果");
	}

	@Override
	public void visit(Book book) {
		// TODO Auto-generated method stub
		System.out.println("顾客"+name+"买书");
		
	}

}
