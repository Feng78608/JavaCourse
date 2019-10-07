package Server_5;


//服务端

import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.io.PrintWriter;

import java.net.ServerSocket;

import java.net.Socket;

 

public class FileServer {

public static void main(String[] args) {

    try {

        ServerSocket server=null;

        try {

          server=new ServerSocket(8888);

            }catch(Exception e)

        {

                System.out.println("Error:"+e);

                System.exit(-1);

        }

        Socket client=null;

        try {

            client=server.accept();

        }catch(Exception e) {

            System.out.println("接受请求失败");

            System.exit(-1);

        }

        String inputString;

        BufferedReader is=new BufferedReader(new InputStreamReader(client.getInputStream()));

        PrintWriter os=new PrintWriter(client.getOutputStream());

        BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Client发送的信息为："+is.readLine());
        System.out.println("Server输入消息:");
        inputString =sin.readLine();

        while(inputString!=null&&!inputString.trim().equals("quit")) {

            os.println(inputString);

            os.flush();

            System.out.println("Server发送的消息为："+inputString);

            System.out.println("Client发送的消息为"+is.readLine());
            System.out.println("Server输入消息:");
            inputString=sin.readLine();

        }

        os.close();

        is.close();

        client.close();

        server.close();

        server.close();

        System.out.println("聊天结束！");

    }catch(Exception e) {

        System.out.println("Error:"+e);

    }

}

}

//运行结果

 
