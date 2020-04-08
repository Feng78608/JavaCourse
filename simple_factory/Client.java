package simple_factory;

public class Client {//简单工厂模式

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory factory=new Factory();
		Fruit fruit=factory.createFruit("B");
		fruit.eat();
	}

}
