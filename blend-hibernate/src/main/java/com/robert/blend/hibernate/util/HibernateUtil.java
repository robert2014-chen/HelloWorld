package com.robert.blend.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			System.out.println("新建一个SessionFactory");
			// 读取配置文件
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
			sb.applySettings(conf.getProperties());
			// 新建SessionFactory
			sessionFactory = conf.buildSessionFactory(sb.build());
		}
		return sessionFactory;
	}
}
