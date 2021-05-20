import dl.rest.com.ApiClient
import dl.rest.com.WSResponse

def url = "https://demoqa.com/utilities/weather/city/Hyderabad"

def client = new ApiClient("https://demoqa.com")
def resp = new WSResponse()
resp.setResponse(client.doGetRequest("/utilities/weather/city/Hyderabad"))
def body = resp.getBody()


//def a = given()
//			.when()
//			.get(url)
//		.then()
//			.log()
//			.all();

// https://semaphoreci.com/community/tutorials/testing-rest-endpoints-using-rest-assured
			
println "abc"