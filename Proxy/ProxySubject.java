package Proxy;

public class ProxySubject implements Subject {

	
	private Subject delegate;
	 public ProxySubject(Subject delegate) {
	  this.delegate = delegate;
	 } 
	@Override
	public void dealTask(String taskName) {
		// TODO Auto-generated method stub
		long stime = System.currentTimeMillis();
		  delegate.dealTask(taskName);
		  long ftime = System.currentTimeMillis();
		  System.out.println("执行任务耗时"+(ftime - stime)+"毫秒");
	}

}
