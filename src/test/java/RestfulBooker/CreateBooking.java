// This Class file represent Create Bookings

package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateBooking {

    public static void main(String[] args) {
        // Build Request
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification = requestSpecification.log().all();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.body("{\n" +
                "    \"firstname\" : \"Vinod\",\n" +
                "    \"lastname\" : \"Gowda\",\n" +
                "    \"totalprice\" : 1123,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}");
        requestSpecification.contentType(ContentType.JSON);

        // Hit Request and get the response

        Response response = requestSpecification.post();

        // Validate the response

        ValidatableResponse validateResponse = response.then();
        validateResponse.statusCode(200);


        // Refactoring the above code to simplifise the steps

        // Build the request
        RestAssured
                .given()
                    .log()
                    .all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking")
                    .body("{\n" +
                            "    \"firstname\" : \"Vinod\",\n" +
                            "    \"lastname\" : \"Gowda\",\n" +
                            "    \"totalprice\" : 1123,\n" +
                            "    \"depositpaid\" : false,\n" +
                            "    \"bookingdates\" : {\n" +
                            "        \"checkin\" : \"2024-01-01\",\n" +
                            "        \"checkout\" : \"2024-01-01\"\n" +
                            "    },\n" +
                            "    \"additionalneeds\" : \"Lunch\"\n" +
                            "}")
                    .contentType(ContentType.JSON)
                // Hit the request and get the response
                .when()
                    .post()
                .then()
                // validate the response
                    .log()
                    .all()
                    .statusCode(200);
    }

}
