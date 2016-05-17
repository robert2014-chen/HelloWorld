package com.robert.blend.hibernate.cache;

import java.util.Date;
import java.util.Map;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import com.robert.blend.hibernate.domain.News;
import com.robert.blend.hibernate.domain.Season;
import com.robert.blend.hibernate.util.HibernateUtil;

public class EhcacheTest {

	 @Test
	 public void init() {
//	  Configuration cfg = new Configuration().configure();
//	  // 把对象类导成表
//	  SchemaExport export = new SchemaExport(cfg);
//	  // 生成ddl
//	  export.create(true, true);
//	
//	 Session session = HibernateUtil.getSessionFactory().openSession();
//	 Transaction transcation = session.beginTransaction();
//	 News news = new News();
//	 news.setName("title");
//	 news.setContent("content");
//	 news.setDate(new Date());
//	 news.setSeason(Season.秋季);
//	 news.setNothing("nothing");
//	 session.save(news);
//	 transcation.commit();
//	 session.close();
	 }

	@Test
	public void testLoad() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("FROM News");
		query.setFirstResult(0);
		query.setMaxResults(1);
		query.list();
		session.getTransaction().commit();

		System.out.println("-----------------------------");
		Session session2 = HibernateUtil.getSessionFactory().openSession();
		session2.beginTransaction();
		System.out.println(((News) session2.get(News.class, 2))
				.getFullContent());
		session2.getTransaction().commit();

		System.out.println("统计二级缓存");

		Map cacheEntries = HibernateUtil
				.getSessionFactory()
				.getStatistics()
				.getSecondLevelCacheStatistics(
						"com.robert.blend.hibernate.domain.News").getEntries();
		System.out.println(cacheEntries);
	}

}
