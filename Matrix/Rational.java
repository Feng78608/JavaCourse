package Matrix;


public class Rational extends Number{//所有实数，都可以转换成分数，尤其表示无理数时

	private long numerator=0;//分子

	private long denominator=1;//分母

	public Rational(){

		this(0,1);

	}

	public Rational(long num1,long num2){//约分

		long gcd=gcd(num1,num2);

		this.numerator=(num2>0?1:-1)*num1/gcd;

		this.denominator=Math.abs(num2)/gcd;

	}

	private static long gcd(long n,long d){//寻找最大公因数

		long n1=Math.abs(n);

		long n2=Math.abs(d);

		int gcd=1;

		for(int k=1;k<=n1&&k<=n2;k++){

			if(n1%k==0&&n2%k==0)

				gcd=k;

		}

		return gcd;

	}

	public String toString(){

		if(denominator==1)//分母

			return numerator+"";

		else

			return numerator+"/"+denominator;

	}

	@Override

	public double doubleValue() {

		// TODO 自动生成的方法存根

		return numerator*1.0/denominator;

	}

	@Override

	public float floatValue() {

		// TODO 自动生成的方法存根

		return (float) doubleValue();

	}

	@Override

	public int intValue() {

		// TODO 自动生成的方法存根

		return (int) doubleValue();

	}

	@Override

	public long longValue() {

		// TODO 自动生成的方法存根

		return (long) doubleValue();

	}

	public long getNumerator(){

		return numerator;

	}

	public long GetDenominator(){//分母

		return denominator;

	}

	public Rational add(Rational second){

		long n=numerator*second.GetDenominator()+denominator*second.getNumerator();

		long d=denominator*second.GetDenominator();

		return new Rational(n,d);

	}

	public Rational multiply(Rational second){

		long n=numerator*second.getNumerator();

		long d=denominator*second.GetDenominator();

		return new Rational(n,d);

	}

 

}
