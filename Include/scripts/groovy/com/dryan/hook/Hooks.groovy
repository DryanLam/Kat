package com.dryan.hook

import com.dryan.page.BasePage

import cucumber.api.Scenario
import cucumber.api.java.After
import cucumber.api.java.Before
import dl.rest.com.ApiClient
import dl.rest.com.Parser
import dl.rest.com.WSResponse
import internal.GlobalVariable as GlobalVariable


public class Hooks {


	@Before
	def setUp(Scenario sc) {
		println "Before"
		if(GlobalVariable.IS_PROFILING) {
			startProfilingTC(sc)
		}
	}

	@After
	def tearDown() {
		if(GlobalVariable.IS_PROFILING) {
			stopProfiling()
		}
		BasePage.dispose()
	}
	
	private def startProfilingTC(Scenario sc) {
		def client = new ApiClient(GlobalVariable.API_URL)
		def response = new WSResponse()
		def defaultHeader = new HashMap<String,Object>()
		client.setHeader(defaultHeader)
		def tags = sc.getSourceTagNames().join(",")
		client.setHeader(["testcase": tags])
		client.doGetRequest("/register")
	}
	
	private def stopProfiling() {
		def client = new ApiClient(GlobalVariable.API_URL)
		def response = new WSResponse()
		def defaultHeader = new HashMap<String,Object>()
		client.setHeader(defaultHeader)
		client.doGetRequest("/logout")
	}
}
