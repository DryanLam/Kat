import dl.rest.com.ApiClient
import static io.restassured.RestAssured.given

def url = "https://demoqa.com/utilities/weather/city/Hyderabad"

def req = new ApiClient("https://demoqa.com")
def res = req.doGetRequest("/utilities/weather/city/Hyderabad")




//def a = given()
//			.when()
//			.get(url)
//		.then()
//			.log()
//			.all();

// https://semaphoreci.com/community/tutorials/testing-rest-endpoints-using-rest-assured
			
println "abc"