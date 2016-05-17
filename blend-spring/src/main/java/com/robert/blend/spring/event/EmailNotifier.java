package com.robert.blend.spring.event;

import org.springframework.context.ApplicationListener;

public class EmailNotifier implements ApplicationListener<EmailEvent> {

	@Override
	public void onApplicationEvent(EmailEvent event) {
		System.out.println("只监听EmailEvent事件！");
	}

}
