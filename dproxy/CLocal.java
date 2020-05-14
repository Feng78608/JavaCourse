package dproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CLocal {
	private Object target;//Ҫ����Ķ���
	public CLocal(Object target) {
		super();//Ϊ���������
		this.target=target;
	}
	public Object getProxyInstance() {
		return Proxy.newProxyInstance(//���ش������
				//�࣬�ӿڣ������б�����
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				new InvocationHandler() {
														//method��cremotepic�е�showpic����
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
						System.out.println("׼������ͼƬ��"+args[0]);
						Thread th=new Thread(new Runnable() {

							@Override
							public void run() {
								// TODO Auto-generated method stub
								try {
									method.invoke(target, args);//����ʵ�֣�Զ�̵���
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
