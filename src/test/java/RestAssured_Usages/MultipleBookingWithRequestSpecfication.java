package RestAssured_Usages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MultipleBookingWithRequestSpecfication {

    RequestSpecification requestSpecification;

    @BeforeClass
    public void setUpRequestSpec()
    {
        requestSpecification = RestAssured
                .given()
                    .log()
                    .all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .contentType(ContentType.JSON);
    }



    @Test
    public void createBookings()
    {
        RestAssured
                .given()
                    .spec(requestSpecification)
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
                .when()
                    .post()
                .then()
                    .log()
                    .all()
                    .assertThat()
                    .statusCode(200);
    }

    @Test
    public void updateBookings()
    {
        RestAssured
                .given()
                    .spec(requestSpecification)
                    .basePath("booking/1")
                    .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .body("{\n" +
                            "    \"firstname\" : \"Vinod\",\n" +
                            "    \"lastname\" : \"Vinom\",\n" +
                            "    \"totalprice\" : 1123,\n" +
                            "    \"depositpaid\" : false,\n" +
                            "    \"bookingdates\" : {\n" +
                            "        \"checkin\" : \"2024-01-01\",\n" +
                            "        \"checkout\" : \"2024-01-01\"\n" +
                            "    },\n" +
                            "    \"additionalneeds\" : \"Lunch\"\n" +
                            "}")
                .when()
                    .put()
                .then()
                    .log()
                    .all()
                    .statusCode(200);
    }


}
