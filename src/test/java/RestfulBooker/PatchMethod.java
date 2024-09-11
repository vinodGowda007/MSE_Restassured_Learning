package RestfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PatchMethod {

    public static void main(String[] args) {

        RestAssured
                .given()
                    .log()
                    .all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("{basePath}/{id}")
                    .pathParam("basePath","booking")
                    .pathParam("id",1)
                    .body("{\n" +
                            "    \"firstname\" : \"Vinod\",\n" +
                            "    \"lastname\" : \"Gowda\"\n" +
                            "}")
                    .contentType(ContentType.JSON)
                    .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                    .patch()
                .then()
                    .log()
                    .all()
                    .assertThat()
                    .statusCode(200);
    }
}
