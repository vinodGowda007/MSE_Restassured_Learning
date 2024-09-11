package RestfulBooker;

import io.restassured.RestAssured;

public class PutRequest {

    public static void main(String[] args) {
        RestAssured
                .given()
                    .log()
                    .all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/100")
                    .header("Content-Type","application/json")
                    .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .body("{\n" +
                            "    \"firstname\" : \"Vinod\",\n" +
                            "    \"lastname\" : \"T S\",\n" +
                            "    \"totalprice\" : 111,\n" +
                            "    \"depositpaid\" : true,\n" +
                            "    \"bookingdates\" : {\n" +
                            "        \"checkin\" : \"2018-01-01\",\n" +
                            "        \"checkout\" : \"2019-01-01\"\n" +
                            "    },\n" +
                            "    \"additionalneeds\" : \"Breakfast\"\n" +
                            "}")
                .when()// Hit the request and get the response
                    .put()
                .then()  // Validate the response
                    .log()
                    .all()
                    .assertThat()
                    .statusCode(200);


    }

}
