package command;

public class Operator {

	public void MarkFruit(Order order) {
		// TODO Auto-generated method stub
		String str="";
		for(String key :order.getFruit().keySet()) {//keyset返回所有的key
			str+=key+order.getFruit().get(key).toString();
		}
		System.out.println("黑暗混合果汁："+str);
	}

}
