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

	public static String Dashboard_AlertName_Input = "Alert_"
			+ new DateTime(DateTimeZone.UTC).toString().replace(":", ".");
	public static String Dashboard_AddNewLaunchpad_Input = "LaunchPad_"
			+ new DateTime(DateTimeZone.UTC).toString().replace(":", ".");

	// INPUTS FOR TOAST MESSAGES
	public static final String Dashboard_AlertCreatedToastMessage_Input = "Success";

}
