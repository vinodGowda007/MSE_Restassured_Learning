package RestfulBooker;

import io.restassured.RestAssured;

import java.util.HashMap;
import java.util.Map;

public class PathParams {

    public static void main(String[] args) {

        // Method 1
        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("{bookingPath}/{bookingid}")
                .pathParam("bookingPath","booking")
                .pathParam("bookingid",1)
                .log()
                .all()
                .when()
                .get()        // Hit the request and get the response
                .then()
                .log()
                .all()
                .statusCode(200); // Validate the response

        //method 2
        RestAssured
                .given()
                    .pathParam("bookingPath","booking")
                    .pathParam("bookingid",1)
                    .log()
                    .all()
                .when()
                    .get("https://restful-booker.herokuapp.com/{bookingPath}/{bookingid}")        // Hit the request and get the response
                .then()
                .log()
                .all()
                .statusCode(200); // Validate the response

        // Method 3

        RestAssured
                .given()
                    .log()
                    .all()
                .when()
                    .get("https://restful-booker.herokuapp.com/{bookingPath}/{bookingid}","booking",1)        // Hit the request and get the response
                .then()
                    .log()
                    .all()
                    .statusCode(200); // Validate the response



    // Method 4
    Map<String,Object> paths = new HashMap<String,Object>();
    paths.put("bookingPath","booking");
    paths.put("bookingid",1);

        RestAssured
                .given()
                    .log()
                    .all()
                    .pathParams(paths)
                .when()
                    .get("https://restful-booker.herokuapp.com/{bookingPath}/{bookingid}")        // Hit the request and get the response
                .then()
                    .log()
                    .all()
                    .statusCode(200); // Validate the response



    }


}
