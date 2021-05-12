package com.akudrin.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // using default beanID tennisCoach
@Scope("prototype")
public class TennisCoach implements Coach, DisposableBean {

	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;

	public TennisCoach() {

		System.out.println("TennisCoach: inside default constructor");
	}

	/*
	 * @Autowired public TennisCoach(FortuneService fortuneService) { super();
	 * this.fortuneService = fortuneService; }
	 */

	/*
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * System.out.println("TennisCoach: inside setFortuneService() method");
	 * this.fortuneService = fortuneService; }
	 */

	@Override
	public String getDailyWorkout() {

		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	@PostConstruct
	void populateCache() {
		System.out.println("PostConstruct");

	}

	// For "prototype" scoped beans, Spring does not call the @PreDestroy method
	@PreDestroy
	void flushCache() {
		System.out.println("PreDestroy");

	}

	@Override
	public void destroy() throws Exception {
		System.out.println("PreDestroy with Scope prototype");

	}

}
