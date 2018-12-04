package com.dobi.fallback;

import java.util.ArrayList;
import java.util.List;

import com.dobi.service.MemberFeign;
import org.springframework.stereotype.Component;


/**
 * 雪崩效应，服务降级，会调用本方法
 */
@Component
public class MemberFallBack implements MemberFeign {

	public List<String> getToOrderMemberAll() {
	    //服务降级处理
		List<String> list = new ArrayList<String>();
		list.add("服务发生异常...");
		return list;
	}

}
