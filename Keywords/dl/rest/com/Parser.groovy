package dl.rest.com

import groovy.json.JsonSlurper
import io.cucumber.datatable.DataTable

public class Parser {
	public <T> List<T> parseDataTableToList(DataTable dataTable, Class clazz) {
		return new ArrayList(dataTable.asList(clazz));
	}

	public <T> T parseFromJson(String jsonString, Class clazz) {
		return (T) JsonObjectMapper.get().readValue(jsonString, clazz);
	}

	public Object parseToJson(String jsonString){
		return new JsonSlurper().parseText(jsonString);
	}
}
