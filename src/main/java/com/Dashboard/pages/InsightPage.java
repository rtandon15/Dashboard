package com.Dashboard.pages;

public class InsightPage extends DashboardWebElementLocators{

	public void clickingInsightTab() {
		click(Dashboard_Insight_Tab_Locator);
	}
	
	public void setSearchCriteria(String locationName, String sourceName) {
		selectingLocations(locationName);
		selectingSources(sourceName);
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
	
	public void clickSaveToLaunchpad(){
		click(Dashboard_SaveToLaunchpad_Button_Locator);
	}
	
	public void writeInAddToNewLaunchpad(String text){
		type(Dashboard_AddToNewLaunchpad_Textbox_Locator, text);
	}
	
	public void clickOnAddNewButton(){
		click(Dashboard_AddNew_Button_Locator);
	}

	public void hoverOnSaveToLaunchpad(){
		hoverClick(Dashboard_SaveToLaunchpad_Button_Locator);
	}
	
	public void verifySuccessMessage(){
		waitForElement(Dashboard_Success_Message_Text_Locator,2);
	}
}
