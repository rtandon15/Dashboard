package com.Dashboard.data;

import java.util.Random;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class Dashboard_BaseData {
	public static final Random rand = new Random();
	public static final int randNumb = rand.nextInt();
	public static final String randNumber = Integer.toString(randNumb);

	// INPUTS FOR LOGIN TO DASHBOARD
	public static final String Dashboard_Login_Username_Input = "nba";
	public static final String Dashboard_Login_Password_Input = "spr1nkle!15";
	
	
}
