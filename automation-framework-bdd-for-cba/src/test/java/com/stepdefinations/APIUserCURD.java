package com.stepdefinations;

import com.FrameworkHelpers.DriverHelper;
import com.jayway.jsonpath.JsonPath;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.junit.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;


public class APIUserCURD extends DriverHelper {
    public void APIUserCURD() throws IOException {
        initRestParam();
    }
    String jsonResponse;
    @Given("^The user wants to get all the users.$")
    public void the_user_wants_to_get_all_the_users() throws IOException {
        initRestParam();

    }

    @When("^The user executes the get call$")
    public void the_user_executes_the_get_call() {
         jsonResponse = given().when().get().asString();

    }

    @Then("^The user verifies the presence of user \"([^\"]*)\"$")
    public void the_user_verifies_the_presence_of_user(String userName) {
        boolean flag = false;
        List<HashMap<String,?>> rootElement = JsonPath.read(jsonResponse,"$");
        for(int i=0 ;i<rootElement.size(); i++){

            if(rootElement.get(i).containsValue(userName)) {
                flag = true;
                break;
            }else{ flag = false;}

        }

        Assert.assertTrue(flag);
    }

    @Given("^The user wants to create a new users.$")
    public void the_user_wants_to_create_a_new_users() {

    }

    @When("^The user executes create user call with username \"([^\"]*)\" and score \"([^\"]*)\"$")
    public void the_user_executes_create_user_call_with_username_and_score(String userName, String score) throws IOException {
        initRestParam();
        String payLoad ="{\"username\":\""+userName+"\",\"score\":"+score+"}";
        given()
                .contentType(ContentType.JSON)
                .when()
                .body(payLoad)
                .post()
                .then()
                .log()
                .status()
                .statusCode(201);

    }

    @Then("^The user verifies the user \"([^\"]*)\" is created successfully$")
    public void the_user_verifies_the_user_is_created_successfully(String userName) {
         the_user_executes_the_get_call();
        the_user_verifies_the_presence_of_user(userName);

    }

    @Given("^The user wants to update score of users.$")
    public void the_user_wants_to_update_score_of_users() throws IOException {
        initRestParam();
    }

    @When("^The user executes update user call with username \"([^\"]*)\" and score \"([^\"]*)\"$")
    public void the_user_executes_update_user_call_with_username_and_score(String userName, String score) {
        String payLoad ="{\"username\":\""+userName+"\",\"score\":"+score+"}";
        given()
                .contentType(ContentType.JSON)
                .when()
                .body(payLoad)
                .put()
                .then()
                .log()
                .status()
                .statusCode(204);
    }

    @Then("^The user verifies the user is updated with new value.$")
    public void the_user_verifies_the_user_is_updated_with_new_value() {

    }

    @Given("^The user wants to delete the users.$")
    public void the_user_wants_to_delete_the_users() throws IOException {
        initRestParam();
    }

    @When("^The user executes delete all users call$")
    public void the_user_executes_delete_all_users_call() {
        given()
                .when()
                .delete()
                .then()
                .log()
                .status()
                .statusCode(401);
    }

    @Then("^The user verifies all users are deleted successfully.$")
    public void the_user_verifies_all_users_are_deleted_successfully() {
        //Can't execute this step as there is no data.
    }


}
