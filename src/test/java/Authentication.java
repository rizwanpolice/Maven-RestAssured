import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class Authentication {

    public static void main(String[] args) {

        RestAssured.baseURI ="https://demoqa.com/Account/v1";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", "test_rest");
        requestParams.put("password", "Testrest@123");
        request.body(requestParams.toString());

        // This is for oauth2 authentication token
        Response response = request.auth().oauth2("auth token").post("/User");

        // This is for basic authentication token
        Response response1 = request.auth().basic("username","password:").post("/User");

    }
}
