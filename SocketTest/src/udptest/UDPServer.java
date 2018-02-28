package udptest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 实现基于UDP的用户登录
 * 服务器
 * 服务器接收客户端发送的数据，向客户端响应数据
 * @author jac
 *
 */
public class UDPServer {

	public static void main(String[] args) throws IOException {
		/**
		 * 服务器接收客户端发送的数据
		 */
//		1、创建DatagramSocket指定端口号
		DatagramSocket socket=new DatagramSocket(8800);
//		2、创建DatagramPacket
		byte[] data=new byte[2014];//创建字节数组指定接收的数据报的大小
		DatagramPacket packet=new DatagramPacket(data, data.length);
//		3、接收客户端发送的数据信息
		System.out.println("——服务器已经启动，等待客户端发送数据——");
		socket.receive(packet);//此方法在接收到数据之前会一直阻塞
//		4、读取数据
		String info=new String(data,0,packet.getLength());//字节数组 位置 大小
		System.out.println("我是服务器，客户端说："+info);
		
		/**
		 * 向客户端响应数据
		 */
//		1、定义客户端的地址 端口号 数据
		InetAddress address=packet.getAddress();//地址
		int port=packet.getPort();//端口号
		byte[] data2="欢迎您！".getBytes();//数据
//		2、创建数据报，包含响应的数据信息
		DatagramPacket packet2=new DatagramPacket(data2, data2.length,address,port);
//		3、响应客户端
		socket.send(packet2);
//		4、关闭资源
		socket.close();
	}

}
