package immoc;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL���÷���
 * @author jac
 *
 */
public class Test02 {

	public static void main(String[] args) {
		// ����һ��URLʵ��
		try {
			URL imooc=new URL("https://www.imooc.com");
			URL url=new URL(imooc,"/index.html?username=tom#test");
			System.out.println("Э�飺"+url.getProtocol());
			System.out.println("������"+url.getHost());
			
			System.out.println("�˿ںţ�"+url.getPort());//���δָ���˿ںţ���ʹ��Ĭ�϶˿ںţ���ʱgetPort��������ֵΪ-1
			System.out.println("�ļ�·����"+url.getPath());
			System.out.println("�ļ�����"+url.getFile());
			System.out.println("���·����"+url.getRef());
			System.out.println("��ѯ�ַ�����"+url.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
