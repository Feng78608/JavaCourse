package command;

import java.util.HashMap;

public class Order {

	private int id;
	private HashMap<String,Integer>  fruit;
	public Order() {
		fruit=new HashMap();
	}
	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public HashMap<String,Integer> getFruit() {
		return fruit;
	}
	public void setFruit(String fruitKindName,Integer fruitNumber) {
		
		this.fruit.put(fruitKindName, fruitNumber);
	}

}
