package dl.rest.com

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class JsonObjectMapper extends ObjectMapper{
	private static final JsonObjectMapper INSTANCE = new JsonObjectMapper();

	public static JsonObjectMapper get() {
		INSTANCE.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return INSTANCE;
	}

	private JsonObjectMapper() {
	}

	@Override
	public String writeValueAsString(Object value) {
		try {
			return super.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			throw new TestException("Could not parse data to JSON value", e);
		}
	}

	@Override
	public <T> T readValue(String content, Class<T> valueType) {
		try {
			return super.readValue(content, valueType);
		} catch (IOException e) {
			throw new TestException("Could not parse JSON string to data type " + valueType, e);
		}
	}
}
