package clone;

import java.util.Hashtable;

public class MyFruitStore {//ԭ�͹�����+����ģʽ
	private static Hashtable fruitTable=null;
	private static MyFruitStore fruitStore=null;//����ʽ��ϵͳ��Ҫʱ�Ŵ�������
	private MyFruitStore() {//���캯��˽�л���ʹ��ֻ����getFruitStore���õ�����
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
		return (MyFruit)fruit.clone();//��ˮ�����ϵ�ˮ����¡һ�ݣ�����ֱ�ӷ���
	}
}

/*����ʽ��ֻҪϵͳ���þʹ�������
 * private static Hashtable fruitTable=null; private static MyFruitStore
 * fruitStore=new MyFruitStore����; private MyFruitStore()
 * {//���캯��˽�л���ʹ��ֻ����getFruitStore���õ����� fruitTable=new
 * Hashtable<Integer,MyFruit>(); } public static MyFruitStore getFruitStore() {
 * return fruitStore; }
 */