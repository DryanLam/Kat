package com.dryan.hook

import cucumber.api.java.After
import cucumber.api.java.Before




public class Hooks {
	
	
	@Before
	def installApp() {
		println "Before"
	}
	
	@After
	def resetApp() {
		println "After"
	}
}
