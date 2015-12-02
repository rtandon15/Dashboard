package com.Dashboard.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.saf.global.TestStepType;

public class DashboardAlertPage extends DashboardWebElementLocators {

	public String addingAlert(String AlertName, String Description) {
		click(Dashboard_AddAlert_Button_Locator);
		String Alertname=type(Dashboard_AddAlert_Title_Textbox_Locator, AlertName).toString();
		put("Alertname", Alertname);
		type(Dashboard_AddAlert_Description_Textbox_Locator, Description);
		clickAndWait(Dashboard_AddAlert_SaveAlert_Button_Locator);
		return Alertname;

	}

	public void verifyAlertToastMessage(String message) {
		log("Verifying toast message : " + message,
				TestStepType.VERIFICATION_STEP);
		waitForElement(Dashboard_Success_AlertCreated_Message_Locator);
		// Click on cancel icon on toast message, if toast message is
		// displayed.
		if (isElementPresent("//span[@class='noty_text'][contains(.,'x')]")) {
			log("Clicking on Cancel Icon on Toast Message.",
					TestStepType.VERIFICATION_STEP);
			clickAndWait("//span[@class='noty_text'][contains(.,'x')]");
		}
	}

	public void clickingCancelAlert() {
		log("Clicking on cancel button for Alert ",
				TestStepType.VERIFICATION_STEP);
		click(Dashboard_AddAlert_Cancel_Button_Locator);

	}
	
	
	
	public void verifyAlertPresent(String AlertName)
	{
//		waitForElement(Dashboard_ManageAlert_Window_Locator, 3);
		isElementPresent(AlertName);
//		waitForTextInSection(Dashboard_ManageAlert_Window_Locator, AlertName);
	}

}
