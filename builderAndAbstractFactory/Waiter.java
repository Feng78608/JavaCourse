package builderAndAbstractFactory;
public class Waiter {
    private MealBuilder mb;

    public void setMealBuilder(MealBuilder mb){
    	this.mb=mb;
    }

    public Meal construct(){
    	mb.buildDrink();
    	mb.buildFood();
    	return mb.getMeal();
    }

}
