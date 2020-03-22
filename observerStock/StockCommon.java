package observerStock;
public class StockCommon extends AStockPrice {
	public StockCommon(String code) {
		super(code);
	}
	public  void notifyStockHolder() {
		System.out.println("普通股票更新啦-"+code+":"+price2+"->"+price);
		for(IStockHolder sh:stockHolders) {
			sh.update(this);
		}
		price2=price;
	}
}
