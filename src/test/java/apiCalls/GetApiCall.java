package apiCalls;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.thucydides.core.annotations.Step;

public class GetApiCall {


    private Response response;

    @Step
    public void get_pet(int id) {

        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .when().get("https://petstore.swagger.io/v2/pet/"+id+"");

        response.prettyPrint();

    }

    @Step
    public int get_status_code(){

        int respcode = response.getStatusCode();
        return respcode;
    }

    @Step
    public String receive_message(){

        ResponseBody body = response.body();
        body.prettyPrint();
        return body.asString();
    }


}
