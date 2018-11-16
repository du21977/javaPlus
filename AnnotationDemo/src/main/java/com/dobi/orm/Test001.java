
package com.dobi.orm;

import java.util.ArrayList;
import java.util.Date;

public class Test001 {

	public static void main(String[] args) {

	}

	@OneAnnotation(beanId = 123, className = "className", arrays = { "111", "222" })
	public void add() {

	}

	@SuppressWarnings({ "all" })
	public void save() {
		java.util.List list = new ArrayList();
	}

}
