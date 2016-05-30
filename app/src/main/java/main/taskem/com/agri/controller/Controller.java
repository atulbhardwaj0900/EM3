package main.taskem.com.agri.controller;


import android.content.Context;

import main.taskem.com.agri.Utils.AssetReader;
import main.taskem.com.agri.Utils.JsonParser;
import main.taskem.com.agri.models.BodyContent;
import main.taskem.com.agri.models.HeadContent;

public class Controller {
    HeadContent headContent;
    private Context context;
    public Controller(Context context){
        this.context = context;
    }
    public HeadContent getHead(){
        return headContent;
    }
    public String getImage(){
        return "";
    }
    public BodyContent getContent(){
        return new BodyContent();
    }

    public void loadContent(){
       String content =  AssetReader.LoadData("event.json",context);
        JsonParser parser = new JsonParser(content);
        parser.initParsing();
        headContent = parser.getHeadContent();
    }
}
