package dproxy;

public class CTest implements ITest {

	@Override
	public void test(String name) {
		// TODO Auto-generated method stub
		System.out.println("怪物"+name+"的出现还有：");
		for(int i=5;i>=0;i--) {
			System.out.println(i+"秒");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		System.out.println("怪物刷新啦！");
	}

}
