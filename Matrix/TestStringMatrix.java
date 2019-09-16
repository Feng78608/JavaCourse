package Matrix;

public class TestStringMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] stringMartrix1=new String[3][3];
		String[][] stringMartrix2=new String[3][3];
			for(int i=0;i<stringMartrix1.length;i++)
				for(int j=0;j<stringMartrix1[0].length;j++){
					stringMartrix1[i][j]="a";
					stringMartrix2[i][j]="A";
				}
		StringMatrix result=new StringMatrix();
		System.out.println("\nstringMartrix1+stringMartrix2 is");
		StringMatrix.printResult(stringMartrix1, stringMartrix2, result.addMatrix(stringMartrix1, stringMartrix2), '+');
		System.out.println("\nstringMartrix1*stringMartrix2 is");
		StringMatrix.printResult(stringMartrix1, stringMartrix2, result.mulyiplyMartix(stringMartrix1, stringMartrix2), '*');

	}

}
