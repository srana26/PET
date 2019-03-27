package stepDefinitions;

import apiCalls.GetApiCall;
import apiCalls.PutApiCall;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class GetPet {

    GetApiCall getobj = new GetApiCall();



    @Given("^user call the get pet request with id '(\\d+)'$")
    public void user_get_the_pet_request_with_id(int id) throws Throwable {

    getobj.get_pet(id);

    }


    @Then("^user get the success response code '(\\d+)'$")
    public void user_get_the_success_response_code(int respcode) throws Throwable {

        System.out.println("Response Code From GET PET API Call: " + respcode);

        int code = getobj.get_status_code();

        Assert.assertEquals(code,respcode);


    }

    @Then("^user gets the pet details in the response$")
    public void user_gets_the_pet_details_in_the_response() throws Throwable {

        String responsemessage = getobj.receive_message();

        Assert.assertTrue(responsemessage.contains("Lovely Pluto"));
        Assert.assertTrue(responsemessage.contains("1270"));


    }


    @Given("^user uses get pet request with invalid id '(\\d+)'$")
    public void user_uses_get_pet_request_with_invalid_id(int id) throws Throwable {

    getobj.get_pet(id);
    }


    @Then("^user get the error response code '(\\d+)'$")
    public void user_get_the_error_response_code(int respcode) throws Throwable {

     System.out.println("Response Code From PET POST API Call: " + respcode);

     int code = getobj.get_status_code();

     Assert.assertEquals(code,respcode);


    }

    @Then("^user gets the error message for get request \"([^\"]*)\"$")
    public void user_gets_the_error_message_for_get_request(String message) throws Throwable {

    String responsemessage = getobj.receive_message();

    Assert.assertTrue(responsemessage.contains(message));
    //Assert.assertFalse(responsemessage.contains("Pluto"));
    //Assert.assertFalse(responsemessage.contains("1270"));


    }



    /*@Given("^user put the update pet request with invalid id '(\\d+)' and dog name \"([^\"]*)\"$")
    public void user_put_the_update_pet_request_with_invalid_id(int id, String name) throws Throwable {

        getobj.get_pet(id);
    }


    @Then("^user for the request with invalid id get error response code '(\\d+)'$")
    public void user_for_the_request_with_invalid_id_get_error_response_code(int respcode) throws Throwable {

        System.out.println("Response Code From PET POST API Call: " + respcode);

        int code = getobj.get_status_code();

        Assert.assertEquals(code,400);

    }

    @Then("^user gets the message for put request with invalid id as \"([^\"]*)\"$")
    public void user_gets_the_message_for_put_request_with_invalid_id_as(String arg1) throws Throwable {

        String responsemessage = getobj.receive_message();

        Assert.assertFalse(responsemessage.contains("Pluto"));
        Assert.assertFalse(responsemessage.contains("1270"));

    }

*/
   /*

    @Given("^user post the add pet request with id '(\\d+)' and dog name \"([^\"]*)\"$")
    public void user_post_the_add_pet_request_with_id_and_dog_name(int id, String name) throws Throwable {
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
*/


}
