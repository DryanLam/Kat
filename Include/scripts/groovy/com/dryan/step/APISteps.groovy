package com.dryan.step
import org.testng.Assert

import com.dryan.hook.Hooks

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class APISteps extends Hooks{
	//	/**
	//	 * The step definitions below match with Katalon sample Gherkin steps
	//	 */
	//	@Given("I want to write a step with (.*)")
	//	def I_want_to_write_a_step_with_name(String name) {
	//		println name
	//	}
	//
	//	@When("I check for the (\\d+) in step")
	//	def I_check_for_the_value_in_step(int value) {
	//		println value
	//	}
	//
	//	@Then("I verify the (.*) in step")
	//	def I_verify_the_status_in_step(String status) {
	//		println status
	//	}

	//---
		 
	@Given(/^We use default header$/)
	def we_use_default_header(){
		
		def defaultHeader = new HashMap<String,Object>()
		client.setHeader(defaultHeader)
	}

	@Given(/^We use register header$/)
	def we_use_register_header(){
		client.getHeader()
	}

	@When(/^We send a POST request to '(.+?)' endpoint with body:$/)
	def we_send_a_POST_request_to_endpoint_with_body(String endPoint, String dataDody) {
		client.doPostRequest(endPoint, dataDody)
	}

	@When(/^We send a GET request to '(.+?)' endpoint$/)
	def we_send_a_GET_request_to_endpoint(String endPoint) {
		client.doGetRequest(endPoint)
	}

	@Then(/^We got the Response with status code '(.+?)'$/)
	def we_got_the_Response_with_status_code(Integer httpCode) {
		def statusCode = response.getStatusCode()
		Assert.assertEquals(httpCode, statusCode)
	}

	@Then(/^We got the Response with body:$/)
	def we_got_the_Response_with_body(String jsonBody) {
		def expected = parser.parseToJson(jsonBody);
		def actual = parser.parseToJson(response.getBodyAsString());
		Assert.assertEquals(expected.toString(), actual.toString())
	}

	@When(/^We register web service$/)
	def we_register_webserice(){
		client.doGetRequest("/register")
	}

	@When(/^We logout web service$/)
	def we_logout_webserice(){
		client.doGetRequest("/logout")
	}
}