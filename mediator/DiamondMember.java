package mediator;

public class DiamondMember extends Member{
	
	public DiamondMember(String name) {
		super(name);
	}

	@Override
	public void sendText(String to, String message) {
		// TODO Auto-generated method stub
		System.out.print("��ʯ��Ա����Ϣ��");
		chatRoom.sendText(name,to,message);
	}

	@Override
	public void sendImage(String to, String image) {
		// TODO Auto-generated method stub
		System.out.print("��ʯ��Ա��ͼƬ��");
		chatRoom.sendImage(name, to, image);
	}

}
