
package com.dobi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 分表----取模算法
 */
@Service
public class UserService {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String regit(String name, String pwd) {
		// 1.生成userid
		String insertUUidSql = "insert into uuid values (null)";
		jdbcTemplate.update(insertUUidSql);
		Long userId = jdbcTemplate.queryForObject("select last_insert_id()", Long.class);
		// 2.存放具体那张表中
		String tableName = "user" + userId % 3;
		// 3.插入到具体表中
		String inserUserSQL = "insert into " + tableName + " values(" + userId + "," + name + ",'" + pwd + "')";
		System.out.println("sql:" + inserUserSQL);
		jdbcTemplate.update(inserUserSQL);
		return "success";
	}

	public String get(Long userId) {
		// 1.存放具体那张表中
		String tableName = "user" + userId % 3;
		String selectUserSQL = "select name from " + tableName + " where id =" + userId;
		System.out.println("sql:" + selectUserSQL);
		String name=jdbcTemplate.queryForObject(selectUserSQL, String.class);
		return name;
	}

}
