package state;
public class Runnable extends ThreadState {

    public Runnable(){
    	state=StateSet.RUNNABLE;
    	System.out.println("��ǰ�Ǿ���״̬");
    }

    public void getCPU(ThreadContext hj){
    	System.out.println("������getCPU���������CPUʱ��");
    	if(state==StateSet.RUNNABLE)
    		hj.setState(new Running());
    	else
        	System.out.println("��ǰ���Ǿ���״̬");
    }

}
