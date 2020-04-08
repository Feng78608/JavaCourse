package simple_factory;
public class Factory {

    public Fruit createFruit(String kind){
    	if(kind.equals("A"))
    		return new Apple();
    	if(kind.equals("B"))
    		return new Banana();
        return null;
    }

}
