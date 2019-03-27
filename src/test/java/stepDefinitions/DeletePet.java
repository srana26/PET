package stepDefinitions;

import apiCalls.DeleteApiCall;
import apiCalls.GetApiCall;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class DeletePet {

    DeleteApiCall deleteobj = new DeleteApiCall();
    GetApiCall getobj = new GetApiCall();


    @Given("^user call the delete pet request with id '(\\d+)'$")
    public void user_call_the_delete_pet_request_with_id(int id) throws Throwable {

    deleteobj.delete_pet(id);

    }


    @Then("^record is deleted and user get the success response code '(\\d+)'$")
    public void record_is_deleted_and_user_get_the_success_response_code(int respcode) throws Throwable {

        System.out.println("Response Code From Delete API Call: " + respcode);

        int code = deleteobj.get_status_code();

        Assert.assertEquals(code,respcode);


    }

    @Then("^user call the get pet request to validate deletion with id '(\\d+)'$")
    public void user_call_the_get_pet_request_to_validate_deletion_with_id(int id) throws Throwable {

       getobj.get_pet(id);

       int statuscode = getobj.get_status_code();

       Assert.assertEquals(statuscode,404);

       String responsemessage = getobj.receive_message();

        Assert.assertFalse(responsemessage.contains("Lovely Pluto"));
        Assert.assertFalse(responsemessage.contains("1270"));


    }


    @Given("^user calls delete pet request with unavailable id '(\\d+)'$")
    public void user_calls_delete_pet_request_with_unavailable_id(int id) throws Throwable {

        deleteobj.delete_pet(id);

    }


    @Then("^user for unavailable id delete request get the error response code '(\\d+)'$")
    public void user_for_unavailable_id_delete_request_get_the_error_response_code(int respcode) throws Throwable {

        int statuscode = deleteobj.get_status_code();
        Assert.assertEquals(respcode,statuscode);
    }


}
