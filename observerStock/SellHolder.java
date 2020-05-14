package observerStock;

import java.util.ArrayList;
import java.util.List;

public class SellHolder implements IStockHolder {
	private List<AStockPrice> attentionlist;
	private String name;
	
	public SellHolder(String name) {
		this.name=name;
		attentionlist=new ArrayList<AStockPrice>();
	}
	
	public void update(AStockPrice asp) {
		if(attentionlist.contains(asp))
			System.out.println(name);
		if(asp.getPrice()-asp.getPrice2()>0) {//股票涨价
			System.out.print(asp.code+":");
			System.out.print("原价："+asp.price2+"-现价："+asp.price+"="+(asp.price2-asp.price));
			System.out.println("涨了，哭");
		}else
		{
			System.out.print(asp.code+":");
			System.out.print("原价："+asp.price2+"-现价："+asp.price+"="+(asp.price2-asp.price));
			System.out.println("跌了，爽");
		}
	}

	public void removeHolder(AStockPrice asp) {
		attentionlist.remove(asp);
		asp.removestockHolder(this);
	}
	public void addHolder(AStockPrice asp) {
		attentionlist.add(asp);//将asp加到自己的关注列表中，
		asp.addStockHolder(this);//同时自己注册
		
	}
}
