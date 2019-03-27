package stepDefinitions;

import apiCalls.PostApiCall;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class AddPet {

    PostApiCall obj = new PostApiCall();

    @Given("^user post the add pet request with id '(\\d+)' and dog name \"([^\"]*)\"$")
    public void user_post_the_add_pet_request_with_id_and_dog_name(int id, String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        obj.add_pet(id,name);

    }

    @Then("^user get response code '(\\d+)'$")
    public void user_get_response_code(int acccode) throws Throwable {

        System.out.println("Response Code From PET POST API Call: " + acccode);

        int code = obj.get_status_code();

        Assert.assertEquals(code,200);
    }

    @Then("^user gets the id and name in response$")
    public void user_gets_the_id_and_name_in_response() throws Throwable {

        String responsemessage = obj.receive_message();

        Assert.assertTrue(responsemessage.contains("Pluto"));
        Assert.assertTrue(responsemessage.contains("1270"));

    }

    @Given("^user post the add pet request with invalid id '(\\d+)' and dog name \"([^\"]*)\"$")
    public void user_post_the_add_pet_request_with_invalid_id_and_dog_name(int id, String name) throws Throwable {


    }

    @Then("^user get error response code '(\\d+)'$")
    public void user_get_error_response_code(int code) throws Throwable {

        System.out.println("Response Code From PET POST API Call: " + code);

       // int code = obj.get_status_code();

        Assert.assertEquals(code,400);
    }


    @Then("^user gets the expected response message \"([^\"]*)\"$")
    public void user_gets_the_expected_response_message(String message) throws Throwable {

        String responsemessage = obj.receive_message();
        System.out.println("Response Message: " +responsemessage);
        Assert.assertTrue(responsemessage.contains(message));
    }




}
