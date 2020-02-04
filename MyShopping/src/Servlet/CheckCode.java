package Servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckCode extends HttpServlet {
	//生成的随机验证码
	private Random random = new Random();
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// 内存图片对象（TYpe_int_BGR选择图片模式RGB
		BufferedImage image = new BufferedImage(90, 30, BufferedImage.TYPE_INT_BGR);
		// 得到画笔
		Graphics graphics = image.getGraphics();
		// 设置画笔颜色
		graphics.setColor(Color.PINK);
		// 填充矩形区域
		graphics.fillRect(0, 0, 90, 30);
		// 给图片加上干扰线
		// 给两点连一条线
		for (int i = 0; i < 5; i++) {
			// 线的颜色可以随机
			graphics.setColor(getRandomColor());
			int x1 = random.nextInt(90);
			int y1 = random.nextInt(30);
			int x2 = random.nextInt(90);
			int y2 = random.nextInt(30);
			graphics.drawLine(x1, y1, x2, y2);
		}
		// 拼接四个 验证码，画到图片上
		char[] arrays = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			// 设置字符颜色
			int index = random.nextInt(arrays.length);
			builder.append(arrays[index]);
		}
		// 创建session 对象，将生成的字符串以名字保存到session对象中
		request.getSession().setAttribute("checkCode", builder.toString());
		// 将四个字符画到图片上
		for (int i = 0; i < builder.toString().length(); i++) {
			graphics.setColor(getRandomColor());
			char item = builder.toString().charAt(i);
			graphics.drawString(item + "", 10 + (i * 20), 15);
		}
		// 输出内存照片到输出流
		ImageIO.write(image, "png", response.getOutputStream());
	}

	private Color getRandomColor() {
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		return new Color(r, g, b);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}

}
