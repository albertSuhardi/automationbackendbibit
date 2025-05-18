package com.bibit.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.bibit.base.BaseApiTest;
import com.bibit.utils.ReportUtility;
import io.restassured.response.Response;

public class BibitPostTest extends BaseApiTest{

    @Test
    public void bibitPost(){
        ReportUtility.startTest("Post Bibit");
        String jsonBody = "{ \"title\" : \"Learn API Testing\", \"body\" : \"Practicing API testing with JSONPlaceholder\", \"userId\" : 101 }";
        Response response = ApiBibit.bibitJsonPost(jsonBody);

        ReportUtility.info("Status Code: " + response.getStatusCode());
        ReportUtility.info("Response Body: " + response.getBody().asString());

        // Assertion dan Logging
        try {
            assertEquals(201, response.getStatusCode());
            assertEquals("Learn API Testing", response.jsonPath().getString("title"));
            assertEquals("Practicing API testing with JSONPlaceholder", response.jsonPath().getString("body"));
            assertEquals(101, response.jsonPath().getInt("userId"));

            ReportUtility.pass("Passed");
        } catch (AssertionError e) {
            ReportUtility.fail("Test Case Failed: " + e.getMessage());
            throw e;
        }
    }
}
