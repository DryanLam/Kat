package com.dryan.page

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

	public static void dispose() {
		WebUI.closeBrowser()
		instance = null
		System.gc()
	}
}