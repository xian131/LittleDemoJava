package udptest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * ʵ�ֻ���UDP���û���¼
 * ������
 * ���������տͻ��˷��͵����ݣ���ͻ�����Ӧ����
 * @author jac
 *
 */
public class UDPServer {

	public static void main(String[] args) throws IOException {
		/**
		 * ���������տͻ��˷��͵�����
		 */
//		1������DatagramSocketָ���˿ں�
		DatagramSocket socket=new DatagramSocket(8800);
//		2������DatagramPacket
		byte[] data=new byte[2014];//�����ֽ�����ָ�����յ����ݱ��Ĵ�С
		DatagramPacket packet=new DatagramPacket(data, data.length);
//		3�����տͻ��˷��͵�������Ϣ
		System.out.println("�����������Ѿ��������ȴ��ͻ��˷������ݡ���");
		socket.receive(packet);//�˷����ڽ��յ�����֮ǰ��һֱ����
//		4����ȡ����
		String info=new String(data,0,packet.getLength());//�ֽ����� λ�� ��С
		System.out.println("���Ƿ��������ͻ���˵��"+info);
		
		/**
		 * ��ͻ�����Ӧ����
		 */
//		1������ͻ��˵ĵ�ַ �˿ں� ����
		InetAddress address=packet.getAddress();//��ַ
		int port=packet.getPort();//�˿ں�
		byte[] data2="��ӭ����".getBytes();//����
//		2���������ݱ���������Ӧ��������Ϣ
		DatagramPacket packet2=new DatagramPacket(data2, data2.length,address,port);
//		3����Ӧ�ͻ���
		socket.send(packet2);
//		4���ر���Դ
		socket.close();
	}

}
