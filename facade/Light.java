package facade;
public class Light {
    private String position;

    public Light(String position){
    	this.position=position;
    }

    public void on(){
    	System.out.println(position+"µÆ´ò¿ª£¡");
    }

    public void off(){
    	System.out.println(position+"µÆ¹Ø±Õ£¡");
    }

}
