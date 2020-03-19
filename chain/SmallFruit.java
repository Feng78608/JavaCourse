package chain;

public class SmallFruit extends AFruitSort {

	public SmallFruit(int weight) {
		super(weight);
	}
	@Override
	protected void pushBox(String fruit) {
		// TODO Auto-generated method stub
		fruitBox.add("¹ûÖ­£º"+fruit);
	}

}
