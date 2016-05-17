package com.robert.blend.spring.message;

import java.util.Date;
import java.util.Locale;
import java.util.Locale.Category;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.robert.blend.spring.event.EmailEvent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class MessageTest implements ApplicationContextAware {

	@Test
	public void test() {
		// ApplicationContext ctx = new ClassPathXmlApplicationContext(
		// "applicationContext.xml");
		String hello = ctx.getMessage("hello", new String[] { "孙悟空" },
				Locale.getDefault(Category.FORMAT));
		String now = ctx.getMessage("now", new Object[] { new Date() },
				Locale.getDefault(Category.FORMAT));
		System.out.println(hello);
		System.out.println(now);
	}

	@Test
	public void testApplicationEvent() {
		ctx.publishEvent(ctx.getBean(EmailEvent.class));
	}

	private ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.ctx = ctx;
	}
}