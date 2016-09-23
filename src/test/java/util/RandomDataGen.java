package util;

import org.apache.commons.lang3.RandomStringUtils;


public class RandomDataGen {

	private  String raffleName;
	private String playerName;

	public  void  generateRandomData() {
		playerName = RandomStringUtils.randomAlphabetic(7);
		raffleName = RandomStringUtils.randomAlphabetic(4);
	}

	public String getPlayerName() {

		return playerName;
	}

	public String getRaffleName() {

		return raffleName;
	}



}
