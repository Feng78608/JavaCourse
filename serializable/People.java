package serializable;

import java.io.Serializable;
//implements Serializable
public class People  implements Serializable{
		private static final long serialVersionUID=1L;
		private String name;
		private int age;
		public People(String name,int age) {
			this.name=name;
			this.age=age;
		}
	

}
