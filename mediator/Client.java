package mediator;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AChatRoom room=new ChatGroup();
		Member member1,member2,member3,member4,member5;
		member1=new DiamondMember("����");
		member2=new DiamondMember("����");
		member3=new CommonMember("����");
		member4=new CommonMember("����");
		member5=new CommonMember("С��");
		
		room.register(member1);
		room.register(member2);
		room.register(member3);
		room.register(member4);
		room.register(member5);
		
		member1.sendImage("����","����ʦ������˭û�кú�ѧϰ.jpg");
		member2.sendText("����","���������ã�ȥ����ɣ�");
		member3.sendImage("����","en.jpg");
		member4.sendText("С��","¥�¸ý�˭�ˣ�");
		member5.sendText("����","<-����");
		
	}

}
