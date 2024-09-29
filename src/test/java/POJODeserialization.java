import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.Serializable;

public class POJODeserialization implements Serializable {

    public static void main(String[] args) {

            RestAssured.baseURI ="https://jsonplaceholder.typicode.com/todos/1";
            RequestSpecification request = RestAssured.given();
            Response response = request.get("");
            ResponseBody body = response.getBody();


            // Deserialize the Response body into JSONSuccessResponse
            // We can simply use body.as(POJO.class) to map the response to our POJO class

            System.out.println(body.asString());

            //Important thing is to note is we need jackson-databind library to map response body to our POJO class
            JSONSuccessResponse responseBody = body.as(JSONSuccessResponse.class);


            // Use the JSONSuccessResponseclass instance to Assert the values of Response.
            System.out.println("user id is: " + responseBody.userId);
            Assert.assertEquals( responseBody.userId,1);
            Assert.assertEquals( responseBody.title,"delectus aut autem");
    }
}
