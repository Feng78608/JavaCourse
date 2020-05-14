package mediator;

public abstract class  Member {

	protected String name;
	protected AChatRoom chatRoom;
	
	public Member(String name) {
		this.name=name;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public void setChatRoom(AChatRoom chatRoom) {
		// TODO Auto-generated method stub
		this.chatRoom=chatRoom;
	}


	public abstract void sendText(String to,String message);
	public abstract void sendImage(String to,String message);
	
	public void receiveText(String from, String newMessage) {
		// TODO Auto-generated method stub
		System.out.println(from+"发送文本给"+name+":"+newMessage);
	}

	public void receiveImage(String from, String image) {
		// TODO Auto-generated method stub
		System.out.println(from+"发送图片给"+name+":"+image);
		
	}

}
