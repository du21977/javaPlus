package com.dobi.LinkedList;

import java.util.LinkedList;

public class Test002 {

	public static void main(String[] args) {
//		LinkedList linkedList = new LinkedList<String>();
//		linkedList.remove(1);
//		linkedList.add(index, element);

		ExtLinkedList<String> extLinkedList = new ExtLinkedList<String>();
		extLinkedList.add("a");
		extLinkedList.add("b");
		extLinkedList.add("c");
		extLinkedList.add("e");
		// System.out.println("删除之前:" + extLinkedList.get(2)); // C
		extLinkedList.add(3, "f");// fabce
		// System.out.println("删除之后:" + extLinkedList.get(2));// E
		// 其实从头查到尾### 效率不高，查询算法#####折半查找
		for (int i = 0; i < extLinkedList.getSize(); i++) {
			System.out.println(extLinkedList.get(i));
		}
		// System.out.println(extLinkedList.get(2));
	}

}
