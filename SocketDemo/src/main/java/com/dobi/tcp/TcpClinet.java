
package com.dobi.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @classDesc: 功能描述:(scoekt客户端 )
 *
 */
public class TcpClinet {

	public static void main(String[] args) throws IOException {
		System.out.println("socket启动....");
		//连接到服务器ip和端口号
		Socket s = new Socket("192.168.1.3", 8080);
		//字节流形式传输
		OutputStream outputStream = s.getOutputStream();
		outputStream.write("我是客戶端....".getBytes());
		s.close();
	}

}
