package state;
public class Blocked extends ThreadState {

    public  Blocked(){
    	state=StateSet.BLOCKED;
    	System.out.println("��ǰ������״̬");
    }

    public void resume(ThreadContext hj){
    	System.out.println("���ڵ���resume����������");
    	if(state==StateSet.BLOCKED)
    		hj.setState(new Runnable());
    	else
        	System.out.println("��ǰ��������״̬");
    }

}
