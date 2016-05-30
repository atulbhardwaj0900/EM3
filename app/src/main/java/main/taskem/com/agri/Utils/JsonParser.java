package main.taskem.com.agri.Utils;


import org.json.JSONException;
import org.json.JSONObject;

import main.taskem.com.agri.models.HeadContent;

public class JsonParser {
    String content;
    HeadContent headContent;
 public JsonParser(String string){
     content = string;
 }
    public JSONObject getJson() {
        if (content != null) {
            try {
                return new JSONObject(content);
            } catch (JSONException e) {
                return null;
            }
        }
        else{
            return null;
        }
    }
 public void initParsing(){
     JSONObject object = getJson();
     if(object!=null){
         headContent = new HeadContent();
         headContent.setHeading(object.optString("name"));
         headContent.setStartDate(object.optString("start_time"));
         headContent.setEndDate(object.optString("end_time"));
         headContent.setAttending_status(object.optString("attending_status"));
     }
 }
public  HeadContent getHeadContent(){
        return headContent;
    }
}
