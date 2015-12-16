package com.Dashboard.pages;

import com.Dashboard.global.GlobalCommonMethods;
import com.saf.global.Locator;

public class DashboardWebElementLocators extends GlobalCommonMethods {

	// LOCATORS FOR LOGIN PAGE
	public String Dashboard_Login_UserName_Textbox_Locator = "//input[@name='username']";
	public String Dashboard_Login_Password_Textbox_Locator = "//input[@name='password']";
	public String Dashboard_Login_Button_Locator = "//button[@type='button']//span[text()='Login']";

	// LOCATORS FOR DASHBOARD PAGE
	public static final String Dashboard_Insight_Tab_Locator = "//li[text()='Insight']";
	public static final String Dashboard_Sources_Dropdown_Locator = "//input[@title='Sources (0)']";
	public static final String Dashboard_TripAdvisor_Option_Locator = "//span[@title='Trip Advisor']";
	public static final String Dashboard_Locations_Dropdown_Locator = "//input[@title='Locations (0)']";
	public static final String Dashboard_Review1_Locator = "//*[@class='regular-language-content-container ']/article";
	public static final String Dashboard_ReviewValue_Number_Locator = "//*[@class='numeric r-cell']//a";
	public static final String Dashboard_Apply_Button_Locator = "//button[@class='update-filters big-button']/span";
	public static final String Dashboard_Close_Review_Button_Locator = "//*[@class='close']";

	public static final String Dashboard_Connect_Tab_Locator = "//li[contains(text(),'Connect')]";
	public static final String Dashboard_AddAlert_Button_Locator = "//*[@id='add_alert_button']//span";
	public static final String Dashboard_AddAlert_Title_Textbox_Locator = "//*[@id='alert_title']";
	public static final String Dashboard_AddAlert_Description_Textbox_Locator = "//*[@id='alert_description']";
	public static final String Dashboard_AddAlert_SaveAlert_Button_Locator = "//*[@class='save-alert-icon']";
	public static final String Dashboard_AddAlert_Cancel_Button_Locator = "//*[@href='javascript: void(0)']";
	public static final String Dashboard_ManageAlert_Button_Locator = "//*[@id='manage-alerts-command']";
	public static final String Dashboard_ManageAlert_Window_Locator = "//*[@id='manage-alerts-table']/tbody/tr[last()]/td[1]";
	public static final String Dashboard_ManageAlert_Delete_LastButton_Locator = "//*[@id='manage-alerts-table']/tbody/tr[last()]/td[4]/div/div[2]/span";
	public static final String Dashboard_ManageAlert_Delete_PopupButton_Locator = ".//*[@id='dData']";

	public static final String Dashboard_Sources_Tab_Locator = "//li[@data-page-id='@{@page.id}'][3]";
	public static final String Dashboard_SaveToLaunchpad_Button_Locator = "//div[@class='header ui-helper-clearfix']/div[@class='actions']//li/a[@title='Save to Launchpad']";
	public static final String Dashboard_ShowNavigator_Button_Locator = "//*[@class='ui-slider-handle ui-state-default ui-corner-all']";
	public static final String Dashboard_SourceDistribution_SlideButton_Locator = "//*[@class='sources-slider c-b ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']";
	public static final String Dashboard_AddToNewLaunchpad_Textbox_Locator = "//*[@class='page-layout-new-input']";
	public static final String Dashboard_AddNew_Button_Locator = "//*[@class='page-layout-new-command small-button']";

	// LOCATORS FOR LOGOUT PAGE
	public static final String Dashboard_nba_Logout_Button_Locator = "//*[@id='user-actions-icon']";
	public static final String Dashboard_nba_Logout_Link_Locator = "//*[@class='logout-command ng-binding']";

	public Locator Dashboard_Reviews_Message_Locator = new Locator(
			"//section[@class='regular-language-content-container ']/article/span[contains(.,'$0')]");
	public static final String Dashboard_Success_AlertCreated_Message_Locator = "//*[@class='ui-pnotify-title']";

}
