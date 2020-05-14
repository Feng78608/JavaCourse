package command;

import java.util.ArrayList;

public class waiterInvoker {
	private ArrayList<ICommand> commands=null;
	public waiterInvoker() {
		commands=new ArrayList();
	}
	public void setCommand(ICommand cmd) {
		commands.add(cmd);
	}
	public void OrderUp() {
		System.out.println("ÓÐ¶©µ¥");
		for(ICommand cmd:commands) {
			if(cmd!=null)
				cmd.execute();
		}
	}
}
