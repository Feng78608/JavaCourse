package Client_5;


//客户端

import java.io.BufferedReader;

import java.io.File;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.io.OutputStream;

import java.io.OutputStreamWriter;

import java.io.PrintWriter;

import java.net.ServerSocket;

import java.net.Socket;

import java.net.UnknownHostException;



public class FileClient {

	public static void main(String[] args) {

		Socket server=new Socket();

		try {

			String inputString;

			server=new Socket("localhost",8888);

			System.out.println("请输入信息：");

			BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));

			PrintWriter os=new PrintWriter(server.getOutputStream());

			BufferedReader is=new BufferedReader(new InputStreamReader(server.getInputStream()));

			inputString=sin.readLine();

			while(inputString!=null&&!inputString.trim().equals("quit")) {

				os.println(inputString);

				os.flush();

				System.out.println("Client发送的消息为："+inputString);

				System.out.println("Server发送的消息为"+is.readLine());
				System.out.println("客户端请输入信息：");
				inputString=sin.readLine();

			}

			os.close();

			is.close();

			server.close();

			System.out.println("聊天结束！");

		}catch(UnknownHostException e) {

			e.printStackTrace();

			}

			catch(Exception e) {

			e.printStackTrace();

		}

	}

	}


