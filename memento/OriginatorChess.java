package memento;

public class OriginatorChess {//ԭ����
	
	private MementoChess memchess;
	
	public OriginatorChess(MementoChess memchess) {
		this.memchess= memchess;
	}
	
	public void setX(int x) {
		memchess.setX(x);
	}
	
	public void setY(int y) {
		memchess.setY(y);
	}
	
	public MementoChess SavetoMemento() {
		return new MementoChess(memchess.getLabel(),
				memchess.getX(),
				memchess.getY());
	}
	
	public void Restore(MementoChess mem) {
		this.memchess.setLabel(mem.getLabel());
		this.memchess.setX(mem.getX());
		this.memchess.setY(mem.getY());
	}
	
	public void Show() {
		System.out.println("��ǰ����״̬��"+memchess.getLabel()+
				"("+memchess.getX()+","+memchess.getY()+")");
	}

}
