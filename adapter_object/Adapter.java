package adapter_object;
import clone.MyFruit;
public class Adapter implements INewJuicer {

	protected OldJuicer oldJuicer;//�����빤��ģʽ���
    public String newPort(MyFruit fruit1, MyFruit fruit2){
    	oldJuicer=new OldJuicer();
    	String str="��Ϲ�֭��"+oldJuicer.onePort(fruit1)+"+";
    	str+=oldJuicer.onePort(fruit2);
        return str;
    }

}
