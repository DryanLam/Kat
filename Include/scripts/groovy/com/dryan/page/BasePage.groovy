package com.dryan.page

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class BasePage  extends BaseAction	{

	WebDriver driver

	public HomePage homePage;
	public CartPage cartPage;

	private static BasePage instance;

	static {
		instance ?: new BasePage();
	}

	public BasePage(){
		WebUI.openBrowser("");
		driver = DriverFactory.getWebDriver()

		homePage = new HomePage()
		cartPage = new CartPage()
	}
	
	public static BasePage initialize() {
		return instance
	}
}