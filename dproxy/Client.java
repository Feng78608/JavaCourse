package dproxy;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  IShowPic pic=new CRemotePic();//被代理 
		  CLocal local=new CLocal(pic); 
		  IShowPic sp=(IShowPic)local.getProxyInstance();//代理者 
		  sp.showPic("老虎");
		 
		  //只要接口的函数相似，参数个数相同，即可使用CLocal来返回代理者
		
		ITest test=new CTest();
		CLocal local2=new CLocal(test);
		ITest conTest=(ITest)local2.getProxyInstance();
		conTest.test("狮子");
	}

}
