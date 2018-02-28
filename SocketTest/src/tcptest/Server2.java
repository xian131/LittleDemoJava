package tcptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的Socket通信，实现用户登录 服务器端
 * 通过循环监听等待客户端，开启服务器端线程处理类来实现多客户端通信
 * @author jac
 * 
 */
public class Server2 {
	public static void main(String[] args) {

		try {
			// 1、创建ServerSocket，绑定监听端口
			ServerSocket serverSocket = new ServerSocket(8888);// 建议使用1024往后的端口
			// 2、通过accept方法监听客户端请求，等待客户端的连接
			Socket socket = null;
			int count = 0;// 记录客户端数量
			System.out.println("————服务器即将开启，等待客户端的连接——");
			while (true) {// 循环监听等待客户端的连接
				socket = serverSocket.accept();// 获取客户端发送的Socket实例，用于监听
				// 创建一个新线程
				ServerThread serverThread = new ServerThread(socket);
				// 启动线程
				serverThread.start();
				count++;
				System.out.println("客户端的数量：" + count);
				//可以通过InetAddress获取客户端IP
				InetAddress address=socket.getInetAddress();
				System.out.println("当前客户端的IP："+address.getHostAddress());
			}
			// serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
