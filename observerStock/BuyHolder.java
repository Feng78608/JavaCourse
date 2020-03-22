package observerStock;

import java.util.ArrayList;
import java.util.List;

public class BuyHolder implements IStockHolder {
	private List<AStockPrice> attentionlist;
	private String name;
	
	public BuyHolder(String name) {
		this.name=name;
		attentionlist=new ArrayList<AStockPrice>();
	}
	
	public void update(AStockPrice asp) {
		if(attentionlist.contains(asp))
			System.out.println(name);
		if(asp.getPrice()-asp.getPrice2()>0) {//��Ʊ�Ǽ�
			System.out.print(asp.code+":");
			System.out.print("ԭ�ۣ�"+asp.price2+"-�ּۣ�"+asp.price+"="+(asp.price2-asp.price));
			System.out.println("���ˣ�ˬ");
		}else
		{
			System.out.print(asp.code+":");
			System.out.print("ԭ�ۣ�"+asp.price2+"-�ּۣ�"+asp.price+"="+(asp.price2-asp.price));
			System.out.println("���ˣ���");
		}
	}

	public void removeHolder(AStockPrice asp) {
		attentionlist.remove(asp);
		asp.removestockHolder(this);
	}
	public void addHolder(AStockPrice asp) {
		attentionlist.add(asp);//��asp�ӵ��Լ��Ĺ�ע�б��У�
		asp.addStockHolder(this);//ͬʱ�Լ�ע��
		
	}
}
