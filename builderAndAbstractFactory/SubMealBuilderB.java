package builderAndAbstractFactory;
public class SubMealBuilderB extends MealBuilder {

    public void buildDrink(){

    	BFactoryFD af=new BConD();
    	Drink drink=af.createD();
    	meal.setDrink(drink);
    }

    public void buildFood(){
    	BFactoryFD af=new BConF();
    	Food food=af.createF();
    	meal.setFood(food);
    }

}
