package chain;

public class MidFruit extends AFruitSort {

	public MidFruit(int weight) {
		super(weight);
	}
	@Override
	protected void pushBox(String fruit) {
		// TODO Auto-generated method stub
		fruitBox.add("ˮ����ͷ��"+fruit);
	}

}
