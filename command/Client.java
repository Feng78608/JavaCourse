package command;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����������
		Order order1=new Order();
		order1.setId(1);
		order1.setFruit("����", 1);
		order1.setFruit("����", 2);
		order1.setFruit("��", 3);
		
		
		Order order2=new Order();
		order2.setId(2);
		order2.setFruit("����", 1);
		order2.setFruit("����", 2);
		order2.setFruit("��", 3);
		//����������
		Operator op=new Operator();
		//�����������װ���������
		ICommand cmd1=new OrderCommand(op,order1);
		ICommand cmd2=new OrderCommand(op,order2);
		//���������߲�������
		waiterInvoker waiter=new waiterInvoker();
		waiter.setCommand(cmd1);
		waiter.setCommand(cmd2);
		//ִ������
		waiter.OrderUp();
	}

}
