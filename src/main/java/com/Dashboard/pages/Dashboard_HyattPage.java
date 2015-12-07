package com.Dashboard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Dashboard_HyattPage extends DashboardWebElementLocators {

	public void clickingInsightTab() {
		click(Dashboard_Insight_Tab_Locator);
	}
	
	public void setSearchCriteria(String locationName, String sourceName) {
		selectingLocations(locationName);
		selectingSources(sourceName);
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
		hoverClick(Dashboard_SaveToLaunchpad_Button_Locator);
	}
	
	public void verifySavedLaunchpad(String text){
		waitForElement(text, 2);
	}
	
	public void clickOnLatestSavedLaunchpad(){
		java.util.List<WebElement> elements = getDriver().findElements(By.xpath(Dashboard_AllSavedLaunchPad_Link_Text_Locator));
		getDriver().findElement(By.xpath(Dashboard_AllSavedLaunchPad_Link_Text_Locator+"["+elements.size()+"]")).click();
		System.out.println("Last locator: "+Dashboard_AllSavedLaunchPad_Link_Text_Locator+"["+elements.size()+"]");
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
	
	public void verifySuccessMessage(){
		waitForElement(Dashboard_Success_Message_Text_Locator,2);
	}
	
	public void deleteLatestSavedLaunchpadAndVerifyDeletion(){
		java.util.List<WebElement> elements = getDriver().findElements(By.xpath(Dashboard_AllSavedLaunchPad_Link_Text_Locator));
		int oldSize = elements.size();
		getDriver().findElement(By.xpath(Dashboard_AllSavedLaunchPad_Link_Text_Locator+"["+oldSize+"]/span")).click();
		click(Dashboard_Delete_Confirmation_Button_Locator);
		pause(5);
		
		//Verification
		elements = getDriver().findElements(By.xpath(Dashboard_AllSavedLaunchPad_Link_Text_Locator));
		int newSize = elements.size();
		Assert.assertEquals(oldSize-newSize, 1);
	}
	
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
}
