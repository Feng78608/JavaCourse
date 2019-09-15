package Proxy;

public class SubjectStaticFactory {
	public static Subject getInstance() {
		return new ProxySubject(new RealSubject());
	}
}
