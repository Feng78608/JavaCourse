package state;
public class New extends ThreadState {

    public New(){
    	state=StateSet.NEW;
    	System.out.println("�½��߳�");
    }

    public void start(ThreadContext hj){
    	System.out.println("������start����");
    	if(state==StateSet.NEW)
    		hj.setState(new Runnable());//������Ԫģʽ
    	else
    		System.out.println("��ǰ�̲߳����½�״̬");
    }

}
