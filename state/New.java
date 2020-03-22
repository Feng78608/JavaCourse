package state;
public class New extends ThreadState {

    public New(){
    	state=StateSet.NEW;
    	System.out.println("新建线程");
    }

    public void start(ThreadContext hj){
    	System.out.println("调用了start方法");
    	if(state==StateSet.NEW)
    		hj.setState(new Runnable());//可用享元模式
    	else
    		System.out.println("当前线程不是新建状态");
    }

}
