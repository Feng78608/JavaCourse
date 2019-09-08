package Drawing;



public class Shapes {

	public abstract class Shape
	{

		
		public double orgX,orgY;
		public double width,high;
		public String borderColor;//边框颜色
		public int borderType;//边框类型
		public int borderWidth;//边框宽度
		public String fillColor;//填充颜色
		public int fillType;//填充类型
		public String font;//字体
		public String text;
		
		public abstract void Draw();
		public abstract boolean IsMatched(double x,double y);//定位判断此时鼠标是否在图形内
		public void Set(double x,double y,double width,double high,int borderType,int borderWidth,
			String borderColor,int fillType,String fillColor,String font,String text)
		{
			this.orgX=x;
			this.orgY=y;
			this.width=width;
			this.high=high;
			this.borderType=borderType;
			this.borderWidth=borderWidth;
			this.borderColor=borderColor;
			this.fillType=fillType;
			this.fillColor=fillColor;
			this.font=font;
			this.text=text;
		}
	}
	
	public class Square extends Shape
	{
		public void Draw()
		{
			System.out.println("以传入坐标为中心，画一个正方形");
		}
		public boolean IsMatched(double x,double y)
		{
			if(x>=(orgX-width/2)&&x<=(orgX+width/2)&&y>=(orgY-width/2)&&y<=(orgY+width/2))
				return true;
			else
				return false;
		}	
	}
	
	public class Circle extends Shape
	{
		public double radius;
		Circle()
		{}
		Circle(double radius)
		{
			this.radius=radius;
		}
		public void Draw()
		{
			System.out.println("以传入坐标为中心，画一个圆");
		}
		public boolean IsMatched(double x,double y)
		{
			if((Math.pow((double)(x-orgX),2.0)+Math.pow((double)(y-orgY),2.0))<=Math.pow((double)(radius/2),2.0))
				return true;
			else
				return false;
		}
	}
	
	public class Rectangle extends Shape
	{
		public void Draw()
		{
			System.out.println("以传入坐标为中心，画一个矩形");
		}
		public boolean IsMatched(double x,double y)
		{
			if(x>=(orgX-width/2)&&x<=(orgX+width/2)&&y>=(orgY-high/2)&&y<=(orgY+high/2))
				return true;
			else
				return false;
		}
	}
	
	public class Ellipse extends Shape
	{
		public void Draw()
		{
			System.out.println("以传入坐标为中心，画一个椭圆");
		}
		public boolean IsMatched(double x,double y)
		{
			if((Math.pow((double)(x-orgX),2)/(width*width/4)+Math.pow((double)(y-orgY),2)/(high*high/4))<=1)
				return true;
			else
				return false;
		}
	}
	
	public class Triangle extends Shape
	{
		public void Draw()
		{
			System.out.println("以传入坐标为中心，画一个三角形");
		}
		public boolean IsMatched(double x,double y)
		{
			if((Math.pow((double)(x-orgX),2)/(width*width/4)+Math.pow((double)(y-orgY),2)/(high*high/4))<=1)
				return true;
			else
				return false;
		}
	}
	
	public class Text extends Shape
	{
		Text()
		{}
		public double lenghFont,angle;
		Text(double lenghFont,double angle)
		{
			this.lenghFont=lenghFont;
			this.angle=angle;
		}
		public void Draw()
		{
			System.out.println("以传入坐标为中心，写出一串字符");
		}
		public boolean IsMatched(double x,double y)
		{
			if((y+x*Math.tan((double)angle/10))>=(orgX*Math.tan((double)angle/10)+orgY)&&
					(y+x*Math.tan((double)angle/10))<=((orgX+high*Math.sin((double)angle/10))*Math.tan((double)angle/10)+orgY+high*Math.cos((double)angle/10))&&
					(y-x/Math.tan((double)angle/10))>=(-(orgX+20*lenghFont*Math.cos((double)angle/10))/Math.tan((double)angle/10)+orgY-20*lenghFont*Math.sin((double)angle/10))&&
					(y-x/Math.tan((double)angle/10))<=(-orgX/Math.tan((double)angle/10)+orgY))
				return true;
			else
				return false;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("定义");
	}

}
