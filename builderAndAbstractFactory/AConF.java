package builderAndAbstractFactory;
public class AConF implements AFactoryFD {

    public Food createF(){
        return new Hamberge();
    }

    public Drink createD(){
        return null;
    }

}
