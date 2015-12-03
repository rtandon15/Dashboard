package com.Dashboard.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.saf.global.TestStepType;

public class DashboardAlertPage extends DashboardWebElementLocators {

	public String addingAlert(String AlertName, String Description) {
		click(Dashboard_AddAlert_Button_Locator);
		type(Dashboard_AddAlert_Title_Textbox_Locator, AlertName).toString();
		// String Alertname = getText(Dashboard_AddAlert_Title_Textbox_Locator);
		String Alertname = getAttribute(
				Dashboard_AddAlert_Title_Textbox_Locator, "value").toString()
				.trim();
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

	public void verifyAlertPresent(String AlertName) {
		// waitForElement(Dashboard_ManageAlert_Window_Locator, 3);
		// isElementPresent(AlertName);
		// waitForTextInSection(Dashboard_ManageAlert_Window_Locator,
		// AlertName);
		// waitForTextInSection(Dashboard_ManageAlert_Window_Locator, AlertName,
		// 2);

	}

	public String gettingValueForAddedAlertinTable() {
		String alertName = getText(Dashboard_ManageAlert_Window_Locator);
		put("alertName", alertName);
		return alertName;

	}

	public void clickingManageAlertButton() {
		clickAndWait(Dashboard_ManageAlert_Button_Locator);
	}

	public void deleteLastAlertFromManageAlert() {
		clickAndWait(Dashboard_ManageAlert_Delete_LastButton_Locator);
		clickAndWait(Dashboard_ManageAlert_Delete_PopupButton_Locator);
	}

}
