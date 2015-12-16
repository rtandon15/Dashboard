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
		// DashboardLoginPage().verifyReviewMessage("rooms", "nice", "clean",
		// "no one said it was impossible", "lady in the frontdesk");
		String ExpectedMessage = LoadProperties
				.reviewsValidation("HyattReview");
		System.out.println("ExpectedMessage: " + ExpectedMessage);
		String ActualMessage = DashboardLoginPage()
				.gettingActualReviewMessage();
		System.out.println("ActualMessage: " + ActualMessage);
		isTextMatching(ExpectedMessage, ActualMessage);
		Dashboard_HyattPage().clickCloseReview();
		DashboardLoginPage().dashboardLogout();
	}

	@Test(groups = { TestGroups.RegressionGroup, TestGroups.ALLGroup }, description = "The test case verifies Alert created is available under Manage Alert. ")
	public void verifyAlerttPresentOnCreation() throws Exception {
		DashboardLoginPage().Dashboardlogin(
				Dashboard_BaseData.Dashboard_Login_Username_Input,
				Dashboard_BaseData.Dashboard_Login_Password_Input);
		pause(3);
		Dashboard_HyattPage().clickConnectTab();
		Dashboard_HyattPage().selectingLocations("Hyatt Miami at The Blue");
		Dashboard_HyattPage().selectingSources("Trip Advisor");
		Dashboard_HyattPage().clickApplyButton();
		String AlertName1 = DashboardAlertPage().addingAlert(
				Dashboard_BaseData.Dashboard_AlertName_Input, "Test Alert");
		System.out.println("AlertName :" + AlertName1);
		DashboardAlertPage().verifyAlertToastMessage(
				Dashboard_BaseData.Dashboard_AlertCreatedToastMessage_Input);
		DashboardAlertPage().clickingCancelAlert();
		pause(2);
		DashboardAlertPage().clickingManageAlertButton();
		String AlertName2 = DashboardAlertPage()
				.gettingValueForAddedAlertinTable();
		System.out.println("Alertname from table:" + AlertName2);
		pause(2);
		// isTextMatching(AlertName1, AlertName2);
		GlobalCommonMethods().verifyTextMatching(AlertName1, AlertName2);
		pause(2);
		DashboardLoginPage().dashboardLogout();
	}

	@Test(groups = { TestGroups.RegressionGroup, TestGroups.ALLGroup }, description = "The test case verifies Alert is removed from manage Alert table on deletion. ")
	public void verifyAlertNotPresentOnDeletion() throws Exception {
		DashboardLoginPage().Dashboardlogin(
				Dashboard_BaseData.Dashboard_Login_Username_Input,
				Dashboard_BaseData.Dashboard_Login_Password_Input);
		pause(3);
		Dashboard_HyattPage().clickConnectTab();
		Dashboard_HyattPage().selectingLocations("Hyatt Miami at The Blue");
		Dashboard_HyattPage().selectingSources("Trip Advisor");
		Dashboard_HyattPage().clickApplyButton();
		String AlertName3 = DashboardAlertPage().addingAlert(
				Dashboard_BaseData.Dashboard_AlertName_Input, "Test Alert");
		System.out.println("AlertName :" + AlertName3);
		DashboardAlertPage().clickingCancelAlert();
		pause(2);
		DashboardAlertPage().clickingManageAlertButton();
		pause(1);
		DashboardAlertPage().deleteLastAlertFromManageAlert();
		String AlertName4 = DashboardAlertPage()
				.gettingValueForAddedAlertinTable();
		System.out.println("Alertname from table:" + AlertName4);
		GlobalCommonMethods().verifyTextNotMatching(AlertName3, AlertName4);
		pause(1);
		DashboardLoginPage().dashboardLogout();

	}

	@Test(groups = { TestGroups.RegressionGroup, TestGroups.ALLGroup }, description = "The test case verifies newly created Launchpad appears at the bottom of Dashboard application. ")
	public void verifyNewlyCreatedLaunchpad() throws Exception {
		DashboardLoginPage().Dashboardlogin(
				Dashboard_BaseData.Dashboard_Login_Username_Input,
				Dashboard_BaseData.Dashboard_Login_Password_Input);
		pause(3);
		Dashboard_HyattPage().clickingInsightTab();
		Dashboard_HyattPage().clickSourcesTab();
		pause(1);
		Dashboard_HyattPage().newLaunchPad();

	}

}
