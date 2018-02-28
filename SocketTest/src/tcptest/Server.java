package tcptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于TCP协议的Socket通信，实现用户登录
 * 服务器端
 * 实现在服务器端获取客户端发送的信息，并响应客户端
 * 内容：服务器向客户端发送请求；
 * 客户端获取输出流 携带数据"用户名：admin;密码：123"；
 * 服务器获取输入流 得到客户端发送的数据；
 * 服务器获取输出流  携带数据"欢迎您！"；
 * 客户端获取输入流 得到服务器发送的数据；
 * @author jac
 *
 */
public class Server {
	public static void main(String[] args) {

		try {
			//		1、创建ServerSocket，绑定监听端口
			ServerSocket serverSocket=new ServerSocket(8888);//建议使用1024往后的端口
			//		2、通过accept方法监听客户端请求，等待客户端的连接
			System.out.println("————服务器即将开启，等待客户端的连接——");
			Socket socket=serverSocket.accept();//获取客户端发送的Socket实例，用于监听
			//		3、连接建立后，通过输入流读取客户端发送的请求信息（通过客户端的输入流读取客户端的信息）
			InputStream is=socket.getInputStream();//获取字节输入流
			InputStreamReader isr=new InputStreamReader(is);//转换字节流为字符流
			BufferedReader br=new BufferedReader(isr);//为字符输入流添加缓冲
			String info=null;
			while ((info=br.readLine())!=null) {//循环获取客户端的信息
				System.out.println("我是服务器，客户端说："+info);//info为从客户端获取的信息
			}
			socket.shutdownInput();//关闭输入流
			//			4、通过输出流向客户端发送响应的信息
			OutputStream os=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(os);//与客户端发送信息类似
			pw.write("欢迎您！");
			pw.flush();
			//		5、关闭相关资源
			pw.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			socket.close();
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
