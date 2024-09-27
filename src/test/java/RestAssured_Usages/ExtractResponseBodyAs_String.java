package RestAssured_Usages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ExtractResponseBodyAs_String {

    public static void main(String[] args) {

        String responseBody = RestAssured
                .given()
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
                .when()
                    .post()
                .then()
                    .extract()
                    .asPrettyString();


        System.out.println(responseBody);

    }


}
