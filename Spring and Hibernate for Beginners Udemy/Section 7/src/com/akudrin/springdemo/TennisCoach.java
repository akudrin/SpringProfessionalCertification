package com.akudrin.springdemo;

import org.springframework.stereotype.Component;

@Component // using default beanID tennisCoach
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {

		return "Practice your backhand volley";
	}

}
