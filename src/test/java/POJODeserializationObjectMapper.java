import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class POJODeserializationObjectMapper {

    public static void main(String[] args) throws JsonProcessingException {

        RestAssured.baseURI ="https://jsonplaceholder.typicode.com/todos/1";
        RequestSpecification request = RestAssured.given();
        Response response = request.get("");
        ResponseBody body = response.getBody();


        // Deserialize the Response body into JSONSuccessResponse
        // We can simply use body.as(POJO.class) to map the response to our POJO class

        System.out.println(body.asString());

        //Important thing is to note is we need jackson-databind library to map response body to our POJO class
        ObjectMapper mapper = new ObjectMapper();
        JSONSuccessResponse response1 =  mapper.readValue(body.asString(), JSONSuccessResponse.class);

        // Use the JSONSuccessResponseclass instance to Assert the values of Response.
        System.out.println("user id is: " + response1.userId);
        Assert.assertEquals( response1.userId,1);
        Assert.assertEquals( response1.title,"delectus aut autem");
    }
}
