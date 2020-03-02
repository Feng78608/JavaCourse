package builderAndAbstractFactory;
public class AConD implements AFactoryFD {

    public Food createF(){
        return null;
    }

    public Drink createD(){
        return new Cola();
    }

}
