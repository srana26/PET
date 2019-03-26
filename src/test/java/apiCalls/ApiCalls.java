package apiCalls;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.thucydides.core.annotations.Step;

public class ApiCalls {


    private Response response;

    @Step
    public void add_pet(int id, String name) {

        response = RestAssured.given().body("{" +
                "        \"id\": "+ id +"," +
                "        \"category\": {" +
                "        \"id\": 0," +
                "        \"name\": \""+ name +"\" " +
                "}," +
                "   \"name\": \"doggie\"," +
                "   \"photoUrls\": [" +
                "   \"string\"" +
                "   ]," +
                "   \"tags\": [" +
                "{" +
                "        \"id\": 0," +
                "        \"name\": \"string\"" +
                "}" +
                "]," +
                "        \"status\": \"available\"" +
                "}")
                .header("Content-Type", "application/json")
                .when().post("https://petstore.swagger.io/v2/pet");

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
        return body.asString();
    }

}
