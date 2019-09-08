package Drawing;

import Drawing.Shapes.Shape;
import java.util.*;

public class DrawView extends Shapes {

	public void onLButtonDblClk(/*UINT nFlag,CPoint point*/)//双击左键删除
	{
		System.out.println("双击左键删除图形");
	}
	public void OnLButtonDown(/*UINT nFlag,CPoint point*/)//ctrl+左键单击新建图形
	{
		System.out.println("ctrl+单击左键新建图形,请英文输入要建立的图形:S");
		Scanner inputString=new Scanner(System.in);
		String tempFigure=inputString.next();
			switch(tempFigure)
			{
			case "Square":
				{Shape p1=new Square();
				p1.Set(100, 100, 123, 123, 1, 2, "black", 3, "black","null","null");
				p1.Draw();
				break;}
			case "Circle":
				{Shape p2=new Circle();
				p2.Set(100, 100, 123, 123, 1, 2, "black", 3, "black","null","null");
				p2.Draw();
				break;}
			case "Retangle":
				{Shape p3=new Rectangle();
				p3.Set(100, 100, 123, 123, 1, 2, "black", 3, "black","null","null");
				p3.Draw();
				break;}
			case "Ellipse":
				{Shape p4=new Ellipse();
				p4.Set(100, 100, 123, 123, 1, 2, "black", 3, "black","null","null");
				p4.Draw();
				break;}
			case "Triangle":
				{Shape p5=new Triangle();
				p5.Set(100, 100, 123, 123, 1, 2, "black", 3, "black","null","null");
				p5.Draw();
				break;}
			case "Text":
				{Text p5=new Text();
				p5.Set(100, 100, 123, 123, 1, 2, "black", 3, "black","null","null");
				p5.Draw();
				break;}
			}
			
		}
		
	public void OnRButtonDblClk(/*UINT nFlag,CPoint point*/)//双击右键修改图形
	{
		System.out.println("双击右键修改图形");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("绘制图形");
		DrawView drawView=new DrawView();
		drawView.OnLButtonDown();
	}

}
