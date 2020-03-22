package command;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建多个订单
		Order order1=new Order();
		order1.setId(1);
		order1.setFruit("橙子", 1);
		order1.setFruit("里子", 2);
		order1.setFruit("梨", 3);
		
		
		Order order2=new Order();
		order2.setId(2);
		order2.setFruit("橙子", 1);
		order2.setFruit("栗子", 2);
		order2.setFruit("桃", 3);
		//创建操作者
		Operator op=new Operator();
		//将多个订单封装成命令对象
		ICommand cmd1=new OrderCommand(op,order1);
		ICommand cmd2=new OrderCommand(op,order2);
		//创建调用者并加命令
		waiterInvoker waiter=new waiterInvoker();
		waiter.setCommand(cmd1);
		waiter.setCommand(cmd2);
		//执行命令
		waiter.OrderUp();
	}

}
