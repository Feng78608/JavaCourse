package state;
public class Runnable extends ThreadState {

    public Runnable(){
    	state=StateSet.RUNNABLE;
    	System.out.println("当前是就绪状态");
    }

    public void getCPU(ThreadContext hj){
    	System.out.println("调用了getCPU（）来获得CPU时间");
    	if(state==StateSet.RUNNABLE)
    		hj.setState(new Running());
    	else
        	System.out.println("当前不是就绪状态");
    }

}
