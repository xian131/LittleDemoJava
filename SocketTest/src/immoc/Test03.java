package immoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ʹ��URL��ȡ��ҳ����
 * @author jac
 *
 */
public class Test03 {

	public static void main(String[] args) {
		
		try {
			// ����һ��URLʵ��
			URL url=new URL("http://www.baidu.com");
			//ͨ��URl��openStream��ȡURl����ʾ����Դ���ֽ�������
			InputStream is=url.openStream();
			//���ֽ�������ת��Ϊ�ַ�������
			InputStreamReader isr=new InputStreamReader(is,"utf-8");//ת������ʹ�ø�Ϊutf-8����
			//Ϊ�ַ���������ӻ��壬��߶�ȡЧ��
			BufferedReader br=new BufferedReader(isr);
			//��ȡ������
			String data=br.readLine();
			while (data!=null) {
				System.out.println(data);
				data=br.readLine();//ѭ����ȡ����
			}
			//�ر�������
			br.close();
			isr.close();
			is.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
