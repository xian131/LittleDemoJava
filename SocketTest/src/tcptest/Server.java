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
 * ����TCPЭ���Socketͨ�ţ�ʵ���û���¼
 * ��������
 * ʵ���ڷ������˻�ȡ�ͻ��˷��͵���Ϣ������Ӧ�ͻ���
 * ���ݣ���������ͻ��˷�������
 * �ͻ��˻�ȡ����� Я������"�û�����admin;���룺123"��
 * ��������ȡ������ �õ��ͻ��˷��͵����ݣ�
 * ��������ȡ�����  Я������"��ӭ����"��
 * �ͻ��˻�ȡ������ �õ����������͵����ݣ�
 * @author jac
 *
 */
public class Server {
	public static void main(String[] args) {

		try {
			//		1������ServerSocket���󶨼����˿�
			ServerSocket serverSocket=new ServerSocket(8888);//����ʹ��1024����Ķ˿�
			//		2��ͨ��accept���������ͻ������󣬵ȴ��ͻ��˵�����
			System.out.println("�������������������������ȴ��ͻ��˵����ӡ���");
			Socket socket=serverSocket.accept();//��ȡ�ͻ��˷��͵�Socketʵ�������ڼ���
			//		3�����ӽ�����ͨ����������ȡ�ͻ��˷��͵�������Ϣ��ͨ���ͻ��˵���������ȡ�ͻ��˵���Ϣ��
			InputStream is=socket.getInputStream();//��ȡ�ֽ�������
			InputStreamReader isr=new InputStreamReader(is);//ת���ֽ���Ϊ�ַ���
			BufferedReader br=new BufferedReader(isr);//Ϊ�ַ���������ӻ���
			String info=null;
			while ((info=br.readLine())!=null) {//ѭ����ȡ�ͻ��˵���Ϣ
				System.out.println("���Ƿ��������ͻ���˵��"+info);//infoΪ�ӿͻ��˻�ȡ����Ϣ
			}
			socket.shutdownInput();//�ر�������
			//			4��ͨ���������ͻ��˷�����Ӧ����Ϣ
			OutputStream os=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(os);//��ͻ��˷�����Ϣ����
			pw.write("��ӭ����");
			pw.flush();
			//		5���ر������Դ
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
