package com.dobi.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 
 * @classDesc: 功能描述:(socket服务器端)
 *
 */
class UdpServer {

	public static void main(String[] args) throws IOException {
		System.out.println("udp接受数据启动.......");
		DatagramSocket ds = new DatagramSocket(8080);
		byte[] buf = new byte[1024];
		//数据报文形式发送
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		// 等待客户端发送数据，如果不发送，就一直等待，形成阻塞效果
		ds.receive(dp);
		System.out.println("来源:"+dp.getAddress().getHostAddress()+",port:"+dp.getPort());
		String str = new String(dp.getData(),0,dp.getLength());
		System.out.println("客户端发送数据:"+str);
		ds.close();
		
	}

}