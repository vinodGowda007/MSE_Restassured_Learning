package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetBooking {

    public static void main(String[] args) {

        // Build a Request
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/{id}");
        requestSpecification.pathParam("id",100);

        // Hit the request and get the response
        Response response = requestSpecification.get();

        // Validate the response
        ValidatableResponse validatableResponse =  response.then().log().all();
        validatableResponse.statusCode(200);


        // Refactoring the above code to simplify the steps

        // BDD Format presentation of code
        // given() - Precondition
        // when() - Performing action
        // then() - Validate the response



        // Build a Request
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/{id}")
                    .pathParam("id",110)
                    .log()
                    .all()
                .when()
                    .get()        // Hit the request and get the response
                .then()
                    .log()
                    .all()
                    .statusCode(200); // Validate the response
    }
}
