package com.Dashboard.pages;

import com.saf.global.TestStepType;

public class DashboardLoginPage extends DashboardWebElementLocators {

	// FOR LOGIN
	public void Dashboardlogin(String UserName, String Password) {
		log("Entering the UserName. ", TestStepType.INNER_SUBSTEP);
		type(Dashboard_Login_UserName_Textbox_Locator, UserName);
		log("Entering the Password. ", TestStepType.INNER_SUBSTEP);
		type(Dashboard_Login_Password_Textbox_Locator, Password);
		log("Clicking on LOGIN button.", TestStepType.INNER_SUBSTEP);
		click(Dashboard_Login_Button_Locator);
	}

	public void dashboardLogout() {
		log("Clicking on LOGOUT Link. ", TestStepType.INNER_SUBSTEP);
		clickAndWait(Dashboard_nba_Logout_Button_Locator);
		clickAndWait(Dashboard_nba_Logout_Link_Locator);

	}

	public void verifyReviewMessage(Object... params) {
		for (Object Message : params) {
			log("Verifying message :" + Message);
			waitForElement(Dashboard_Reviews_Message_Locator.format(Message
					.toString()));
		}
	}

	public String gettingActualReviewMessage() {
//		String ActualMessage = getAttribute(Dashboard_Review1_Locator, "value").toString().trim();
		String ActualMessage = getText(Dashboard_Review1_Locator);
		put("ActualMessage", ActualMessage);
		return ActualMessage;
	}

}
