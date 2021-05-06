package com.akudrin.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomService implements FortuneService {

	// create an array of strings
	private String[] data = { "Fortune 1", "Fortune 2", "Fortune 3" };

	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.length);
		String theFortune = data[index];

		return theFortune;

	}

}
