/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.dobi.demo;


import com.dobi.des.DES;

/**
 * 功能说明: <br>
 *
 */
public class Demo01 {
	// 1.配置密钥
	private static String PASSWORD = "95880288";

	public static void main(String[] args) throws Exception {
		// 2.需要加密的内容
		String content = "yushengjun";
		// 3.使用DES 加密
		byte[] encryptContent = DES.encrypt(content.getBytes(), PASSWORD);
		System.out.println("加密后内容:" + new String(encryptContent));
		// 4.使用DES 解密
		byte[] decrypt = DES.decrypt(encryptContent, PASSWORD);
		System.out.println("解密后内容:" + new String(decrypt));
	}

}
