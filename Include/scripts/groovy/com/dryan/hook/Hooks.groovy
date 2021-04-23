package com.dryan.hook

import cucumber.api.java.After
import cucumber.api.java.Before

import com.dryan.page.BasePage



public class Hooks {
	
	
	@Before
	def installApp() {
		println "Before"
	}
	
	@After
	def resetApp() {
		BasePage.dispose()
	}
}
