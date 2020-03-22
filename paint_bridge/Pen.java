package paint_bridge;
public abstract class Pen {
    protected IColor color;

    public void setColor(IColor color){
    	this.color=color;
    }

    public abstract void draw(String name);

}
