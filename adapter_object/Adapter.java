package adapter_object;
import clone.MyFruit;
public class Adapter implements INewJuicer {

	protected OldJuicer oldJuicer;//可以与工厂模式结合
    public String newPort(MyFruit fruit1, MyFruit fruit2){
    	oldJuicer=new OldJuicer();
    	String str="混合果汁："+oldJuicer.onePort(fruit1)+"+";
    	str+=oldJuicer.onePort(fruit2);
        return str;
    }

}
