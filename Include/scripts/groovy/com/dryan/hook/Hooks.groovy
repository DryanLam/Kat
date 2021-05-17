package com.dryan.hook

import com.dryan.page.BasePage

import cucumber.api.Scenario
import cucumber.api.java.After
import cucumber.api.java.Before
import dl.rest.com.ApiClient
import dl.rest.com.Parser
import dl.rest.com.WSResponse
import internal.GlobalVariable


public class Hooks {

	ApiClient client
	WSResponse response
	Parser parser

	@Before
	def installApp(Scenario sc) {
		println "Before"
		def apiUrl = GlobalVariable.API_URL

		client = new ApiClient(apiUrl)
		response = new WSResponse()

		def tags = sc.getSourceTagNames().join(",")
		client.setHeader(["testcase": tags])
		//		log.info("Test WS");
	}

	@After
	def resetApp() {
		BasePage.dispose()
	}
}
