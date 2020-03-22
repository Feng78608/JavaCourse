package observerStock;

import observer.ASubject;
import observer.ConcreteObserver1;
import observer.ConcreteObserver2;
import observer.ConcreteSubject1;
import observer.IObserver;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AStockPrice future1=new StockFuture("111");
		AStockPrice future2=new StockFuture("222");
		AStockPrice future3=new StockFuture("333");
		

		AStockPrice common5=new StockCommon("555");
		AStockPrice common6=new StockCommon("666");
		AStockPrice common7=new StockCommon("777");
		
		IStockHolder buy1=new BuyHolder("Buy1");
		IStockHolder buy2=new BuyHolder("Buy2");
		IStockHolder buy3=new BuyHolder("Buy3");

		IStockHolder sell1=new SellHolder("sell1");
		IStockHolder sell2=new SellHolder("sell2");
		IStockHolder sell3=new SellHolder("sell3");
		
		
		buy1.addHolder(future1);buy1.addHolder(future2);
		buy1.addHolder(common5);
		
		buy2.addHolder(future1);buy2.addHolder(future3);
		buy2.addHolder(common6);
		
		buy3.addHolder(future3);buy3.addHolder(future3);
		buy3.addHolder(common7);
		
		sell1.addHolder(future1);sell1.addHolder(future2);
		sell1.addHolder(common5);
		
		sell2.addHolder(future1);sell2.addHolder(future3);
		sell2.addHolder(common6);
		
		sell3.addHolder(future3);sell3.addHolder(future3);
		sell3.addHolder(common7);
		
		for(int i=0;i>-5;i--) {
			future1.setPrice(1+i);
			future2.setPrice(1+i);
			future3.setPrice(1+i);
			
			common5.setPrice(1+i);
			common6.setPrice(1+i);
			common7.setPrice(1+i);
		}
	}

}
