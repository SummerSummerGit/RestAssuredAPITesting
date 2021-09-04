import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class TC005_LIST_SINGLE_RESOURCE_GET_Request {

    @Test
    void getweatherDetails(){

         //Specify the base URI
        RestAssured.baseURI="https://reqres.in";

        //Request the Object
        RequestSpecification httprequest=RestAssured.given();

        //Response the Object
        Response response=httprequest.request(Method.GET,"/api/unknown/2");

        //Print the response in the console window
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);


    }
}
