package com.dryan.page

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

class BasePage extends BaseAction {

	public HomePage homePage
	public CartPage cartPage

	private static BasePage instance

	public BasePage(){
		homePage = new HomePage()
		cartPage = new CartPage()
	}

	public static BasePage initialize() {
		WebUI.openBrowser("")
		instance = new BasePage()
		return instance
	}
}