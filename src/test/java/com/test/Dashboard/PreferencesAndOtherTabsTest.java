package com.test.Dashboard;

import org.testng.annotations.Test;

import com.Dashboard.data.Dashboard_BaseData;
import com.Dashboard.global.DashboardPageFactory;
import com.Dashboard.global.TestGroups;
import com.Dashboard.pages.DashboardWebElementLocators;

public class PreferencesAndOtherTabsTest extends DashboardPageFactory{

	@Test(groups = { TestGroups.RegressionGroup, TestGroups.ALLGroup }, description="To verify preferences functionality by changing the first name")
	public void verifyPreferencesByChangingUserData(){
		String name = "nba";
		String expectedMessage = "Info:User details changed successfully";
		DashboardLoginPage().Dashboardlogin(
		Dashboard_BaseData.Dashboard_Login_Username_Input,
		Dashboard_BaseData.Dashboard_Login_Password_Input);
		pause(3);
		InsightPage().clickingInsightTab();
		PreferencesAndOtherTabsPage().clickingOnPreferences();
		PreferencesAndOtherTabsPage().writeInFirstName(name);
		PreferencesAndOtherTabsPage().clickingOnPreferencesApply(DashboardWebElementLocators.Dashboard_Preferences_Apply_Button_Locator);
		PreferencesAndOtherTabsPage().verifyInfoMessageForUserData(expectedMessage);
		PreferencesAndOtherTabsPage().closePreferencesWindow();
		DashboardLoginPage().verifyUserName(name);
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
		InsightPage().clickingInsightTab();
		PreferencesAndOtherTabsPage().clickingOnPreferences();
		PreferencesAndOtherTabsPage().clickingOnChangePassword();
		PreferencesAndOtherTabsPage().writeInCurrentPassword(currentPassword);
		PreferencesAndOtherTabsPage().writeInNewPassword(currentPassword);
		PreferencesAndOtherTabsPage().writeInVerifyPassword(currentPassword);
		PreferencesAndOtherTabsPage().clickingOnPreferencesApply(DashboardWebElementLocators.Dashboard_Preferences_Password_Apply_Button_Locator);
		pause(3);
		PreferencesAndOtherTabsPage().verifyInfoMessageForPasswordChange(expectedMessage);
		pause(2);
	}
}
