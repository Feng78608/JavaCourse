package fly_weight;

public abstract class APiece {
	protected String inKind;
	public APiece(String inKind) {
		this.inKind=inKind;
	}
	//用来确定落子的位置
	public abstract void Play(int x,int y);
}
