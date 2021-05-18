package dl.rest.com

import io.restassured.response.Response

public class WSResponse {
	private Response response

	def setResponse(Response response) {
		this.response = response
	}

	def getResponse() {
		return response
	}

	int getStatusCode() {
		return response.getStatusCode()
	}

	def getBody() {
		return response.getBody()
	}

	def getBodyAsString(def pretty = true) {
		if (pretty) {
			return response.getBody().prettyPrint()
		}
		return response.getBody().asString()
	}
}
