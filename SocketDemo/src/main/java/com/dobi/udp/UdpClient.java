
package com.dobi.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 
 * @classDesc: 功能描述:(udp客户端)
 *
 */
public class UdpClient {

	public static void main(String[] args) throws IOException {
		System.out.println("udp 发送数据");
		DatagramSocket ds = new DatagramSocket();
		String str = "客户端发送数据....";
		byte[] strByte = str.getBytes();
		//数据报文形式传输
		DatagramPacket dp = new DatagramPacket(strByte, strByte.length, InetAddress.getByName("192.168.1.3"), 8080);
		ds.send(dp);
		ds.close();
	}

}
