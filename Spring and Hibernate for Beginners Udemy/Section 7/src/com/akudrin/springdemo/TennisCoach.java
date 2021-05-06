package com.akudrin.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // using default beanID tennisCoach
public class TennisCoach implements Coach {

	@Autowired
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

}
