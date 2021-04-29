package com.akudrin.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	String[] array = { "Today you win lottery", "Tomorrow you will find money", "Good fortune!" };

	@Override
	public String getFortune() {
		Random r = new Random();
		int randomNumber = r.nextInt(array.length);

		return array[randomNumber];
	}

}
