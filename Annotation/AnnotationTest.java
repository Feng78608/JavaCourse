package Annotation;

public class AnnotationTest {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		TableProcessor processor=new TableProcessor();
		String sql=processor.process(System.getProperty("user.dir"));
		System.out.println(sql);
	}

}
