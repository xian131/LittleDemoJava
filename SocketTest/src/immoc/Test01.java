package immoc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InetAddress��
 * @author jac
 *
 */
public class Test01 {

	public static void main(String[] args) throws UnknownHostException {
		// ��ȡ������InetAddressʵ��
		InetAddress address=InetAddress.getLocalHost();
		
		System.out.println("���������"+address.getHostName());//��ȡ������
		System.out.println("������IP��ַ��"+address.getHostAddress());//��ȡ������IP��ַ
		
		byte[] bytes=address.getAddress();//��ȡ������ʽ��IP��ַ
		System.out.println("�ֽ�������ʽ��IP��"+Arrays.toString(bytes));
		
		System.out.println(address);//ֱ�����InetAddress����
		
		//������������ȡInetAddresʵ��
		InetAddress address2=InetAddress.getByName("ASUS");
		System.out.println("���������� ���������"+address2.getHostName());//��ȡ������
		System.out.println("���������� ������IP��ַ��"+address2.getHostAddress());//��ȡ������IP��ַ
		//��������IP��ȡInetAddresʵ��
		InetAddress address3=InetAddress.getByName("192.168.153.1");
		System.out.println("��������IP ���������"+address3.getHostName());//��ȡ������
		System.out.println("��������IP ������IP��ַ��"+address3.getHostAddress());//��ȡ������IP��ַ

	}

}
