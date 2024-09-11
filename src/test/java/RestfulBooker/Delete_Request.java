// This Class file says how to delete a booking from the Restful Booker API

package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Delete_Request {

    public static void main(String[] args) {
        // Build the request

        RestAssured
                .given()
                    .log()
                    .all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/{bookingId}")
                    .pathParam("bookingId",1)
                    .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                    .delete()
                .then()
                    .log()
                    .all()
                    .assertThat()
                    .statusCode(201);





        // Hit the Request / Send the request

        // Validate the response


    }
}
