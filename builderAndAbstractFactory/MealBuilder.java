package builderAndAbstractFactory;
public abstract class MealBuilder {
    protected  Meal meal;
    public MealBuilder() {
    	meal=new Meal();
    }

    public abstract void buildFood();
    
    public abstract void buildDrink();

    public Meal getMeal(){
        return meal;
    }

}
