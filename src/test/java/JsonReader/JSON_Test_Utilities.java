package JsonReader;

import java.io.File;
import java.io.FileWriter;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSON_Test_Utilities {

	public static void main(String[] args) {
		try {
			String input=Json_Read_Utility.readJSONFileAsString("C:\\Automation\\BDNS\\src\\test\\java\\JsonReader\\Sample.json");
//			System.out.println(fetchValueFromJSON(input, "image.thumbnail.image.thumbnail.url"));
//			System.out.println(fetchValueFromJSON(input, "image.thumbnail.url"));
//			System.out.println(fetchValueFromJSON(input, "thumbnail.url"));
//			System.out.println(fetchValueFromJSON(input, "type"));			
			//System.out.println(fetchValueFromJSON(input, "test2.address.address1.Street"));
			updateJSONDataInSource("C:\\Automation\\BDNS\\src\\test\\java\\JsonReader\\Sample.json", "image.thumbnail.image.thumbnail.url", "updatedValue1");
			updateJSONDataInSource("C:\\Automation\\BDNS\\src\\test\\java\\JsonReader\\Sample.json", "image.thumbnail.url", "updatedValue2");
			updateJSONDataInSource("C:\\Automation\\BDNS\\src\\test\\java\\JsonReader\\Sample.json", "thumbnail.url", "updatedValue3");
			updateJSONDataInSource("C:\\Automation\\BDNS\\src\\test\\java\\JsonReader\\Sample.json", "type", "updatedValue4");
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	// To update the value of a JSON element available in a file 
	public static void updateJSONDataInSource(String filePath, String keyMain, Object newValue) throws Exception{
		String updatedData=updateValueInJSON(Json_Read_Utility.readJSONFileAsString(filePath), keyMain, newValue);
		System.out.println(updatedData);
		File jsonFile = new File(filePath);
		FileWriter fooWriter = new FileWriter(jsonFile, false);		                                                     
		fooWriter.write(updatedData);
		fooWriter.close();
	}
	
	// To update value of a key in JSON Object - keyMain => Eg., image.thumbnail.image.thumbnail.url;image.thumbnail.url;image.name;name
	public static String updateValueInJSON(String input, String keyMain, Object newValue) throws Exception {
		try{
		JSONArray arr=null;
		if(!(input.startsWith("[")))
			arr=new JSONArray("["+input+"]");
		else
			arr=new JSONArray(input);
		if(keyMain.contains(".")){
			int hierarchyLength=keyMain.length() - keyMain.replace(".", "").length();
			String[]  keys=keyMain.split("\\.");
			JSONObject baseObject=arr.getJSONObject(0);
			JSONObject childObject=null;
			if(hierarchyLength>2){
				for(int i=0;i<hierarchyLength;i++){
					childObject=baseObject.getJSONObject(keys[i]);
					baseObject=childObject;
				}				
				childObject.put(keys[keys.length-1], newValue);
			}
			else if(hierarchyLength==2)
				arr.getJSONObject(0).getJSONObject(keyMain.split("\\.")[0]).getJSONObject(keyMain.split("\\.")[1]).put(keyMain.split("\\.")[2], newValue);				
			else
				arr.getJSONObject(0).getJSONObject(keyMain.split("\\.")[0]).put(keyMain.split("\\.")[1],newValue);
		}
		else
			arr.getJSONObject(0).put(keyMain,newValue);
		if(!(input.startsWith("[")))
			return arr.getJSONObject(0).toString(4);
		else
			return arr.toString(4);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	// To fetch value of a key in JSON Object - keyMain => Eg., image.thumbnail.image.thumbnail.url;image.thumbnail.url;image.name;name
		public static String fetchValueFromJSON(String input, String keyMain) throws Exception {
			try{
			JSONArray arr=null;
			if(!(input.startsWith("[")))
				arr=new JSONArray("["+input+"]");
			else
				arr=new JSONArray(input);
			if(keyMain.contains(".")){
				int hierarchyLength=keyMain.length() - keyMain.replace(".", "").length();
				String[]  keys=keyMain.split("\\.");
				JSONObject baseObject=arr.getJSONObject(0);
				JSONObject childObject=null;
				if(hierarchyLength>2){
					for(int i=0;i<hierarchyLength;i++){
						childObject=baseObject.getJSONObject(keys[i]);
						baseObject=childObject;
					}				
					return childObject.getString(keys[keys.length-1]).toString();
				}
				else if(hierarchyLength==2)
					return arr.getJSONObject(0).getJSONObject(keyMain.split("\\.")[0]).getJSONObject(keyMain.split("\\.")[1]).get(keyMain.split("\\.")[2]).toString();				
				else
					return arr.getJSONObject(0).getJSONObject(keyMain.split("\\.")[0]).get(keyMain.split("\\.")[1]).toString();
			}
			else
				return arr.getJSONObject(0).get(keyMain).toString();
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
}
