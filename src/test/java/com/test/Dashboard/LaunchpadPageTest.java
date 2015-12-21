package com.test.Dashboard;

import org.testng.annotations.Test;

import com.Dashboard.data.Dashboard_BaseData;
import com.Dashboard.global.DashboardPageFactory;
import com.Dashboard.pages.DashboardWebElementLocators;

public class LaunchpadPageTest extends DashboardPageFactory{

	@Test(description="Verification of Save to Launchpad functionality | Deleting latest saved search filter")
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
		LaunchpadPage().clickingLaunchpadTab();
		pause(5);
		
		/*
		 * Deleting the latest saved launchpad
		 */
		LaunchpadPage().deleteLatestSavedLaunchpadAndVerifyDeletion();
	}
	
	@Test(description="To verify that if a user can edit the name of saved launchpad")
	public void editSavedLaunchpadAndVerify(){
		
		/*
		 * Login to application
		 */
		DashboardLoginPage().Dashboardlogin(
		Dashboard_BaseData.Dashboard_Login_Username_Input,
		Dashboard_BaseData.Dashboard_Login_Password_Input);
		pause(2);
		
		/*
		 * Prerequisite:
		 * Create a launchpad in first
		 */
		String testLaunchpad = randomstring();
		InsightPage().clickingInsightTab();
		InsightPage().selectingLocations("Hyatt Miami at The Blue");
		InsightPage().selectingSources("Trip Advisor");
		InsightPage().clickApplyButton();
		pause(2);
		InsightPage().hoverOnSaveToLaunchpad();
		pause(2);
		InsightPage().clickSaveToLaunchpad();
		InsightPage().writeInAddToNewLaunchpad(testLaunchpad);
		InsightPage().clickOnAddNewButton();
		pause(6);
		
		/*
		 * Action: Edit the last saved launchpad
		 */
		LaunchpadPage().clickingLaunchpadTab();
		pause(10);
		LaunchpadPage().editSavedLaunchpadAndVerify();
		pause(5);
		
		/*
		 * Clean up
		 */
		
		LaunchpadPage().deleteLatestSavedLaunchpadAndVerifyDeletion();
	}
	@Test
	public void testing(){
		DashboardLoginPage().Dashboardlogin(
		Dashboard_BaseData.Dashboard_Login_Username_Input,
		Dashboard_BaseData.Dashboard_Login_Password_Input);
		pause(2);
		
		LaunchpadPage().clickingLaunchpadTab();
		pause(5);
		LaunchpadPage().editSavedLaunchpadAndVerify();
	}
}
