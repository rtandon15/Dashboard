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
	public static final String Dashboard_Warning_Button_Locator = "//*[@id='manage-alerts-command']";
	public static final String Dashboard_ManageAlert_Window_Locator = "//*[@class='manage-alerts-table-container']";
	
	
	
	// LOCATORS FOR LOGOUT PAGE
	public static final String Dashboard_nba_Logout_Button_Locator = "//*[@id='user-actions-icon']";
	public static final String Dashboard_nba_Logout_Link_Locator = "//*[@class='logout-command ng-binding']";
	
	public Locator Dashboard_Reviews_Message_Locator = new Locator(
			"//section[@class='regular-language-content-container ']/article/span[contains(.,'$0')]");
	public static final String Dashboard_Success_AlertCreated_Message_Locator ="//*[@class='ui-pnotify-title']";
	
	
	

}
