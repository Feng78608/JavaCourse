package builderAndAbstractFactory;
public class BConF implements BFactoryFD {

    public Food createF(){
        return new Chicken();
    }

    public Drink createD(){
        return null;
    }

}
