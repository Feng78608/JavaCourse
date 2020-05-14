package factory;
public class AFactory extends Factory {

    public Fruit createFruit(){
        return new Apple();
    }

}
