package clone;

import java.util.Hashtable;

public class MyFruitStore {//原型管理器+单例模式
	private static Hashtable fruitTable=null;
	private static MyFruitStore fruitStore=null;//懒汉式，系统需要时才创建对象
	private MyFruitStore() {//构造函数私有化，使得只能用getFruitStore来得到对象
		fruitTable=new Hashtable<Integer,MyFruit>();
	}
	public static MyFruitStore getFruitStore() {
		if(fruitStore==null)
			fruitStore=new MyFruitStore();
		return fruitStore;
	}
	public  void add(Integer key,MyFruit fruit) {
		fruitTable.put(key, fruit);
	}
	public  MyFruit get(Integer key) {
		MyFruit fruit=(MyFruit)fruitTable.get(key);
		return (MyFruit)fruit.clone();//把水果架上的水果克隆一份，而非直接返回
	}
}

/*饿汉式，只要系统启用就创建对象
 * private static Hashtable fruitTable=null; private static MyFruitStore
 * fruitStore=new MyFruitStore（）; private MyFruitStore()
 * {//构造函数私有化，使得只能用getFruitStore来得到对象 fruitTable=new
 * Hashtable<Integer,MyFruit>(); } public static MyFruitStore getFruitStore() {
 * return fruitStore; }
 */