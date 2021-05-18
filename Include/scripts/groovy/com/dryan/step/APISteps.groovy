package com.dryan.step
import org.testng.Assert

import com.dryan.hook.Hooks

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import dl.rest.com.ApiClient
import dl.rest.com.Parser
import dl.rest.com.WSResponse


import com.dryan.page.BasePage

import cucumber.api.Scenario
import cucumber.api.java.After
import cucumber.api.java.Before
import internal.GlobalVariable as GlobalVariable

class APISteps{
	
	ApiClient client
	WSResponse response
	Parser parser
	
	static String TC = "" 
	
	@Given(/^We initialize webservice$/)
	def we_initialize_webservice() {
		client = new ApiClient( GlobalVariable.API_URL)
		response = new WSResponse()
		parser = new Parser()
		def headers = new HashMap<String,Object>()
		client.setHeader(headers)
	}
	
	@When(/^We send a POST request to '(.+?)' endpoint with body:$/)
	def we_send_a_POST_request_to_endpoint_with_body(String endPoint, String dataDody) {
		def res = client.doPostRequest(endPoint, dataDody)
		response.setResponse(res)
	}

	@When(/^We send a GET request to '(.+?)' endpoint$/)
	def we_send_a_GET_request_to_endpoint(String endPoint) {
		def res = client.doGetRequest(endPoint)
		response.setResponse(res)
	}

	@Then("We got the Response with status code '{int}'")
	def we_got_the_Response_with_status_code(int httpCode) {
		def statusCode = response.getStatusCode()
		Assert.assertEquals(httpCode, statusCode)
	}

	@Then(/^We got the Response with body:$/)
	def we_got_the_Response_with_body(String jsonBody) {
		def expected = parser.parseToJson(jsonBody);
		def actual = parser.parseToJson(response.getBodyAsString());
		Assert.assertEquals(expected, actual)
	}
	
//	@Then("her/his stats include {int} {correct} attempt(s)")
//	public void statsIncludeAttempts(int attemptNumber, boolean correct) {
//	}
}