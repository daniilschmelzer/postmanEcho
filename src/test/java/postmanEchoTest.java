import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class postmanEchoTest {
    @Test
    public void echoTest() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")
                .when()
                .post("/post")
                .then()
                .statusCode(200).log().ifValidationFails()
                .body("data", is("some"));
    }
}
