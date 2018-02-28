package tcptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 服务器端线程处理类
 * 
 * @author jac
 * 
 */

public class ServerThread extends Thread {
	// 和本线程相关的Socket
	Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	/**
	 * 线程执行的操作，响应客户端的请求
	 */
	@Override
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String info = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			// 3、连接建立后，通过输入流读取客户端发送的请求信息（通过客户端的输入流读取客户端的信息）
			is = socket.getInputStream();// 获取字节输入流
			isr = new InputStreamReader(is);// 转换字节流为字符流
			br = new BufferedReader(isr);// 为字符输入流添加缓冲
			while ((info = br.readLine()) != null) {// 循环获取客户端的信息
				System.out.println("我是服务器，客户端说：" + info);// info为从客户端获取的信息
			}
			socket.shutdownInput();// 关闭输入流
			// 4、通过输出流向客户端发送响应的信息
			os = socket.getOutputStream();
			pw = new PrintWriter(os);// 与客户端发送信息类似
			pw.write("欢迎您！");
			pw.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5、关闭相关资源
			try {
				if (pw != null)
					pw.close();
				if (os != null)
					os.close();
				if (br != null)
					br.close();
				if (isr != null)
					isr.close();
				if (is != null)
					is.close();
				if (socket != null)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
