package com.akudrin.springdemo;

public class CricketCoach implements Coach {

	private String emailAddress;
	private String team;

	// define a private field for the dependency
	private FortuneService fortuneService;

	// define constructor for the dependency injection
	public CricketCoach(FortuneService theFortuneService) {

		fortuneService = theFortuneService;
	}

	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside setter method setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) {
		System.out.println("CricketCoach: inside setter method setTeam");
		this.team = team;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {

		return "Practice fast bowling for 15mins";
	}

	@Override
	public String getDailyFortune() {

		return fortuneService.getFortune();
	}

	// add init method for bean lifecycle
	public void doMyStartupStuff() {
		System.out.println("Cricketcoach: inside method doMyStartupStauff");
	}

	// add destroy method for bean lifecycle
	public void doMyCleanupStuff() {
		System.out.println("Cricketcoach: inside method doMyCleanupStauff");
	}

}
