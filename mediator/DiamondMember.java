package mediator;

public class DiamondMember extends Member{
	
	public DiamondMember(String name) {
		super(name);
	}

	@Override
	public void sendText(String to, String message) {
		// TODO Auto-generated method stub
		System.out.print("钻石会员发消息：");
		chatRoom.sendText(name,to,message);
	}

	@Override
	public void sendImage(String to, String image) {
		// TODO Auto-generated method stub
		System.out.print("钻石会员发图片：");
		chatRoom.sendImage(name, to, image);
	}

}
