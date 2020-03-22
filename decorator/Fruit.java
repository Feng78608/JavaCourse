package decorator;
public class Fruit extends Decorating {

    public Fruit(IBirthdayCake birthdayCake){
    	super(birthdayCake);
    }

	public void show(){ 
		super.show();
		System.out.println("Fruit"); }
	 

    public void putFruit(){
        System.out.println("Add Fruit...");
    }

}
