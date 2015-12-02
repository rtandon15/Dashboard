package com.Dashboard.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

public class Dashboard_HyattPage extends DashboardWebElementLocators {

	public void clickingInsightTab() {
		click(Dashboard_Insight_Tab_Locator);
	}

	public void selectingLocations(String LocationName) {
		typeAndEnter(Dashboard_Locations_Dropdown_Locator, LocationName);
	}

	public void selectingSources(String SourceName) {
		typeAndEnter(Dashboard_Sources_Dropdown_Locator, SourceName);
	}

	public void clickApplyButton() {
		clickAndWait(Dashboard_Apply_Button_Locator);
	}

	public void clickingReviewValue() {
		clickAndWait(Dashboard_ReviewValue_Number_Locator);
	}

	public void clickCloseReview() {
		click(Dashboard_Close_Review_Button_Locator);
	}
	
	public void clickSaveToLaunchpad(){
		click(Dashboard_SaveToLaunchpad_Button_Locator);
	}
	
	public void clickingLaunchpadTab() {
		click(Dashboard_Launchpad_Tab_Locator);
	}
	
	public void writeInAddToNewLaunchpad(String text){
		type(Dashboard_AddToNewLaunchpad_Textbox_Locator, text);
	}
	
	public void clickOnAddNewButton(){
		click(Dashboard_AddNew_Button_Locator);
	}

	public void hoverOnSaveToLaunchpad(){
//		hoverClick(Dashboard_SaveToLaunchpad_Button_Locator);
		JavascriptExecutor js = (JavascriptExecutor)getDriver();
		js.executeScript("arguments[0].click();", Dashboard_SaveToLaunchpad_Button_Locator);
	}
	
	public void verifySavedLaunchpad(String text){
		waitForElement("//a[text()='"+text+"']",2);
	}
	
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
	
	public void verifyUserName(String expected){
		String actual = getText(Dashboard_UserName_Textbox_Locator);
		Assert.assertEquals(actual, expected);
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
