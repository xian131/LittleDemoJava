package tcptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端
 * 实现在服务器端获取客户端发送的信息，并响应客户端
 * @author jac
 *
 */
public class Client {
	public static void main(String[] args) {
		
		try {
			//	1、创建Socket，指定需要连接的服务器的地址和端口号
			Socket socket=new Socket("localhost",8888);
			//	2、连接建立后，通过输出流向服务器发送请求信息
			OutputStream os=socket.getOutputStream();//字节输出流
			PrintWriter pw=new PrintWriter(os);//将输出流包装为打印流
			pw.write("用户名：admin;密码：123");
			pw.flush();//刷新缓存，向服务器端发送信息
			socket.shutdownOutput();//关闭输出流
			//			3、通过输入流获取服务器响应的信息——暂无
			InputStream is=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			String info=null;
			while ((info=br.readLine())!=null) {
				System.out.println("我是客户端，服务器说："+info);//info为从服务器获取的信息
			}
			//	4、关闭相关资源
			br.close();
			isr.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
