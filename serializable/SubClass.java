package serializable;

import java.io.Serializable;

public class SubClass extends PClass implements Serializable {
	private static final long serialVersionUID=1L;
	private int flag;
	public SubClass(int flagP,int flag) {
		super(flagP);
		this.flag=flag;
	}
}
