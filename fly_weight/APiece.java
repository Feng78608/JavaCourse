package fly_weight;

public abstract class APiece {
	protected String inKind;
	public APiece(String inKind) {
		this.inKind=inKind;
	}
	//����ȷ�����ӵ�λ��
	public abstract void Play(int x,int y);
}
