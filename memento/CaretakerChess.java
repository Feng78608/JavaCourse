package memento;

import java.util.ArrayList;

public class CaretakerChess {//¸ºÔğÈË
	
	private ArrayList<MementoChess> memlist=new ArrayList();
	
	public void addMem(MementoChess mem) {
		memlist.add(mem);
	}
	public MementoChess getMem(int i) {
		return memlist.get(i);
	}

}
