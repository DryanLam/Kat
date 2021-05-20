package dl.rest.com

import io.restassured.filter.cookie.CookieFilter
import io.restassured.http.ContentType
import io.restassured.response.Response
import static io.restassured.RestAssured.given


public class ApiClient {
	
	private CookieFilter filter = new CookieFilter();
	private Map<String,Object> header = new HashMap<String,Object>();

	protected final String baseUri;
	
	ApiClient(String baseUri) {
		this.baseUri = baseUri;
	}

	protected URI buildUri(String relativeUri) {
        try {
            return new URI(buildURIAsString(relativeUri));
        } catch (URISyntaxException e) {
            throw new TestException("*** ERROR: Could not build URI", e);
        }
    }
	
	protected String buildURIAsString(String relativeUri) {
		return baseUri + relativeUri;
	}
	
	
	public void setHeader(Map header){
		this.header = header;
	}

	public Map getHeader(){
		return header;
	}

	public Response doAuthentication(String userName, String passWord, Object bodyObj){
		return given()
				.filter(filter)
				.headers(header)
				.body(bodyObj)
				.post(buildUri("register"))
				.andReturn();
	}

	public Response doPostRequest(String uriPath, Object bodyObj) {
		Response resp = given()
							 .filter(filter)
							 .contentType(ContentType.JSON)
							 .headers(header)
							 .body(bodyObj)
							 .post(buildUri(uriPath))
							 .thenReturn();
		return resp;
	}

	public Response doGetRequest(String uriPath) {
		Response resp =  given()
								.filter(filter)
								.headers(header)
								.contentType(ContentType.JSON)
								.get(buildUri(uriPath))
								.thenReturn();
		return resp;
	}
}
