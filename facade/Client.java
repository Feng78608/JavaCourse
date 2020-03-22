package facade;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneralSwitchFacade gsf=new GeneralSwitchFacade();
		gsf.on();
		System.out.println("*********");
		gsf.off();
	}

}
