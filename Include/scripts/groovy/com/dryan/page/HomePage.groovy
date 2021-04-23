package com.dryan.page
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

import com.kms.katalon.core.webui.driver.DriverFactory


class HomePage extends BasePage {

	@FindBy(css = "#doubleClickBtn")
	private WebElement responseCode

	public HomePage() {
		PageFactory.initElements(driver, this)
	}

	def clickButton(def name) {
		responseCode.click()
	}
}