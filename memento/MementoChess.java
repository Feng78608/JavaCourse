package memento;

public class MementoChess {//±¸ÍüÂ¼
	
	private String label;
	private int x,y;

	public MementoChess(String label, int x, int y) {
		// TODO Auto-generated constructor stub
		this.label=label;
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}


}
