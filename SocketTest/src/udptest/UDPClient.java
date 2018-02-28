package udptest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 实现基于UDP的用户登录
 * 客户端
 * @author jac
 *
 */
public class UDPClient {

	public static void main(String[] args) throws IOException {
		/**
		 * 向服务器发送数据
		 */
//		1、定义发送信息
		InetAddress address=InetAddress.getByName("localhost");
		int port=8800;//端口号
		byte[] data="用户名：admin;密码：123".getBytes();
//		2、创建DatagramPacket，包含要发送的信息
		DatagramPacket packet=new DatagramPacket(data, data.length,address,port);//字节数组 大小 服务器地址 端口号
//		3、创建DatagramSocket
		DatagramSocket socket=new DatagramSocket();
//		4、发送数据
		socket.send(packet);
		/**
		 * 接收服务器响应的数据
		 */
//		1、创建数据报，用于接收服务器响应的数据，保存在字节数组
		byte[] data2=new byte[1024];
		DatagramPacket packet2=new DatagramPacket(data2, data2.length);
//		2、接收服务器响应的数据
		socket.receive(packet2);
//		3、读取数据
		String reply=new String(data2,0,packet2.getLength());
		System.out.println("我是客户端，服务器说："+reply);
//		4、关闭资源
		socket.close();
		

	}

}
