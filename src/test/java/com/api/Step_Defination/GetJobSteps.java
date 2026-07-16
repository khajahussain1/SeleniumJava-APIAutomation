package com.api.Step_Defination;

import com.api.Method_Implementation.GetJobMethods;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;

import java.io.FileNotFoundException;

public class GetJobSteps {

    GetJobMethods getJobMethods = new GetJobMethods();


    @Given("create new user with status code {int}")
    public void create_new_user_with_status_code(Integer post_status_code) throws FileNotFoundException {
        getJobMethods.create_new_user_with_status_code(post_status_code);

    }

    @Given("get user details with status code {int}")
    public void get_user_details_with_status_code(Integer get_status_code) {
        getJobMethods.get_user_details_with_status_code(get_status_code);

    }

    @Then("delete user details with status code {int}")
    public void delete_user_details_with_status_code(Integer delete_status_code) {
        getJobMethods.delete_user_details_with_status_code(delete_status_code);

    }


}
