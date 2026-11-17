package com.api.Method_Implementation;

import com.api.Utilities.GlobalVariables;
import com.api.Utilities.ResponseHolder;
import com.api.FileReader.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static com.api.Utilities.Common_Methods.file_reader;
import static com.api.Utilities.Common_Methods.getRandomNumaric;


public class GetJobMethods {

    private final String serviceURL = ConfigReader.gethosturl();

    ResponseHolder ResponseHolder;
    Response response;
    RequestSpecification request;
    //public Logger logger = Logger.getLogger(GetJobMethods.class);

    public GetJobMethods()
    {
        //RestAssured.config = RestAssured.config().sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation());
        request = RestAssured.given();
        //request.header("Authorization", "Bearer"+ConfigReader.getBererToken());
        request.header("Content-Type", "application/json");
    }

/*
    private JSONObject filereader(String file_path) throws FileNotFoundException {
        File fi = new File(file_path);
        FileReader fr = new FileReader(fi);
        JSONTokener tokener = new JSONTokener(fr);
        return new JSONObject(tokener);

    }*/



    public void create_new_user_with_status_code(int post_status_code) throws FileNotFoundException {
      String file = "/src/test/resources/Json_files/Create_users.json";
       JSONObject data = file_reader(file);
       String random_value = getRandomNumaric(2);

       System.out.println("random_value : "+random_value);
       data.put("userId", random_value);
        request.body(data.toString());
        response =request.post(ConfigReader.gethosturl());
        int response_userId = response.jsonPath().getInt("userId");

        System.out.println("response_userId : "+response_userId);

        Assert.assertEquals(response.getStatusCode(), post_status_code);
        String responseBody = response.getBody().prettyPrint();
        GlobalVariables.Response_userId=response_userId;

    }

    public void get_user_details_with_status_code(int get_status_code){
        System.out.println("GlobalVariables.ResponseId : "+GlobalVariables.Response_userId);
        response =request.when().get(ConfigReader.gethosturl()+GlobalVariables.Response_userId);
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.getStatusCode(), get_status_code);

    }

    public void delete_user_details_with_status_code(int delete_status_code){
        System.out.println("GlobalVariables.ResponseId : "+GlobalVariables.Response_userId);
        response =request.delete(ConfigReader.gethosturl()+GlobalVariables.Response_userId);
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.getStatusCode(), delete_status_code);

    }





}
