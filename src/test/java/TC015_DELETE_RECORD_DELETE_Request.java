import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC015_DELETE_RECORD_DELETE_Request {

    @Test
    void CreateANewRecord()
    {

        //Specify base URI
        RestAssured.baseURI="https://reqres.in/";

        //Request object
        RequestSpecification httpRequest=RestAssured.given();


        //Request payload sending along with post request
        JSONObject requestParams=new JSONObject();


        requestParams.put("name", "batman");
        requestParams.put("job", "hero");


        httpRequest.header("Content-Type","application/json");

        httpRequest.body(requestParams.toJSONString()); // attach above data to the request

        //Response object
        Response response=httpRequest.request(Method.DELETE,"/api/users");


        //print response in console window

        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //status code validation
        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 204);

        //success code validation
        //String successCode=response.jsonPath().get("SuccessCode");
       //Assert.assertEquals(successCode, "OPERATION_SUCCESS");

    }


}

