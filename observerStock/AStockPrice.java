package observerStock;

import java.util.ArrayList;
import java.util.List;

public abstract class AStockPrice {

	protected float price,price2;//price2是原价。price是现价
	protected String code;
	protected List<IStockHolder> stockHolders;
	
	public AStockPrice(String code) {
		this.code=code;
		price=price2=0;
		stockHolders=new ArrayList<IStockHolder>();
	}
	
    public void addStockHolder(IStockHolder sh){
    	stockHolders.add(sh);
    }
    public void removestockHolder(IStockHolder sh) {
    	stockHolders.remove(sh);
    }
    
    public abstract void notifyStockHolder();

    
    public float getPrice() {
    	return price;
    }
    public void setPrice(float price) {
    	this.price=price;
    	notifyStockHolder();
    }
    
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AStockPrice other = (AStockPrice) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	public float getPrice2() {
		return price2;
	}

	public void setPrice2(float price2) {
		this.price2 = price2;
	}
	

}
