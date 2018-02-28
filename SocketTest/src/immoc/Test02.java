package immoc;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL常用方法
 * @author jac
 *
 */
public class Test02 {

	public static void main(String[] args) {
		// 创建一个URL实例
		try {
			URL imooc=new URL("https://www.imooc.com");
			URL url=new URL(imooc,"/index.html?username=tom#test");
			System.out.println("协议："+url.getProtocol());
			System.out.println("主机："+url.getHost());
			
			System.out.println("端口号："+url.getPort());//如果未指定端口号，则使用默认端口号，此时getPort方法返回值为-1
			System.out.println("文件路径："+url.getPath());
			System.out.println("文件名："+url.getFile());
			System.out.println("相对路径："+url.getRef());
			System.out.println("查询字符串："+url.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
