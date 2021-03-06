package com.dobi.service;

import java.util.List;

import com.dobi.fallback.MemberFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 调用会员服务
 *
 * fallback=MemberFallBack.class 服务降级来解决雪崩效应
 */

@FeignClient(value = "service-member",fallback=MemberFallBack.class)
public interface MemberFeign {

	@RequestMapping("/getMemberAll")
	public List<String> getToOrderMemberAll();

}
