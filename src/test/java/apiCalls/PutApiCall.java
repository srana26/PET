package apiCalls;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import net.thucydides.core.annotations.Step;

public class PutApiCall {


    private Response response;

    @Step
    public void update_pet(int id, String name) {

        response = RestAssured.given().body("{" +
                "        \"id\": "+ id +"," +
                "        \"category\": {" +
                "        \"id\": 0," +
                "        \"name\": \"string\" " +
                "}," +
                "   \"name\": \""+ name +"\"," +
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
                .when().put("https://petstore.swagger.io/v2/pet");

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
