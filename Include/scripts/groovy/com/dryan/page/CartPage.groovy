package com.dryan.page

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory

import com.kms.katalon.core.webui.driver.DriverFactory

class CartPage {

	WebDriver driver
	
	public CartPage() {
		driver = DriverFactory.getWebDriver()
		PageFactory.initElements(driver, this)
	}

	def countItem() {
		return 5
	}
}
