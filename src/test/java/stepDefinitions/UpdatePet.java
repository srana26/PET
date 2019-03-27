package stepDefinitions;

import apiCalls.PostApiCall;
import apiCalls.PutApiCall;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class UpdatePet {

    PutApiCall putobj = new PutApiCall();

    @Given("^user put the update pet request with id '(\\d+)' and dog name \"([^\"]*)\"$")
    public void user_put_the_update_pet_request_with_id_and_dog_name(int id, String name) throws Throwable {

    putobj.update_pet(id,name);

    }


    @Then("^user get the response code '(\\d+)'$")
    public void user_get_the_response_code(int respcode) throws Throwable {

        System.out.println("Response Code From PET POST API Call: " + respcode);

        int code = putobj.get_status_code();

        Assert.assertEquals(code,respcode);


    }

    @Then("^user gets the updated id and name in response$")
    public void user_gets_the_updated_id_and_name_in_response() throws Throwable {

        String responsemessage = putobj.receive_message();

        Assert.assertTrue(responsemessage.contains("Pluto"));
        Assert.assertTrue(responsemessage.contains("1270"));


    }


    @Given("^user put the update pet request with invalid id '(\\d+)' and dog name \"([^\"]*)\"$")
    public void user_put_the_update_pet_request_with_invalid_id(int id, String name) throws Throwable {

        putobj.update_pet(id,name);
    }


    @Then("^user for the request with invalid id get error response code '(\\d+)'$")
    public void user_for_the_request_with_invalid_id_get_error_response_code(int respcode) throws Throwable {

        System.out.println("Response Code From PET PUT API Call: " + respcode);

        int code = putobj.get_status_code();

        Assert.assertEquals(code,200);

    }

    @Then("^user gets the message for put request with invalid id as \"([^\"]*)\"$")
    public void user_gets_the_message_for_put_request_with_invalid_id_as(String arg1) throws Throwable {

        String responsemessage = putobj.receive_message();

        Assert.assertFalse(responsemessage.contains("Pluto"));
        Assert.assertFalse(responsemessage.contains("1270"));

    }

}
