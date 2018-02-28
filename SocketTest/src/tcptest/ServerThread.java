package tcptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * ���������̴߳�����
 * 
 * @author jac
 * 
 */

public class ServerThread extends Thread {
	// �ͱ��߳���ص�Socket
	Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	/**
	 * �߳�ִ�еĲ�������Ӧ�ͻ��˵�����
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
			// 3�����ӽ�����ͨ����������ȡ�ͻ��˷��͵�������Ϣ��ͨ���ͻ��˵���������ȡ�ͻ��˵���Ϣ��
			is = socket.getInputStream();// ��ȡ�ֽ�������
			isr = new InputStreamReader(is);// ת���ֽ���Ϊ�ַ���
			br = new BufferedReader(isr);// Ϊ�ַ���������ӻ���
			while ((info = br.readLine()) != null) {// ѭ����ȡ�ͻ��˵���Ϣ
				System.out.println("���Ƿ��������ͻ���˵��" + info);// infoΪ�ӿͻ��˻�ȡ����Ϣ
			}
			socket.shutdownInput();// �ر�������
			// 4��ͨ���������ͻ��˷�����Ӧ����Ϣ
			os = socket.getOutputStream();
			pw = new PrintWriter(os);// ��ͻ��˷�����Ϣ����
			pw.write("��ӭ����");
			pw.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5���ر������Դ
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
