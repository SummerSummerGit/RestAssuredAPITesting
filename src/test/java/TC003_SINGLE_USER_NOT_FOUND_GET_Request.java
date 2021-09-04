import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC003_SINGLE_USER_NOT_FOUND_GET_Request {

    @Test
    void getweatherDetails(){

         //Specify the base URI
        RestAssured.baseURI="https://reqres.in";

        //Request the Object
        RequestSpecification httprequest=RestAssured.given();

        //Response the Object
        Response response=httprequest.request(Method.GET,"/api/users/23");

        //Print the response in the console window
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //Status code validation
        int statusCode=response.getStatusCode();
        System.out.println("Status Code is:" +statusCode);
        Assert.assertEquals(statusCode, 404);

        //status line verification
        String statusLine=response.getStatusLine();
        System.out.println("Status line is:"+statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 404 Not Found");

    }
}
