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
 * ����TCPЭ���Socketͨ�ţ�ʵ���û���¼ ��������
 * ͨ��ѭ�������ȴ��ͻ��ˣ��������������̴߳�������ʵ�ֶ�ͻ���ͨ��
 * @author jac
 * 
 */
public class Server2 {
	public static void main(String[] args) {

		try {
			// 1������ServerSocket���󶨼����˿�
			ServerSocket serverSocket = new ServerSocket(8888);// ����ʹ��1024����Ķ˿�
			// 2��ͨ��accept���������ͻ������󣬵ȴ��ͻ��˵�����
			Socket socket = null;
			int count = 0;// ��¼�ͻ�������
			System.out.println("�������������������������ȴ��ͻ��˵����ӡ���");
			while (true) {// ѭ�������ȴ��ͻ��˵�����
				socket = serverSocket.accept();// ��ȡ�ͻ��˷��͵�Socketʵ�������ڼ���
				// ����һ�����߳�
				ServerThread serverThread = new ServerThread(socket);
				// �����߳�
				serverThread.start();
				count++;
				System.out.println("�ͻ��˵�������" + count);
				//����ͨ��InetAddress��ȡ�ͻ���IP
				InetAddress address=socket.getInetAddress();
				System.out.println("��ǰ�ͻ��˵�IP��"+address.getHostAddress());
			}
			// serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
