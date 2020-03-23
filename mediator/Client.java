package mediator;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AChatRoom room=new ChatGroup();
		Member member1,member2,member3,member4,member5;
		member1=new DiamondMember("张三");
		member2=new DiamondMember("李四");
		member3=new CommonMember("王五");
		member4=new CommonMember("消防");
		member5=new CommonMember("小红");
		
		room.register(member1);
		room.register(member2);
		room.register(member3);
		room.register(member4);
		room.register(member5);
		
		member1.sendImage("李四","让老师看看是谁没有好好学习.jpg");
		member2.sendText("张三","今天天气好，去打鱼吧！");
		member3.sendImage("消防","en.jpg");
		member4.sendText("小红","楼下该叫谁了！");
		member5.sendText("王五","<-他啊");
		
	}

}
