package strategy;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chef chef=new Chef();
		ICutFruit blade=(ICutFruit)XMLUtil.getBean();
		chef.setCutMethod(blade);
		chef.cutFruit("Иывс");
	}

}
