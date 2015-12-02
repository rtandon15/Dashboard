package com.Dashboard.pages;

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

	public void clickingWarningButton() {
		clickAndWait(Dashboard_Warning_Button_Locator);
	}

}
