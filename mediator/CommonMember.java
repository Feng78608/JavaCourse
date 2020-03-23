package mediator;

public class CommonMember extends Member{
	
	public CommonMember(String name) {
		super(name);
	}

	@Override
	public void sendText(String to, String message) {
		// TODO Auto-generated method stub
		System.out.print("普通会员发消息：");
		chatRoom.sendText(name,to,message);
	}

	@Override
	public void sendImage(String to, String image) {
		// TODO Auto-generated method stub
		System.out.println("普通会员不能发图片");
	}

}
