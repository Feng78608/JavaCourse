package Proxy;

public class Client1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject proxy = SubjectStaticFactory.getInstance();
		  proxy.dealTask("DBQueryTask");
	}

}
