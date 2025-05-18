package com.bibit.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ApiBibit {
    public static Response bibitJsonPost(String jsonBody){
        return given()
            .contentType(ContentType.JSON)
            .body(jsonBody)
            .when()
            .post("https://jsonplaceholder.typicode.com/posts");
    }

    public static Response bibitGetQueryParams(){
        return given()
            .when()
            .get("https://jsonplaceholder.typicode.com/posts/");
    }

    public static Response bibitDeleteQueryParams(String id){
        return given()
            .when()
            .delete("https://jsonplaceholder.typicode.com/posts/"+id);
    }

    public static Response bibitJsonPut(String id, String jsonBody){
        return given()
            .contentType(ContentType.JSON)
            .body(jsonBody)
            .when()
            .put("https://jsonplaceholder.typicode.com/posts/"+id);
    }
}
