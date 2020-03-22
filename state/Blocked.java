package state;
public class Blocked extends ThreadState {

    public  Blocked(){
    	state=StateSet.BLOCKED;
    	System.out.println("当前是阻塞状态");
    }

    public void resume(ThreadContext hj){
    	System.out.println("正在调用resume（）来继续");
    	if(state==StateSet.BLOCKED)
    		hj.setState(new Runnable());
    	else
        	System.out.println("当前不是阻塞状态");
    }

}
