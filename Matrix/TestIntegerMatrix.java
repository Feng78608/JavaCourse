package Matrix;


public class TestIntegerMatrix {

	public static void main(String args[]){
		Integer[][] integerMatrix1=new Integer[][]{{1,2,3},{4,5,6},{7,8,9}};
		Integer[][] integerMatrix2=new Integer[][]{{9,8,7},{6,5,4},{3,2,1}};
		IntegerMatrix result=new IntegerMatrix();
		System.out.println("\nintegerMatrix1+integerMatrix2 is");
		GenericMatrix.printResult(integerMatrix1, integerMatrix2, result.addMatrix(integerMatrix1, integerMatrix2), '+');
		System.out.println("\nintegerMatrix1*integerMatrix2 is");
		GenericMatrix.printResult(integerMatrix1, integerMatrix2, result.mulyiplyMartix(integerMatrix1, integerMatrix2), '+');
	}

}

