package builderAndAbstractFactory;
public class SubMealBuilderA extends MealBuilder {

    public void buildDrink(){
    	AFactoryFD af=new AConD();
    	Drink drink=af.createD();
    	meal.setDrink(drink);
    }

    public void buildFood(){
    	AFactoryFD af=new AConF();
    	Food food=af.createF();
    	meal.setFood(food);
    }

}
