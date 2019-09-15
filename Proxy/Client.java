package Proxy;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject proxy=DynProxyFactory.getInstance();
		proxy.dealTask("DBQueryTask");
	}

}
