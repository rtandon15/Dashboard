package JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParser;

public class JsonReader {

	public static List<String> parseJSON(String filePath) throws ParseException, FileNotFoundException, IOException {
		List<String> users = new ArrayList<String>();
		
		 JSONParser parser = new JSONParser();
	        Object obj = parser.parse(new FileReader("C:\\Automation\\TestSikuli\\src\\JsonReader\\data.json"));
	        JSONObject lev1 = (JSONObject) obj;
	        Object jObj = lev1.get("createAccountUser");
	        
	        List keys = new ArrayList();
	        if (jObj instanceof Map) {
	            Map map = (Map) jObj;
	            Set keySet = map.keySet();
	            for (Object s : keySet) {
	                JSONObject jsonObj = (JSONObject) jObj;
	                JSONArray jarr = (JSONArray) jsonObj.get(s.toString());
	                
	                for (int i = 0; i < jarr.size(); i++) {
	                    Object get = jarr.get(i);
	                    JSONObject job = (JSONObject) get;
	                    String role = job.get("role").toString();
	                    users.add(role);
	                }
	            }
	            
	        }
	        return users;

	        }
	
	public static void main(String args[]){
		
		try {
			System.out.println(parseJSON(""));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

