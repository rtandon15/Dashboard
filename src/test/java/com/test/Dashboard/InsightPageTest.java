package com.test.Dashboard;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Dashboard.data.Dashboard_BaseData;
import com.Dashboard.global.DashboardPageFactory;
import com.Dashboard.global.TestGroups;
import com.Dashboard.pages.DashboardWebElementLocators;

public class InsightPageTest extends DashboardPageFactory{

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
		InsightPage().clickingInsightTab();
		InsightPage().selectingLocations("Hyatt Miami at The Blue");
		InsightPage().selectingSources("Trip Advisor");
		InsightPage().clickApplyButton();
		pause(5);
		InsightPage().clickingReviewValue();
		pause(3);
		DashboardLoginPage().verifyReviewMessage("rooms","nice","clean","no one said it was impossible","lady in the frontdesk");
		InsightPage().clickCloseReview();
		DashboardLoginPage().dashboardLogout();

	}
	
	@Test(description="Verification of Save to Launchpad functionality | Create a search filter on launchpad")
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
		InsightPage().clickingInsightTab();
		InsightPage().selectingLocations("Hyatt Miami at The Blue");
		InsightPage().selectingSources("Trip Advisor");
		InsightPage().clickApplyButton();
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
		InsightPage().hoverOnSaveToLaunchpad();
		pause(2);
		InsightPage().clickSaveToLaunchpad();
		InsightPage().writeInAddToNewLaunchpad(testLaunchpad);
		InsightPage().clickOnAddNewButton();
		pause(6);
		
		/*
		 * Verifying successful message
		 */
		InsightPage().verifySuccessMessage();
		pause(2);
		
		/*
		 * Verifying the same search filter is saved on launchpad
		 */
		LaunchpadPage().clickingLaunchpadTab();
		pause(10);
		LaunchpadPage().verifySavedLaunchpad(testLaunchpad);
		pause(5);
	}
	
	@Test(dependsOnMethods="verifySaveToLaunchpad",description="Verification of Save to Launchpad functionality | Reading latest saved search filter")
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
		LaunchpadPage().clickingLaunchpadTab();
		pause(5);
		/*
		 * Opening the just saved filters from lauchpad tab
		 */
		
		LaunchpadPage().clickOnLatestSavedLaunchpad();
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
}
