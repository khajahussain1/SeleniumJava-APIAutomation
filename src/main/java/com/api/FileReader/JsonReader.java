package com.api.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {

    public static String readJsonValue(String jsonObject, String jsonKey)
    {

        String currentDir = System.getProperty("user.dir");
        String file_path = currentDir+"\\src\\test\\resources\\testData\\TestData.json";
        String jsonvalue = null;

        File fi = new File(file_path);
        try{
            FileReader fr = new FileReader(fi);
            JSONTokener jt = new JSONTokener(fr);
            JSONObject data = new JSONObject(jt);
            JSONObject nestedObject = data.getJSONObject(jsonObject);

            Object value = nestedObject.get(jsonKey);

            if(value instanceof JSONArray)
            {
                JSONArray array = (JSONArray) value;
                List<String> items = new ArrayList<>();
                for(int i=0; i<array.length(); i++)
                {
                    items.add(array.getString(i));

                }
                jsonvalue = String.join(", ", items);
            }else{
                jsonvalue = nestedObject.getString(jsonKey);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return jsonvalue;
    }
}
