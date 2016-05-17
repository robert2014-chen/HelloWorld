package com.robert.mybatis.mapper;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.robert.mybatis.util.MyBatisUtil;

public class PersonMapperTest {

	@Test
	public void testGetPersonSN() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		/**
		 * 映射sql的标识字符串，
		 * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
		 * getUserCount是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "com.robert.mybatis.mapper.personMapper.getPersonSN";// 映射sql的标识字符串
		Map<String, Integer> parameterMap = new HashMap<String, Integer>();
		parameterMap.put("personSN", -1);
		sqlSession.selectOne(statement, parameterMap);
		Integer result = parameterMap.get("personSN");
		System.out.println(result);
		sqlSession.close();
	}
}
