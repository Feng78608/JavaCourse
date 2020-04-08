package clone;

import adapter_object.Adapter;
import adapter_object.INewJuicer;

/*import adapter_class.Adapter;
import adapter_class.INewJuicer;*/

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * MyFruit fruit1=new Apple(); //MyFruit fruit2=fruit1; MyFruit
		 * fruit2=(MyFruit)fruit1.clone(); fruit1.disPlay(); fruit2.disPlay();
		 * System.out.println("fruit1:"+fruit1.hashCode());
		 * System.out.println("fruit2:"+fruit2.hashCode());
		 * System.out.println(fruit1.equals(fruit2));
		 */
		
		MyFruit fruit1=new Apple();
		MyFruit fruit2=new Banana();
		MyFruitStore store1=MyFruitStore.getFruitStore();
		/*
		 * MyFruitStore.add(1, fruit1); MyFruitStore.add(2, fruit2); MyFruitStore.add(3,
		 * new Apple()); MyFruitStore.add(4, new Banana());
		 */
		store1.add(1, fruit1);
		store1.add(2, fruit2);
		store1.add(3, new Apple());
		store1.add(4, new Banana());
		MyFruitStore store2=MyFruitStore.getFruitStore();//只是个副本，与store1地址相同
		//↑初始化，一般不与↓同时出现
		/*
		 * MyFruit fruit3=store1.get(1); fruit3.disPlay();
		 * 
		 * System.out.println("store1:"+store1.toString());
		 * System.out.println("store2:"+store2.toString());
		 */
		INewJuicer newJuicer=new Adapter();
		System.out.println(newJuicer.newPort(store1.get(1), store1.get(2)));
	}

}
