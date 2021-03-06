package com.akudrin.springdemo;

public class BaseballCoach implements Coach {

	// define a private field for the dependency
	private FortuneService fortuneService;

	// define constructor for the dependency injection
	public BaseballCoach(FortuneService theFortuneService) {

		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 mins on batting";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

}
