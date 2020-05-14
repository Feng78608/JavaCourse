package plate;

import java.util.ArrayList;
import java.util.List;

public class Plate extends MyElement {
    private List<MyElement> list=new ArrayList();

    public void eat(){
    	for(MyElement obj:list) {
    		obj.eat();
    	}
    }

    public void add(MyElement element){
    	list.add(element);
    }

    public void remove(MyElement element){
    	list.remove(element);
    }

}
