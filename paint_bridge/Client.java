package paint_bridge;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IColor color;
		Pen pen;
		color=(IColor)XMLUtilPaint.getBean("color");
		pen=(Pen)XMLUtilPaint.getBean("pen");
		pen.setColor(color);
		pen.draw("»¨³Ç");
	}

}
