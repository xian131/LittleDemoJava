package udptest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * ʵ�ֻ���UDP���û���¼
 * �ͻ���
 * @author jac
 *
 */
public class UDPClient {

	public static void main(String[] args) throws IOException {
		/**
		 * ���������������
		 */
//		1�����巢����Ϣ
		InetAddress address=InetAddress.getByName("localhost");
		int port=8800;//�˿ں�
		byte[] data="�û�����admin;���룺123".getBytes();
//		2������DatagramPacket������Ҫ���͵���Ϣ
		DatagramPacket packet=new DatagramPacket(data, data.length,address,port);//�ֽ����� ��С ��������ַ �˿ں�
//		3������DatagramSocket
		DatagramSocket socket=new DatagramSocket();
//		4����������
		socket.send(packet);
		/**
		 * ���շ�������Ӧ������
		 */
//		1���������ݱ������ڽ��շ�������Ӧ�����ݣ��������ֽ�����
		byte[] data2=new byte[1024];
		DatagramPacket packet2=new DatagramPacket(data2, data2.length);
//		2�����շ�������Ӧ������
		socket.receive(packet2);
//		3����ȡ����
		String reply=new String(data2,0,packet2.getLength());
		System.out.println("���ǿͻ��ˣ�������˵��"+reply);
//		4���ر���Դ
		socket.close();
		

	}

}
