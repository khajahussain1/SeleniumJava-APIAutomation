package com.api.Utilities;

import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;

public class Common_Methods {

    public static RequestSpecification request;

    /*public static RequestSpecification request()
    {
        RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
        request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer"+ConfigReader.getBererToken());


    }

    public static Response getGet() {

        //return RequestSpecification(ConfigReader.getBererToken()).body()
    }
*/


    public static JSONObject file_reader(String file_path) throws FileNotFoundException {
        File fi = new File(file_path);
        FileReader fr = new FileReader(fi);
        JSONTokener tokener = new JSONTokener(fr);
        return new JSONObject(tokener);

    }


public static String getRandomNumaric(int length)
{
String digits = "0123456789";
StringBuilder sb = new StringBuilder();
Random random = new Random();

for(int i=0; i<length; i++)
{
    sb.append(digits.charAt(random.nextInt(digits.length())));
}

return sb.toString();
}


}
