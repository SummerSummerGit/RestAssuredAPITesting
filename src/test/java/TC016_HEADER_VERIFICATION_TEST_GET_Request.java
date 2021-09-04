import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC016_HEADER_VERIFICATION_TEST_GET_Request {

    @Test
    void headerVerificationTest()
    {

        //Specify base URI
        RestAssured.baseURI="httpbin.org/";

        //Request object
        RequestSpecification httpRequest=RestAssured.given();

        //Response object
        Response response=httpRequest.request(Method.GET,"https://httpbin.org/response-headers?freeform=");

        //print response in console window
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //validating headers
        String contentType=response.header("Content-Type");// capture details of Content-Type header
        System.out.println("Content Type is:"+contentType);
        Assert.assertEquals(contentType, "application/json");

        String contentLength=response.header("Content-Length");// capture details of Content-Length header
        System.out.println("Content Length is:"+contentLength);
        Assert.assertEquals(contentLength, "87");

        String connection=response.header("Connection");// capture details of Connection header
        System.out.println("Connection is:"+connection);
        Assert.assertEquals(connection, "keep-alive");

        String server=response.header("Server");// capture details of Server  header
        System.out.println("Server is:"+server);
        Assert.assertEquals(server, "gunicorn/19.9.0");

    }

}
