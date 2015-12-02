package com.test.Dashboard;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Dashboard.data.Dashboard_BaseData;
import com.Dashboard.global.DashboardPageFactory;
import com.Dashboard.global.TestGroups;
import com.saf.global.LoadProperties;

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
//		DashboardLoginPage().verifyReviewMessage("rooms","nice","clean","no one said it was impossible","lady in the frontdesk");
		String ExpectedMessage=LoadProperties.reviewsValidation("HyattReview");
		System.out.println("ExpectedMessage: " + ExpectedMessage);
		String ActualMessage=DashboardLoginPage().gettingActualReviewMessage();
		System.out.println("ActualMessage: " + ActualMessage);
		isTextMatching(ExpectedMessage,ActualMessage);	
		Dashboard_HyattPage().clickCloseReview();
		DashboardLoginPage().dashboardLogout();
	}
}
