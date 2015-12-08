package com.Dashboard.pages;

import org.testng.Assert;

import com.saf.global.TestStepType;

public class DashboardLoginPage extends DashboardWebElementLocators {

	// FOR LOGIN
	public void Dashboardlogin(String UserName, String Password) {
		log("Entering the UserName. ", TestStepType.INNER_SUBSTEP);
		type(Dashboard_Login_UserName_Textbox_Locator, UserName);
		log("Entering the Password. ", TestStepType.INNER_SUBSTEP);
		type(Dashboard_Login_Password_Textbox_Locator, Password);
		log("Clicking on LOGIN button.", TestStepType.INNER_SUBSTEP);
		click(Dashboard_Login_Button_Locator);
	}

	public void dashboardLogout() {
		log("Clicking on LOGOUT Link. ", TestStepType.INNER_SUBSTEP);
		clickAndWait(Dashboard_nba_Logout_Button_Locator);
		clickAndWait(Dashboard_nba_Logout_Link_Locator);

	}

	public void verifyReviewMessage(Object... params) {
		for (Object Message : params) {
			log("Verifying message :" + Message);
			waitForElement(Dashboard_Reviews_Message_Locator.format(Message.toString()));
		}
	}
	
	/*
	 * Methods for Admin module
	 */
	public void openingAdminTabUnderUserName(){
		click(Dashboard_MainPage_User_DrpDown_Locator);
		click(Dashboard_MainPage_Admin_Link_Locator);
	}
	
	public void changeUserAndVerify(){
		String currentName = getText(Dashboard_MainPage_UserNameOnTopRightCorner_Locator);
		System.out.println("currentName: "+currentName);
		click(Dashboard_UnderAdmin_User_DrpDwn_Locator);
		click(Dashboard_UnderAdmin_User_SecondValue_Locator );
		pause(3);
		String newName = getText(Dashboard_MainPage_UserNameOnTopRightCorner_Locator);
		System.out.println("newName: "+newName);
		Assert.assertNotEquals(newName, currentName);
	}
	
	//TO VERIFY THE USERNAME ON RIGHT TOP CORNER
	public void verifyUserName(String expected){
		String actual = getText(Dashboard_UserName_Textbox_Locator);
		Assert.assertEquals(actual, expected);
	}
	
}
