package state;
public class Running extends ThreadState {

    public Running(){
    	state=StateSet.RUNNING;
    	System.out.println("��ǰ������״̬");
    }

    public void suspend(ThreadContext hj){
    	System.out.println("���ڵ���suspend����ͣ�߳�");
    	if(state==StateSet.RUNNING)
    		hj.setState(new Blocked());
    	else
        	System.out.println("��ǰ��������״̬");
    }

    public void stop(ThreadContext hj){
    	System.out.println("���ڵ���stop����ֹ�߳�");
    	if(state==StateSet.RUNNING)
    		hj.setState(new Dead());
    	else
    		System.out.println("��ǰ��������״̬");
    }

}
