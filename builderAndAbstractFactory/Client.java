package builderAndAbstractFactory;


public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		MealBuilder mb=(MealBuilder)XMLUtil.getBean();
		Waiter waiter=new Waiter();
		waiter.setMealBuilder(mb);
		Meal meal=waiter.construct();
		meal.getDrink().eat();
		meal.getFood().eat();
	}

}
