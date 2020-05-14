package memento;

public class OriginatorChess {//原发器
	
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
		System.out.println("当前棋子状态："+memchess.getLabel()+
				"("+memchess.getX()+","+memchess.getY()+")");
	}

}
