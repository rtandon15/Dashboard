package com.test.Dashboard;

import org.testng.annotations.Test;

import com.Dashboard.data.Dashboard_BaseData;
import com.Dashboard.global.DashboardPageFactory;
import com.Dashboard.global.TestGroups;
import com.Dashboard.pages.DashboardWebElementLocators;
import com.Dashboard.pages.Dashboard_HyattPage;
import org.testng.Assert;

public class Dashboard_Login extends DashboardPageFactory {
	
	String testLaunchpad = randomstring();
	String name = "";
	String grade = "";
	String rating = "";
	String reviews = "";
	String insights = "";
	

	@Test(priority=1,groups = { TestGroups.RegressionGroup, TestGroups.ALLGroup }, description = "The test case verifies basic flow for dashboard ")
	public void verifyBasicFlowForDashboard() throws Exception {
		DashboardLoginPage().Dashboardlogin(
		Dashboard_BaseData.Dashboard_Login_Username_Input,
		Dashboard_BaseData.Dashboard_Login_Password_Input);
		pause(3);
		Dashboard_HyattPage().clickingInsightTab();
		Dashboard_HyattPage().selectingLocations("Hyatt Miami at The Blue");
		Dashboard_HyattPage().selectingSources("Trip Advisor");
		Dashboard_HyattPage().clickApplyButton();
		pause(5);
		Dashboard_HyattPage().clickingReviewValue();
		pause(3);
		DashboardLoginPage().verifyReviewMessage("rooms","nice","clean","no one said it was impossible","lady in the frontdesk");
		Dashboard_HyattPage().clickCloseReview();
		DashboardLoginPage().dashboardLogout();

	}
	
	@Test(priority=2,groups = { TestGroups.RegressionGroup, TestGroups.ALLGroup }, description = "Verification of save to launchpad functionality")
	public void verifyCRUDForSaveToLaunchPadFunctionality() throws Exception{
		String text = "TestLaunchPad";
		
		/*
		 * Login to application
		 */
		DashboardLoginPage().Dashboardlogin(
		Dashboard_BaseData.Dashboard_Login_Username_Input,
		Dashboard_BaseData.Dashboard_Login_Password_Input);
		pause(2);
		/*
		 * Applying filters on Insight tab
		 */
		Dashboard_HyattPage().clickingInsightTab();
		Dashboard_HyattPage().selectingLocations("Hyatt Miami at The Blue");
		Dashboard_HyattPage().selectingSources("Trip Advisor");
		Dashboard_HyattPage().clickApplyButton();
		pause(2);
		/*
		 * Reading value for verification
		 */
		String name = getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Name_Text_Locator);
		String grade = getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Grade_Text_Locator);
		String rating = getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Rating_Text_Locator);
		String reviews = getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Reviews_Text_Locator);
		String insights = getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Insights_Text_Locator);
		System.out.println("name: "+name+"\n grade: "+grade+"\n rating: "+rating+"\n reviews: "+reviews+"\n insight: "+insights);
		
		/*
		 * Saving this filter to launch pad
		 */
		log("Filter is set..going to click on save to launchpad");
		Dashboard_HyattPage().hoverOnSaveToLaunchpad();
		pause(2);
		Dashboard_HyattPage().clickSaveToLaunchpad();
		Dashboard_HyattPage().writeInAddToNewLaunchpad(text);
		Dashboard_HyattPage().clickOnAddNewButton();
		pause(6);
		Dashboard_HyattPage().verifySuccessMessage();
		pause(2);
		/*
		 * Opening the just saved filters from lauchpad tab
		 */
		Dashboard_HyattPage().clickingLaunchpadTab();
		pause(15);
		Dashboard_HyattPage().clickOnLatestSavedLaunchpad();
		pause(3);
		
		/*
		 * Verification if same result is displayed
		 */
		Assert.assertEquals(getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Name_Text_Locator), name);
		log("Name is verified");
		Assert.assertEquals(getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Grade_Text_Locator), grade);
		log("Grade is verified");
		Assert.assertEquals(getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Rating_Text_Locator), rating);
		log("Rating is verified");
		Assert.assertEquals(getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Reviews_Text_Locator), reviews);
		log("Reviews is verified");
		Assert.assertEquals(getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Insights_Text_Locator), insights);
		log("Insights is verified");
		
		pause(10);
	}
	
	@Test(enabled=false,description="Verification of Save to Launchpad functionality | Create a search filter on launchpad")
	public void verifySaveToLaunchpad(){
		
		/*
		 * Login to application
		 */
		DashboardLoginPage().Dashboardlogin(
		Dashboard_BaseData.Dashboard_Login_Username_Input,
		Dashboard_BaseData.Dashboard_Login_Password_Input);
		pause(2);
		/*
		 * Applying filters on Insight tab
		 */
		Dashboard_HyattPage().clickingInsightTab();
		Dashboard_HyattPage().selectingLocations("Hyatt Miami at The Blue");
		Dashboard_HyattPage().selectingSources("Trip Advisor");
		Dashboard_HyattPage().clickApplyButton();
		pause(2);
		/*
		 * Reading value for verification
		 */
		name = getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Name_Text_Locator);
		grade = getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Grade_Text_Locator);
		rating = getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Rating_Text_Locator);
		reviews = getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Reviews_Text_Locator);
		insights = getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Insights_Text_Locator);
		System.out.println("name: "+name+"\n grade: "+grade+"\n rating: "+rating+"\n reviews: "+reviews+"\n insight: "+insights);
		
		/*
		 * Saving this filter to launch pad
		 */
		log("Filter is set..going to click on save to launchpad");
		Dashboard_HyattPage().hoverOnSaveToLaunchpad();
		pause(2);
		Dashboard_HyattPage().clickSaveToLaunchpad();
		Dashboard_HyattPage().writeInAddToNewLaunchpad(testLaunchpad);
		Dashboard_HyattPage().clickOnAddNewButton();
		pause(6);
		
		/*
		 * Verifying successful message
		 */
		Dashboard_HyattPage().verifySuccessMessage();
		pause(2);
		
		/*
		 * Verifying the same search filter is saved on launchpad
		 */
		Dashboard_HyattPage().clickingLaunchpadTab();
		pause(10);
		Dashboard_HyattPage().verifySavedLaunchpad(testLaunchpad);
		pause(5);
	}
	
	@Test(enabled=false,dependsOnMethods="verifySaveToLaunchpad",description="Verification of Save to Launchpad functionality | Reading latest saved search filter")
	public void verifySavedLaunchpadShowingSameResult(){
		/*
		 * Login to application
		 */
		DashboardLoginPage().Dashboardlogin(
		Dashboard_BaseData.Dashboard_Login_Username_Input,
		Dashboard_BaseData.Dashboard_Login_Password_Input);
		pause(2);
		
		/*
		 * Make sure to be on Launchpad tab
		 */
		Dashboard_HyattPage().clickingLaunchpadTab();
		pause(5);
		/*
		 * Opening the just saved filters from lauchpad tab
		 */
		
		Dashboard_HyattPage().clickOnLatestSavedLaunchpad();
		pause(3);
		
		/*
		 * Verification if same result is displayed
		 */
		Assert.assertEquals(getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Name_Text_Locator), name);
		log("Name is verified");
		Assert.assertEquals(getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Grade_Text_Locator), grade);
		log("Grade is verified");
		Assert.assertEquals(getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Rating_Text_Locator), rating);
		log("Rating is verified");
		Assert.assertEquals(getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Reviews_Text_Locator), reviews);
		log("Reviews is verified");
		Assert.assertEquals(getText(DashboardWebElementLocators.Dashboard_LocationPerformanceAnalysis_Insights_Text_Locator), insights);
		log("Insights is verified");
		
		pause(10);
	}
	
	@Test(enabled=false,description="Verification of Save to Launchpad functionality | Deleting latest saved search filter")
	public void verifyDeleteLatestSavedLaunchpad(){
		/*
		 * Login to application
		 */
		DashboardLoginPage().Dashboardlogin(
		Dashboard_BaseData.Dashboard_Login_Username_Input,
		Dashboard_BaseData.Dashboard_Login_Password_Input);
		pause(2);
		
		/*
		 * Make sure to be on Launchpad tab
		 */
		Dashboard_HyattPage().clickingLaunchpadTab();
		pause(5);
		
		/*
		 * Deleting the latest saved launchpad
		 */
		Dashboard_HyattPage().deleteLatestSavedLaunchpadAndVerifyDeletion();
	}
	
	@Test(enabled=false,groups = { TestGroups.RegressionGroup, TestGroups.ALLGroup }, description="To verify preferences functionality by changing the first name")
	public void verifyPreferencesByChangingUserData(){
		String name = "nba";
		String expectedMessage = "Info:User details changed successfully";
		DashboardLoginPage().Dashboardlogin(
		Dashboard_BaseData.Dashboard_Login_Username_Input,
		Dashboard_BaseData.Dashboard_Login_Password_Input);
		pause(3);
		Dashboard_HyattPage().clickingInsightTab();
		Dashboard_HyattPage().clickingOnPreferences();
		Dashboard_HyattPage().writeInFirstName(name);
		Dashboard_HyattPage().clickingOnPreferencesApply(DashboardWebElementLocators.Dashboard_Preferences_Apply_Button_Locator);
		Dashboard_HyattPage().verifyInfoMessageForUserData(expectedMessage);
		Dashboard_HyattPage().closePreferencesWindow();
		Dashboard_HyattPage().verifyUserName(name);
		pause(3);
		
	}
	
	@Test(enabled=false,groups = { TestGroups.RegressionGroup, TestGroups.ALLGroup }, description="To verify preferences functionality by changing the password")
	public void verifyPreferencesByChangingPassword(){
		String currentPassword = "spr1nkle!15";
		String expectedMessage = "Info:Password changed successfully";
		DashboardLoginPage().Dashboardlogin(
		Dashboard_BaseData.Dashboard_Login_Username_Input,
		Dashboard_BaseData.Dashboard_Login_Password_Input);
		pause(3);
		Dashboard_HyattPage().clickingInsightTab();
		Dashboard_HyattPage().clickingOnPreferences();
		Dashboard_HyattPage().clickingOnChangePassword();
		Dashboard_HyattPage().writeInCurrentPassword(currentPassword);
		Dashboard_HyattPage().writeInNewPassword(currentPassword);
		Dashboard_HyattPage().writeInVerifyPassword(currentPassword);
		Dashboard_HyattPage().clickingOnPreferencesApply(DashboardWebElementLocators.Dashboard_Preferences_Password_Apply_Button_Locator);
		pause(3);
		Dashboard_HyattPage().verifyInfoMessageForPasswordChange(expectedMessage);
		pause(2);
	}
	
	@Test(enabled=false,description="To verify change of user")
	public void verifyChangeOfUser(){
		/*
		 * Login to application
		 */
		DashboardLoginPage().Dashboardlogin(
		Dashboard_BaseData.Dashboard_Login_Username_Input,
		Dashboard_BaseData.Dashboard_Login_Password_Input);
		pause(3);
		
		/*
		 * Open Admin tab
		 */
		Dashboard_HyattPage().openingAdminTabUnderUserName();
		
		/*
		 * Change user and verify
		 */
		
		Dashboard_HyattPage().changeUserAndVerify();
		pause(5);
	}
}
