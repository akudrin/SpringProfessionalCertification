package com.akudrin.springdemo;

public class TrackCoach implements Coach {

	// define a private field for the dependency
	private FortuneService fortuneService;

	// define constructor for the dependency injection
	public TrackCoach(FortuneService theFortuneService) {

		fortuneService = theFortuneService;
	}

	public TrackCoach() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDailyFortune() {

		return "Just Do It: " + fortuneService.getFortune();
	}

	@Override
	public String getDailyWorkout() {
		return "Run 5k";
	}

}
