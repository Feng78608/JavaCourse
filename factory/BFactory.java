package factory;
public class BFactory extends Factory {

    public Fruit createFruit(){
        return new Banana();
    }

}
