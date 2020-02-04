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
	//���ɵ������֤��
	private Random random = new Random();
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// �ڴ�ͼƬ����TYpe_int_BGRѡ��ͼƬģʽRGB
		BufferedImage image = new BufferedImage(90, 30, BufferedImage.TYPE_INT_BGR);
		// �õ�����
		Graphics graphics = image.getGraphics();
		// ���û�����ɫ
		graphics.setColor(Color.PINK);
		// ����������
		graphics.fillRect(0, 0, 90, 30);
		// ��ͼƬ���ϸ�����
		// ��������һ����
		for (int i = 0; i < 5; i++) {
			// �ߵ���ɫ�������
			graphics.setColor(getRandomColor());
			int x1 = random.nextInt(90);
			int y1 = random.nextInt(30);
			int x2 = random.nextInt(90);
			int y2 = random.nextInt(30);
			graphics.drawLine(x1, y1, x2, y2);
		}
		// ƴ���ĸ� ��֤�룬����ͼƬ��
		char[] arrays = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			// �����ַ���ɫ
			int index = random.nextInt(arrays.length);
			builder.append(arrays[index]);
		}
		// ����session ���󣬽����ɵ��ַ��������ֱ��浽session������
		request.getSession().setAttribute("checkCode", builder.toString());
		// ���ĸ��ַ�����ͼƬ��
		for (int i = 0; i < builder.toString().length(); i++) {
			graphics.setColor(getRandomColor());
			char item = builder.toString().charAt(i);
			graphics.drawString(item + "", 10 + (i * 20), 15);
		}
		// ����ڴ���Ƭ�������
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
