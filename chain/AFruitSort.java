package chain;

import java.util.ArrayList;
import java.util.List;

public abstract class AFruitSort {
	private int weight;
	protected List<String> fruitBox;
	private AFruitSort nextFruitSort;
	public void getFruitBox() {
		System.out.println("weight:"+weight);
		System.out.println("个数:"+fruitBox.size());
		for(String fruit:fruitBox) {
			System.out.print(fruit+",");
		}
		System.out.println(" ");
	}
	public AFruitSort(int weight) {
		this.weight=weight;
		fruitBox=new ArrayList<String>();
	}
	public void setNextSort(AFruitSort nextFruitSort) {
		this.nextFruitSort=nextFruitSort;
	}
	public void sendFruit(int weight,String fruit) {
		if(this.weight<=weight)
			pushBox(fruit);
		else
			if(nextFruitSort!=null)
				nextFruitSort.sendFruit(weight, fruit);
	}
	protected abstract void pushBox(String fruit);//子类自己扩展分拣，以实现不同的功能
}
