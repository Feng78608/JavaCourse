package dproxy;

public class CTest implements ITest {

	@Override
	public void test(String name) {
		// TODO Auto-generated method stub
		System.out.println("����"+name+"�ĳ��ֻ��У�");
		for(int i=5;i>=0;i--) {
			System.out.println(i+"��");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		System.out.println("����ˢ������");
	}

}
