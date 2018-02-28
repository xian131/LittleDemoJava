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
 * �ͻ���
 * ʵ���ڷ������˻�ȡ�ͻ��˷��͵���Ϣ������Ӧ�ͻ���
 * @author jac
 *
 */
public class Client {
	public static void main(String[] args) {
		
		try {
			//	1������Socket��ָ����Ҫ���ӵķ������ĵ�ַ�Ͷ˿ں�
			Socket socket=new Socket("localhost",8888);
			//	2�����ӽ�����ͨ������������������������Ϣ
			OutputStream os=socket.getOutputStream();//�ֽ������
			PrintWriter pw=new PrintWriter(os);//���������װΪ��ӡ��
			pw.write("�û�����admin;���룺123");
			pw.flush();//ˢ�»��棬��������˷�����Ϣ
			socket.shutdownOutput();//�ر������
			//			3��ͨ����������ȡ��������Ӧ����Ϣ��������
			InputStream is=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader br=new BufferedReader(isr);
			String info=null;
			while ((info=br.readLine())!=null) {
				System.out.println("���ǿͻ��ˣ�������˵��"+info);//infoΪ�ӷ�������ȡ����Ϣ
			}
			//	4���ر������Դ
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
