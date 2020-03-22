package observerStock;
public interface IStockHolder {
	public void update(AStockPrice asp);

	public void addHolder(AStockPrice asp);//关注列表，我要关注谁
}
