
package com.dobi.demo2;

public class Demo004 {

	public static void main(String[] args) {
		///-Xms20m -Xmx20m -Xmn1m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
		//-Xms20m -Xmx20m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC -XX:NewRatio=2

		byte[] bytes = null;
		for (int i = 0; i < 10; i++) {
			System.out.println("i:" + i);
			bytes = new byte[1 * 1024 * 1024];
		}
	}

}
