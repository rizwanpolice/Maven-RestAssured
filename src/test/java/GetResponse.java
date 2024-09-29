import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class GetResponse {
    public static void main(String[] args) {
        //Path parameter
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        // Get the RequestSpecification of the request to be sent to the server
        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.get("");

        // ******************************************************************************
        // Getting status code
        int statusCode = response.getStatusCode();

        Assert.assertEquals( statusCode, 200 ,
                "Correct status code returned");

        // ******************************************************************************
        // Getting status line
        String statusLine = response.getStatusLine();

        // ******************************************************************************
        // Getting response headers

        // Get all the headers and then iterate over allHeaders to print each header
        Headers allHeaders = response.headers();
        // Iterate over all the Headers
        for(Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }

        String serverType = response.header("Server");

        // ******************************************************************************
        // Getting response body

        ResponseBody body = response.getBody();

        // By using the ResponseBody.asString() method, we can convert the  body
        // into the string representation.
        System.out.println("Response Body is: " + body.asString());


    }
}
