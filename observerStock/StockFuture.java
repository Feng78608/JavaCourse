package observerStock;
public class StockFuture extends AStockPrice {
	public StockFuture(String code) {
		super(code);
	}
	public  void notifyStockHolder() {
		System.out.println("�ڻ�������-"+code+":"+price2+"->"+price);
		for(IStockHolder sh:stockHolders) {
			sh.update(this);
		}
		price2=price;
	}
}
