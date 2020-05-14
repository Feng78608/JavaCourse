package chain;

import java.util.Random;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AFruitSort bfs,mfs,sfs;
		bfs=new BigFruit(9);
		mfs=new MidFruit(6);
		sfs=new SmallFruit(3);
		
		bfs.setNextSort(mfs);
		mfs.setNextSort(sfs);
		//sfs.setNextSort(bfs);StackOverflowError
		
		Random random=new Random();
		for(int i=0;i<1000;i++) {
			int weight=random.nextInt(10);
			bfs.sendFruit(weight, "Ёхвс");
		}
		
		bfs.getFruitBox();
		mfs.getFruitBox();
		sfs.getFruitBox();
	}

}
