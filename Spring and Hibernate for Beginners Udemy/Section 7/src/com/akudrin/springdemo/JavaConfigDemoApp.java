package com.akudrin.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());

		// get the bean from spring container
		Coach footballCoach = context.getBean("footballCoach", Coach.class);

		// call a method on the bean
		System.out.println(footballCoach.getDailyWorkout());

		// call a method on the bean
		System.out.println(footballCoach.getDailyFortune());

		// close the context
		context.close();
	}

}
