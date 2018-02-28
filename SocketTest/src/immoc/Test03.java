package immoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 使用URL获取网页内容
 * @author jac
 *
 */
public class Test03 {

	public static void main(String[] args) {
		
		try {
			// 创建一个URL实例
			URL url=new URL("http://www.baidu.com");
			//通过URl的openStream获取URl所表示的资源的字节输入流
			InputStream is=url.openStream();
			//将字节输入流转换为字符输入流
			InputStreamReader isr=new InputStreamReader(is,"utf-8");//转换流的使用改为utf-8编码
			//为字符输入流添加缓冲，提高读取效率
			BufferedReader br=new BufferedReader(isr);
			//读取输入流
			String data=br.readLine();
			while (data!=null) {
				System.out.println(data);
				data=br.readLine();//循环读取数据
			}
			//关闭所有流
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
