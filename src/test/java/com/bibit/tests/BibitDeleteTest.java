package com.bibit.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.bibit.base.BaseApiTest;
import com.bibit.utils.ReportUtility;
import io.restassured.response.Response;

public class BibitDeleteTest extends BaseApiTest{

    @Test
    public void bibitDelete(){
        ReportUtility.startTest("Delete Bibit");
        String id = "100";
        Response response = ApiBibit.bibitDeleteQueryParams(id);
        
        ReportUtility.info("Status Code: " + response.getStatusCode());

        // Assertion dan Logging
        try {
            assertEquals(200, response.getStatusCode());

            ReportUtility.pass("Passed");
        } catch (AssertionError e) {
            ReportUtility.fail("Test Case Failed: " + e.getMessage());
            throw e;
        }
    }
}
