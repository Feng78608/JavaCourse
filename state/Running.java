package state;
public class Running extends ThreadState {

    public Running(){
    	state=StateSet.RUNNING;
    	System.out.println("当前是运行状态");
    }

    public void suspend(ThreadContext hj){
    	System.out.println("正在调用suspend来暂停线程");
    	if(state==StateSet.RUNNING)
    		hj.setState(new Blocked());
    	else
        	System.out.println("当前不是运行状态");
    }

    public void stop(ThreadContext hj){
    	System.out.println("正在调用stop来终止线程");
    	if(state==StateSet.RUNNING)
    		hj.setState(new Dead());
    	else
    		System.out.println("当前不是运行状态");
    }

}
