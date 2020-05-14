package decorator;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IBirthdayCake cake=new Cake();
		cake.show();
		Cream cream=new Cream(cake);
		cream.putCream();
		cream.show();
		
		Fruit fruit=new Fruit(cream);
		fruit.putFruit();
		fruit.show();
	}

}
