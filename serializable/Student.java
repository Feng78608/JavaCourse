package serializable;

import java.io.Serializable;

public class Student extends People {
	//private static final long serialVersionUID=1L;
	private String className;
	public Student(String className,String name,int age) {
		super(name,age);
		this.className=className;
	}

}
