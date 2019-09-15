package Proxy;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;


public class DynProxyFactory {

	public static Subject getInstance(){   

		  Subject delegate = new RealSubject();  
		  InvocationHandler handler = new SubjectInvocationHandler(delegate);  
		  Subject proxy = null;  
		  proxy = (Subject)Proxy.newProxyInstance(  
		    delegate.getClass().getClassLoader(),   
		    delegate.getClass().getInterfaces(),   
		    handler);  

		  return proxy;  

		 } 	
}
