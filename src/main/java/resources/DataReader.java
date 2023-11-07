package resources;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {
//		FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.json"));
//		Read json to String
		File file = new File(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\Data.json");
		 String jsonContent=FileUtils.readFileToString(file, Charset.defaultCharset());
//		Convert String to Json add Jackson Databind mvn repository
		 ObjectMapper mapper=new ObjectMapper();
		 List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
		 });
		 return data;
	}
}
