package dproxy;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  IShowPic pic=new CRemotePic();//������ 
		  CLocal local=new CLocal(pic); 
		  IShowPic sp=(IShowPic)local.getProxyInstance();//������ 
		  sp.showPic("�ϻ�");
		 
		  //ֻҪ�ӿڵĺ������ƣ�����������ͬ������ʹ��CLocal�����ش�����
		
		ITest test=new CTest();
		CLocal local2=new CLocal(test);
		ITest conTest=(ITest)local2.getProxyInstance();
		conTest.test("ʨ��");
	}

}
