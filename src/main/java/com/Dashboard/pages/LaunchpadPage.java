package com.Dashboard.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LaunchpadPage extends DashboardWebElementLocators {

	public void clickingLaunchpadTab() {
		click(Dashboard_Launchpad_Tab_Locator);
	}
	
	public void verifySavedLaunchpad(String text){
		waitForElement(text, 2);
	}
	
	public void clickOnLatestSavedLaunchpad(){
		java.util.List<WebElement> elements = getDriver().findElements(By.xpath(Dashboard_AllSavedLaunchPad_Link_Text_Locator));
		getDriver().findElement(By.xpath(Dashboard_AllSavedLaunchPad_Link_Text_Locator+"["+elements.size()+"]")).click();
		System.out.println("Last locator: "+Dashboard_AllSavedLaunchPad_Link_Text_Locator+"["+elements.size()+"]");
	}
	
	public void deleteLatestSavedLaunchpadAndVerifyDeletion(){
		java.util.List<WebElement> elements = getDriver().findElements(By.xpath(Dashboard_AllSavedLaunchPad_Link_Text_Locator));
		int oldSize = elements.size();
		getDriver().findElement(By.xpath(Dashboard_AllSavedLaunchPad_Link_Text_Locator+"["+oldSize+"]/span")).click();
		click(Dashboard_Delete_Confirmation_Button_Locator);
		pause(5);
		
		//Verification
		elements = getDriver().findElements(By.xpath(Dashboard_AllSavedLaunchPad_Link_Text_Locator));
		int newSize = elements.size();
		Assert.assertEquals(oldSize-newSize, 1);
	}
	
	public void editSavedLaunchpadAndVerify(){
		String newName = "SantoshTest";//randomstring();
		clickOnLatestSavedLaunchpad();
		pause(3);
		click(Dashboard_MainPage_OpenedLaunchpad_Button_Locator);
		typeAndEnter(Dashboard_MainPage_OpenedLaunchpad_Textbox_Locator, newName);
		pause(2);
		/*
		 * Now verify the same
		 */
		Assert.assertEquals(getText(Dashboard_MainPage_OpenedLaunchpad_Button_Locator), newName);
		System.out.println("First one is verified");
		String actualNewName = "";
		java.util.List<WebElement> elements = getDriver().findElements(By.xpath(Dashboard_AllSavedLaunchPad_Link_Text_Locator));
		actualNewName=getDriver().findElement(By.xpath(Dashboard_AllSavedLaunchPad_Link_Text_Locator+"["+elements.size()+"]/span")).getText();
		Assert.assertEquals(actualNewName, newName);
		System.out.println("Second one is also verified");
	}
}
