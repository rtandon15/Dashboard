package com.Dashboard.pages;

import net.sourceforge.htmlunit.corejs.javascript.Function;

import org.openqa.selenium.JavascriptExecutor;

import com.Dashboard.data.Dashboard_BaseData;
import com.Dashboard.global.GlobalCommonMethods;

public class Dashboard_HyattPage extends DashboardWebElementLocators {

	public void clickingInsightTab() {
		click(Dashboard_Insight_Tab_Locator);
	}

	public void selectingLocations(String LocationName) {
		typeAndEnter(Dashboard_Locations_Dropdown_Locator, LocationName);
	}

	public void selectingSources(String SourceName) {
		typeAndEnter(Dashboard_Sources_Dropdown_Locator, SourceName);
	}

	public void clickApplyButton() {
		clickAndWait(Dashboard_Apply_Button_Locator);
	}

	public void clickingReviewValue() {
		clickAndWait(Dashboard_ReviewValue_Number_Locator);
	}

	public void clickCloseReview() {
		click(Dashboard_Close_Review_Button_Locator);
	}

	public void clickConnectTab() {
		click(Dashboard_Connect_Tab_Locator);
	}

	public void clickSourcesTab() {
		clickAndWait(Dashboard_Sources_Tab_Locator);
	}

	public void addingNewLaunchpad() {
		click(Dashboard_SourceDistribution_SlideButton_Locator);
		pause(1);
		clickAndWait(Dashboard_SaveToLaunchpad_Button_Locator);

	}

	public void newLaunchPad() {

		// js.executeScript("arguments[0].click();",
		// Dashboard_SaveToLaunchpad_Button_Locator);

		// js.executeScript("document.getElementsByClassName('small-button save-to-launchpad-command icon-tasks'[0].click())");
		// js.executeScript("arguments[0].scrollIntoView()",
		// Dashboard_SaveToLaunchpad_Button_Locator);

		// js.executeScript("arguments[0].click();",
		// Dashboard_SaveToLaunchpad_Button_Locator);
		hoverClick(Dashboard_SaveToLaunchpad_Button_Locator);
		type(Dashboard_AddToNewLaunchpad_Textbox_Locator,
				Dashboard_BaseData.Dashboard_AddNewLaunchpad_Input);
		click(Dashboard_AddNew_Button_Locator);

	}

}
