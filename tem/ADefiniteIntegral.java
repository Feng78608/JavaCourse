package tem;

public abstract class ADefiniteIntegral {
	abstract protected double geta();//����
	abstract protected double getb();//����
	abstract protected int getc();//�зֵ�Ԫ��
	abstract protected double function(double x);//����f(x)
	public final double CalDefiniteIntegral() {
		double a=0,b=0,t=0,sum=0;
		int c=0;
		a=geta();
		b=getb();
		c=getc();
		if(a>b) {
			t=a;a=b;b=t;
		}
		t=(b-a)/(double)c;
		for(int i=1;i<=c;i++) {
			sum+=t*function(a+i*t);
		}
		return sum;
	}
	
}