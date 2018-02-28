package immoc;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InetAddress类
 * @author jac
 *
 */
public class Test01 {

	public static void main(String[] args) throws UnknownHostException {
		// 获取本机的InetAddress实例
		InetAddress address=InetAddress.getLocalHost();
		
		System.out.println("计算机名："+address.getHostName());//获取主机名
		System.out.println("主机的IP地址："+address.getHostAddress());//获取主机的IP地址
		
		byte[] bytes=address.getAddress();//获取数组形式的IP地址
		System.out.println("字节数组形式的IP："+Arrays.toString(bytes));
		
		System.out.println(address);//直接输出InetAddress对象
		
		//根据主机名获取InetAddres实例
		InetAddress address2=InetAddress.getByName("ASUS");
		System.out.println("根据主机名 计算机名："+address2.getHostName());//获取主机名
		System.out.println("根据主机名 主机的IP地址："+address2.getHostAddress());//获取主机的IP地址
		//根据主机IP获取InetAddres实例
		InetAddress address3=InetAddress.getByName("192.168.153.1");
		System.out.println("根据主机IP 计算机名："+address3.getHostName());//获取主机名
		System.out.println("根据主机IP 主机的IP地址："+address3.getHostAddress());//获取主机的IP地址

	}

}
