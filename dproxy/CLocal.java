package dproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CLocal {
	private Object target;//要代理的对象
	public CLocal(Object target) {
		super();//为了适配基类
		this.target=target;
	}
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(//返回代理对象
				//类，接口，参数列表（动作
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				new InvocationHandler() {
														//method即cremotepic中的showpic（）
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
						System.out.println("准备载入图片："+args[0]);
						Thread th=new Thread(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								try {
									method.invoke(target, args);//具体实现，远程调用
								} catch (IllegalAccessException | IllegalArgumentException
										| InvocationTargetException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							
						});
						th.start();
						return null;
					}
			
		});
	} 
}
