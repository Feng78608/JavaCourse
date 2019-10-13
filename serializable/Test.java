package serializable;

import java.io.Serializable;

public class Test {

	public static void IsSerializable(Object obj) {
		if(obj instanceof Serializable)
			System.out.println(obj.toString()+"序列化");
		else
			System.out.println(obj.toString()+"未序列化");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		People person=new People("A",18);
		Student student=new Student("class","A",18);
		PClass pClass=new PClass(18);
		SubClass subclass=new SubClass(18,1);
		System.out.println("父类实现Serializable，子类未实现Serializable：");
		System.out.println("父类:");
		IsSerializable(person);
		System.out.println("子类:");
		IsSerializable(student);
		System.out.println("--------------------------------------------");
		System.out.println("父类未实现Serializable，子类实现Serializable：");
		System.out.println("父类:");
		IsSerializable(pClass);
		System.out.println("子类:");
		IsSerializable(subclass);
		
		
	}

}
/*
 * 父类实现Serializable，子类未实现Serializable： 父类: serializable.People@27bc2616序列化 子类:
 * serializable.Student@3941a79c序列化 --------------------------------------------
 * 父类未实现Serializable，子类实现Serializable： 父类: serializable.PClass@506e1b77未序列化 子类:
 * serializable.SubClass@4fca772d序列化
 */