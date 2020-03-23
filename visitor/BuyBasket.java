package visitor;

import java.util.ArrayList;
import java.util.Iterator;

public class BuyBasket {
	
	private ArrayList list=new ArrayList();
	
	public void accept(AVisitor visitor) {
		Iterator i=list.iterator();
		while(i.hasNext()) {
			((IProduct)i.next()).accept(visitor);
		}
	}
	
	public void addProduct(IProduct product) {
		list.add(product);
	}
	
	public void remove(IProduct product) {
		list.remove(product);
	}
}
