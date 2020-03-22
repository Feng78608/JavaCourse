package decorator;

public class Cream extends Decorating {

	public Cream(IBirthdayCake birthdayCake) {
		super(birthdayCake);
	}
	
	 public void show(){ 
		 super.show();
		 System.out.println("Cream"); }
	 

	public void putCream() {
		System.out.println("Add Cream...");
	}

}
