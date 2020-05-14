package iterator;

public class Client {

	public static void display(Television tv) {
		TVIterator i=tv.createIterator();
		System.out.println("���ӻ�Ƶ����");
		while(!i.isLast()) {
			System.out.println(i.currentChannel());
			i.next();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Television tv=(Television)XMLUtil.getBean();
		display(tv);
	}

}
