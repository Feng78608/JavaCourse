package command;

public class Operator {

	public void MarkFruit(Order order) {
		// TODO Auto-generated method stub
		String str="";
		for(String key :order.getFruit().keySet()) {//keyset�������е�key
			str+=key+order.getFruit().get(key).toString();
		}
		System.out.println("�ڰ���Ϲ�֭��"+str);
	}

}
