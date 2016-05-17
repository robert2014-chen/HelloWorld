package com.robert.blend.hibernate.utils;

import org.junit.Assert;
import org.junit.Test;

import com.robert.blend.hibernate.util.HibernateUtil;

public class HibernateUtilTest {

	@Test
	public void testGetSessionFactory() {
		Assert.assertNotNull(HibernateUtil.getSessionFactory());
	}
}
