package com.test.Dashboard;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Dashboard.data.Dashboard_BaseData;
import com.Dashboard.global.DashboardPageFactory;
import com.Dashboard.global.TestGroups;
import com.Dashboard.pages.DashboardWebElementLocators;

public class FunctionalFlowsTest extends DashboardPageFactory {

	@Test(groups = { TestGroups.RegressionGroup, TestGroups.ALLGroup }, description = "Verification of save to launchpad functionality")
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
		InsightPage().clickingInsightTab();
		InsightPage().selectingLocations("Hyatt Miami at The Blue");
		InsightPage().selectingSources("Trip Advisor");
		InsightPage().clickApplyButton();
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
		InsightPage().hoverOnSaveToLaunchpad();
		pause(2);
		InsightPage().clickSaveToLaunchpad();
		InsightPage().writeInAddToNewLaunchpad(text);
		InsightPage().clickOnAddNewButton();
		pause(6);
		
		/*
		 * Verifying successful message
		 */
		InsightPage().verifySuccessMessage();
		pause(2);
		
		/*
		 * Opening the just saved filters from lauchpad tab
		 */
		LaunchpadPage().clickingLaunchpadTab();
		pause(15);
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
		
		/*
		 * Deleting the last saved launchpad
		 */
		LaunchpadPage().deleteLatestSavedLaunchpadAndVerifyDeletion();
	}
}
