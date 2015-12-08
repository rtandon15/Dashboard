package com.Dashboard.pages;

import org.testng.Assert;

public class PreferencesAndOtherTabsPage extends DashboardWebElementLocators{

	/*
	 * Methods for Preferences tab
	 */
	
	public void clickingOnPreferences(){
		click(Dashboard_Preferences_Button_Locator);
	}
	
	public void writeInFirstName(String name){
		type(Dashboard_Preferences_FirstName_Textbox_Locator, name);
	}
	
	public void clickingOnPreferencesApply(String whichApply){
		/*
		 * Apply on preferences is different for user data, password change etc.
		 */
		click(whichApply);
	}
	
	public void verifyInfoMessageForUserData(String expected){
		String actual = getText(Dashboard_Preferences_User_Message_Info_Locator);
		Assert.assertEquals(actual, expected);
	}
	
	public void closePreferencesWindow(){
		click(Dashboard_Preferences_Close_Button_Locator);
	}
	
	public void clickingOnChangePassword(){
		click(Dashboard_Preferences_ChangePassword_Link_Locator);
	}
	
	public void writeInCurrentPassword(String currentPassword){
		type(Dashboard_CurrentPassword_Textbox_Locator, currentPassword);
	}
	
	public void writeInNewPassword(String newPassword){
		type(Dashboard_NewPassword_Textbox_Locator, newPassword);
	}
	
	public void writeInVerifyPassword(String verifyPassword){
		type(Dashboard_VerifyPassword_Textbox_Locator, verifyPassword);
	}
	
	public void verifyInfoMessageForPasswordChange(String expected){
		String actual = getText(Dashboard_Preferences_Password_Message_Info_Locator);
		Assert.assertEquals(actual, expected);
	}
}
