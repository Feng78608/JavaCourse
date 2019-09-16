package Matrix;

public class StringMatrix {

	protected  String add(String o1,String o2)
	{
		return o1+o2;
	}

	protected  String multiply(String o1,String o2)
	{
		return o1+o2;
	}

	protected  String zero()
	{
		return " ";
	}
	
	public String[][] addMatrix(String[][]matrix1,String[][]matrix2){		
		if((matrix1.length!=matrix2.length)||(matrix1[0].length!=matrix2[0].length)){			
			throw new RuntimeException("The matrices do not have the same size");					
		}		
	String[][] result=(String[][])new String[matrix1.length][matrix1[0].length];		
	for(int i=0;i<result.length;i++)			
		for(int j=0;j<result[i].length;j++){				
			result[i][j]=add(matrix1[i][j],matrix2[i][j]);			
		}		
	return result;	
	}	
	
	public String[][] mulyiplyMartix(String[][]matrix1,String[][]matrix2){		
		if((matrix1[0].length!=matrix2.length)){			
			throw new RuntimeException("The matrices can not be multiplied");					
		}		
		String[][] result=(String[][])new String[matrix1.length][matrix2[0].length];		
		for(int i=0;i<result.length;i++)			
			for(int j=0;j<result[0].length;j++){				
				result[i][j]=zero();//做加法前清零				
				for(int k=0;k<matrix1[0].length;k++){					
					result[i][j]=add(result[i][j],multiply(matrix1[i][k],matrix2[k][j]));				
				}							
			}		
		return result;		
	}	
	public static void printResult(String[][] m1,String[][] m2,String[][]m3,char op){	//三个矩阵并排输出，op表示符号“+” “*”	
		for(int i=0;i<m1.length;i++){			
			for(int j=0;j<m1[0].length;j++)				
				System.out.print("\t"+m1[i][j]);			
			if(i==m1.length/2)				
				System.out.print("\t"+op);			
			else				
				System.out.print("\t");			
			for(int j=0;j<m2.length;j++)				
				System.out.print("\t"+m2[i][j]);			
			if(i==m1.length/2)				
				System.out.print("=\t");			
			else				
				System.out.print("\t");			
			for(int j=0;j<m3.length;j++)				
				System.out.print(m3[i][j]+"\t");			
			System.out.println();				
		}	
	}
	
}
