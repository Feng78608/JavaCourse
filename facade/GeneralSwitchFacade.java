package facade;
public class GeneralSwitchFacade {
    private Light[] light;
    private Fan fan;
    private AirConditioner ac;
    private Television tv;

    public GeneralSwitchFacade(){
    	light=new Light[] {new Light("��ǰ"),new Light("��ǰ"),new Light("���"),new Light("�Һ�")};
    	fan=new Fan();
    	ac=new AirConditioner();
    	tv=new Television();
    }

    public void on(){
    	light[0].on();
    	light[1].on();
    	light[2].on();
    	light[3].on();
    	fan.on();
    	ac.on();
    	tv.on();
    }

    public void off(){
    	light[0].off();
    	light[1].off();
    	light[2].off();
    	light[3].off();
    	fan.off();
    	ac.off();
    	tv.off();
    }

}
