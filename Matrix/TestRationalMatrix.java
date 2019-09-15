package Matrix;


public class TestRationalMatrix {

	public static void main(String []args){

		Rational[][] rationalMartrix1=new Rational[3][3];
		Rational[][] rationalMartrix2=new Rational[3][3];
			for(int i=0;i<rationalMartrix1.length;i++)
				for(int j=0;j<rationalMartrix1[0].length;j++){
					rationalMartrix1[i][j]=new Rational(i,j);
					rationalMartrix2[i][j]=new Rational(i,j);
				}
		RationalMatrix result=new RationalMatrix();
		System.out.println("\nrationalMartrix1+rationalMartrix2 is");
		GenericMatrix.printResult(rationalMartrix1, rationalMartrix2, result.addMatrix(rationalMartrix1, rationalMartrix2), '+');
		System.out.println("\nrationalMartrix1*rationalMartrix2 is");
		GenericMatrix.printResult(rationalMartrix1, rationalMartrix2, result.mulyiplyMartix(rationalMartrix1, rationalMartrix2), '*');

	}

}

