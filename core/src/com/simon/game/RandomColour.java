package com.simon.game;

import java.util.Random;

public class RandomColour {

	public int numColour;
	
	public int randomnum() {
		Random rand = new Random();
		numColour = rand.nextInt(4)+1;
		return numColour;
	}
}
