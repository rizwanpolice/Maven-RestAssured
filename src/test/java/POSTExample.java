import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class POSTExample {
    public static void main(String[] args) {

        RestAssured.baseURI ="https://demoqa.com/Account/v1";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", "test_rest");
        requestParams.put("password", "Testrest@123");
        request.body(requestParams.toString());
        Response response = request.post("/User");
        ResponseBody body = response.getBody();
        System.out.println(response.getStatusLine());

        System.out.println(body.asString());
    }
}
