package builderAndAbstractFactory;
public class Meal {
    private Food food;
    private Drink drink;
    
    public void setFood(Food food){
    	this.food=food;
    }

    public void setDrink(Drink drink){
    	this.drink=drink;
    }

    public Food getFood(){
        return food;
    }

    public Drink getDrink(){
        return drink;
    }

}
