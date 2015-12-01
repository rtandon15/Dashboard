package JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReaderSimple {
	
	/*
	 * This function will return the count of parent element present in the JSON file
	 * 
	 * @param jsonobj 
	 */
	public static int getElementCount(JSONObject jsonobj){
		return jsonobj.size();
	}
	
	public static Object getJsonObj(String filePath) throws FileNotFoundException, IOException, ParseException{
		
		Object obj = parser.parse(new FileReader(filePath)); 
		return obj;
		
	}
	
	public static List<String> getParentElements(JSONObject jsonObj){
		List<String> allElement = new ArrayList<String>();
//	    JSONObject jsonChildObject = (JSONObject)jsonObj.get("createAccountUser");
	    Iterator iter = jsonObj.keySet().iterator();
//	    System.out.println(jsonChildObject.size());
	    while(iter.hasNext()){
	    	allElement.add((String)iter.next());
	    }
	    return allElement;
	}
	
	static JSONParser parser = new JSONParser();
	
	public static void main(String[] args) throws Exception {
			Object obj = getJsonObj("C:\\Automation\\NPPCore\\src\\test\\java\\JsonReader\\data.json");
		    JSONObject jsonObject = (JSONObject) obj;
		   System.out.println(getParentElements(jsonObject));
//		   JSONArray array = (JSONArray)parser.parse(new FileReader("C:\\Automation\\NPPCore\\src\\test\\java\\JsonReader\\data.json"));
//		   System.out.println(array.get(1));   
		
		FileReader reader = new FileReader("C:\\Automation\\NPPCore\\src\\test\\java\\JsonReader\\data.json");

//		JSONParser jsonParser = new JSONParser();
//		JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
//		String firstName = (String) jsonObject.get("firstname");
//		System.out.println(firstName);
//		
	}
	
}
