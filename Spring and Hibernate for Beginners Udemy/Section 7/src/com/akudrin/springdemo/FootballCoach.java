package com.akudrin.springdemo;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach {

	private FortuneService fortuneService;

	public FootballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Kicks 100 times";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
