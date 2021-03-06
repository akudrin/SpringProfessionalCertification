package com.akudrin.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"beanLifecycle-applicationContext.xml");
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCricketCoach", Coach.class);
		System.out.println(theCoach.getDailyFortune());
		context.close();
	}

}
