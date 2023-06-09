package api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.Map;

public class ApiCoreRequests {
    @Step("Make POST-request")
    public Response makePostRequest(String url, Map<String, String> data) {
        return RestAssured.given()
                .header("Content-type", "Application/json")
                .body(data)
                .post(url)
                .andReturn();
    }

    @Step("Make GET-Request")
    public ValidatableResponse makeGetRequest(String url, String token) {
        return RestAssured.given()
                .header("Content-type", "Application/json")
                .and()
                .header("Authorization", token)
                .get(url)
                .then().log().all();
    }

    @Step("Make DELETE-request")
    public Response makeDeleteRequest(String url, String token) {
        return RestAssured.given()
                .header("Content-type", "Application/json")
                .and()
                .header("Authorization", token)
                .delete(url)
                .andReturn();
    }
}

