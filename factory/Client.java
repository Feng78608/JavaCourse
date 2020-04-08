package factory;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory factory=(Factory)XMLUtil.getBean();
		Fruit fruit=factory.createFruit();
		fruit.eat();
	}

}
