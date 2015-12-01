package JsonReader;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingJsonFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.testng.annotations.*;

@SuppressWarnings("deprecation")
public class Json_Read_Utility{
	
	@Test
	public void Test(){
		for(int i =0;i<2;i++){
		try {
			HashMap<String, String> NDA_Form_Data=fetchData("C:\\Automation\\NPPCore\\src\\test\\java\\JsonReader\\data.json", "deleteAccount");
			for(Entry<String, String> e:NDA_Form_Data.entrySet()){
	        	 System.out.println(e.getKey()+":"+e.getValue());
	         }
//			HashMap<String, String> NDA_Form_Object_Details=fetchData("C:\\Automation\\NPPCore\\src\\test\\java\\JsonReader\\data.json", "NDA_Form_Object_Details");
//			for(Entry<String, String> e:NDA_Form_Object_Details.entrySet()){
//	        	 System.out.println(e.getKey()+":"+e.getValue());
//	         }
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	}
	
public  HashMap<String, String> fetchData(String filePath,String fetchFor) throws JsonParseException, IOException{
	JsonFactory f = new MappingJsonFactory();
	JsonParser jp = f.createJsonParser(new File(filePath));
    JsonToken current;
    current = jp.nextToken();
    HashMap<String, String> hashMap=new HashMap<String,String>();
    if (current != JsonToken.START_OBJECT) {
      System.out.println("Error: root should be object: quiting.");
      return null;
    }
    while (jp.nextToken() != JsonToken.END_OBJECT) {
      String fieldName = jp.getCurrentName();
      // move from field name to field value
      current = jp.nextToken();
      if (fieldName.equals(fetchFor)) {
        if (current == JsonToken.START_ARRAY) {
          // For each of the records in the array
          while (jp.nextToken() != JsonToken.END_ARRAY) {
            // read the record into a tree model, this moves the parsing position to the end of it
            JsonNode node = jp.readValueAsTree();
            Iterator<String> iterator=node.fieldNames();
            while(iterator.hasNext()){
            	String attribute=iterator.next();
            	String attributeValue=node.get(attribute).toString().replace("+", "");
            	//System.out.println(attributeValue);
            	if(attributeValue.contains("getName()"))
            		attributeValue=attributeValue.replace("getName()", getName(4));
            	if(attributeValue.contains("getAlphaNumeric()"))
            		attributeValue=attributeValue.replace("getAlphaNumeric()", getAlphaNumeric(3));
            	if(attributeValue.contains("datetime()"))
            		attributeValue=attributeValue.replace("datetime()", datetime());
            	if(attributeValue.contains("getNewRandomEmail()"))
            		attributeValue=attributeValue.replace("getNewRandomEmail()", getNewRandomEmail());
            	attributeValue = attributeValue.replace("\"", "");
            	attributeValue = attributeValue.replace("\"", "");
            	hashMap.put(attribute, attributeValue.toString());
            }
          }
        } else {
          System.out.println("Error: records should be an array: skipping.");
          jp.skipChildren();
        }
      } else {
        jp.skipChildren();
      }
    }
    System.out.println(hashMap.toString());
    return hashMap;
	}

//Random Value Generation Snippet

public String ALPHA_NUM = "0123456789abcdefghijklmnopqrstuvwxyz";
public String ALPHA_NUM_SC = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%^&*()";
public String Character = "abcdefghijklmnopqrstuvwxyz";
public static DateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmssSSS");

public String getName(int len) {
	StringBuffer sb = new StringBuffer(len);
	for (int i=0;  i<len;  i++) {
		int ndx = (int)(Math.random()*Character.length());
		sb.append(Character.charAt(ndx));
	}
	return sb.toString();
}

public String getAlphaNumeric(int len) {
	StringBuffer sb = new StringBuffer(len);
	for (int i=0;  i<len;  i++) {
		int ndx = (int)(Math.random()*(ALPHA_NUM.length()));
		sb.append(ALPHA_NUM.charAt(ndx));
	}
	return sb.toString();
}

public String datetime(){
	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
	Date date = new Date();
	String Time= dateFormat.format(date);
	return Time;
}

public String getNewRandomEmail() {
	return "_" + dateTime() + getRandomAlphaNumeric(6) + "@sharklasers.com";
}

public static String dateTime() {
	return dateFormat.format(new Date());
}
public String getRandomAlphaNumeric(int len) {
	StringBuffer sb = new StringBuffer(len);
	for (int i = 0; i < len; i++) {
		int ndx = (int) (Math.random() * (ALPHA_NUM.length()));
		sb.append(ALPHA_NUM.charAt(ndx));
	}
	return sb.toString();
}

public static List<String> getParentElements(JSONObject jsonObj){
	
	List<String> allElement = new ArrayList<String>();
    Iterator iter = jsonObj.keySet().iterator();
    while(iter.hasNext()){
    	allElement.add((String)iter.next());
    }
    return allElement;
}

public static String readJSONFileAsString(String filePath) throws Exception{
	String everything = null;
	 BufferedReader br = new BufferedReader(new FileReader(filePath));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append(System.lineSeparator());
	            line = br.readLine();
	        }
	        everything = sb.toString();
	       // System.out.println(everything);
	    } finally {
	        br.close();
	    }
	    return everything;
}

// To fetch value of a key in JSON Object
public static HashMap<String, String> fetchValuesFromJSON(String input, String jsonObject) throws Exception {
  JSONArray  arr=new JSONArray(input);
  Iterator<String> iter = arr.getJSONObject(0).getJSONObject(jsonObject).keys();
  HashMap<String, String > map=new HashMap<String, String>();
  while(iter.hasNext()){
	  String key = iter.next();
	  map.put(key, arr.getJSONObject(0).getJSONObject(jsonObject).get(key).toString());
  }
   return map;
 }
 
 public static JSONArray fetchJSONObjects(String inputString) throws JSONException{
	 JSONArray  arr=new JSONArray(inputString);
	 return arr.getJSONObject(0).names();
 }

}
