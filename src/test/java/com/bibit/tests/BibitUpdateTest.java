package com.bibit.tests;

import io.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.bibit.base.BaseApiTest;
import com.bibit.utils.ReportUtility;


public class BibitUpdateTest extends BaseApiTest{
    @Test
    public void bibitUpdate() {
        ReportUtility.startTest("Update Bibit");

        String jsonBody = "{ \"userId\": 99, \"title\": \"Updated Post Title\", \"body\": \"This is the updated body content.\" }";
        String id = "99";
        ReportUtility.info("Request Body: " + jsonBody);

        Response response = ApiBibit.bibitJsonPut(id, jsonBody);

        ReportUtility.info("Status Code: " + response.getStatusCode());
        ReportUtility.info("Response Body: " + response.getBody().asString());

        try {
            assertEquals(200, response.getStatusCode());
            assertEquals(id, response.jsonPath().get("userId").toString());
            assertEquals("Updated Post Title", response.jsonPath().getString("title"));
            assertEquals("This is the updated body content.", response.jsonPath().getString("body"));

            ReportUtility.pass("Passed");
        } catch (AssertionError e) {
            ReportUtility.fail("Test Case Failed: " + e.getMessage());
            throw e;
        }
    }
}
