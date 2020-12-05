import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class LoginTest {

    private static final String path = "/api/v1/authentication/login";
    Map<String, String> credentials = new HashMap<>();

    @BeforeClass
    void precodition(){
        baseURI="http://0.0.0.0";
        port=8080;
    }

    @Test
    void Login_successful(){
        credentials.put("email","admin@ekmechanes.com");
        credentials.put("password","Password!!!!!");

        given().contentType(ContentType.JSON)
                .body(credentials)
                .when().post(path)
                .then().statusCode(200);
    }

    @Test
    void Login_Invalid_Username(){
        credentials.put("email","not@valid.username");
        credentials.put("password","Password!!!!!");

        given().contentType(ContentType.JSON)
                .body(credentials)
                .when().post(path)
                .then().statusCode(400)
                .body("error.messages", equalTo("Invalid username-password combination."));
    }

    @Test
    void Login_Invalid_Password(){
        credentials.put("email","admin@ekmechanes.com");
        credentials.put("password","not_valid_password");

        given().contentType(ContentType.JSON)
                .body(credentials)
                .when().post(path)
                .then().statusCode(400)
                .body("error.messages", equalTo("Invalid username-password combination."));
    }

    @Test
    void Login_Empty_Username(){
        credentials.put("email","");

        given().contentType(ContentType.JSON)
                .body(credentials)
                .when().post(path)
                .then().statusCode(400)
                .body("error.messages", equalTo("Invalid username-password combination."));
    }

    @Test
    void Login_Empty_Password(){
        credentials.put("password","");

        given().contentType(ContentType.JSON)
                .body(credentials)
                .when().post(path)
                .then().statusCode(400)
                .body("error.messages", equalTo("Invalid username-password combination."));
    }
}
