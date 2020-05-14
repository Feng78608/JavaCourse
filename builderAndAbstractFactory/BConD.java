package builderAndAbstractFactory;
public class BConD implements BFactoryFD {

    public Food createF(){
        return null;
    }

    public Drink createD(){
        return new Juice();
    }

}
