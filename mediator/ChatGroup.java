package mediator;

import java.util.Hashtable;

public class ChatGroup extends AChatRoom {
	
	private Hashtable members=new Hashtable();

	@Override
	public void register(Member member) {
		// TODO Auto-generated method stub
		if(!members.contains(member)) {
			members.put(member.getName(), member);
			member.setChatRoom(this);
		}

	}

	@Override
	public void sendText(String from, String to, String message) {
		// TODO Auto-generated method stub
		Member member=(Member)members.get(to);
		String newMessage=message;
		newMessage=message.replaceAll("´ò", "*");
		member.receiveText(from,newMessage);
	}

	@Override
	public void sendImage(String from, String to, String image) {
		// TODO Auto-generated method stub
		Member member=(Member)members.get(to);
		if(image.length()>5)
			System.out.println("Í¼Æ¬Ì«´ó£¬·¢ËÍÊ§°Ü£¡");
		else
			member.receiveImage(from,image);
	}

}
