package com.test.Dashboard;

import org.testng.annotations.Test;

import com.Dashboard.data.Dashboard_BaseData;
import com.Dashboard.global.DashboardPageFactory;
import com.Dashboard.global.TestGroups;
import com.Dashboard.pages.DashboardWebElementLocators;

public class Dashboard_Login extends DashboardPageFactory {

	@Test(groups = { TestGroups.RegressionGroup, TestGroups.ALLGroup }, description = "The test case verifies basic flow for dashboard ")
	public void verifyBasicFlowForDashboard() throws Exception {
		DashboardLoginPage().Dashboardlogin(
				Dashboard_BaseData.Dashboard_Login_Username_Input,
				Dashboard_BaseData.Dashboard_Login_Password_Input);
		pause(3);
		Dashboard_HyattPage().clickingInsightTab();
		Dashboard_HyattPage().selectingLocations("Hyatt Miami at The Blue");
		Dashboard_HyattPage().selectingSources("Trip Advisor");
		Dashboard_HyattPage().clickApplyButton();
		Dashboard_HyattPage().clickingReviewValue();
		pause(3);
		DashboardLoginPage().verifyReviewMessage("rooms","nice","clean","no one said it was impossible","lady in the frontdesk");
		Dashboard_HyattPage().clickCloseReview();
		DashboardLoginPage().dashboardLogout();

	}
	
	@Test(groups = { TestGroups.RegressionGroup, TestGroups.ALLGroup }, description = "Verification of save to launchpad functionality")
	public void saveToLaunchPad() throws Exception{
		String text = "TestLaunchPad";
		DashboardLoginPage().Dashboardlogin(
		Dashboard_BaseData.Dashboard_Login_Username_Input,
		Dashboard_BaseData.Dashboard_Login_Password_Input);
		pause(2);
		Dashboard_HyattPage().clickingInsightTab();
		Dashboard_HyattPage().selectingLocations("Hyatt Miami at The Blue");
		Dashboard_HyattPage().selectingSources("Trip Advisor");
		Dashboard_HyattPage().clickApplyButton();
		System.out.println("Filter is set..going to click on save to launchpad");
		pause(2);
		Dashboard_HyattPage().hoverOnSaveToLaunchpad();
		System.out.println("Hover is done..going to click on it..wait....");
		pause(2);
		//Dashboard_HyattPage().clickSaveToLaunchpad();
		Dashboard_HyattPage().writeInAddToNewLaunchpad(text);
		Dashboard_HyattPage().clickOnAddNewButton();
		Dashboard_HyattPage().clickingLaunchpadTab();
		pause(6);
		Dashboard_HyattPage().verifySavedLaunchpad(text);
		pause(3);
	}
	
	@Test(groups = { TestGroups.RegressionGroup, TestGroups.ALLGroup }, description="To verify preferences functionality by changing the first name")
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
	
	@Test(groups = { TestGroups.RegressionGroup, TestGroups.ALLGroup }, description="To verify preferences functionality by changing the password")
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
}
