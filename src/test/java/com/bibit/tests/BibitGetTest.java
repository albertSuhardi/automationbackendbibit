package com.bibit.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.bibit.base.BaseApiTest;
import com.bibit.utils.ReportUtility;

import io.restassured.response.Response;

public class BibitGetTest extends BaseApiTest{
    @Test
    public void bibitGet(){
        ReportUtility.startTest("Get Bibit");
        Response response = ApiBibit.bibitGetQueryParams();

        ReportUtility.info("Status Code: " + response.getStatusCode());
        ReportUtility.info("Response Body: " + response.getBody().asString());
        
        try {
            assertEquals(200, response.getStatusCode());
            List<Map<String, Object>> bibits = response.jsonPath().getList("$");
            int index = 0;
            while (index < bibits.size()){
                Object id = bibits.get(index).get("id");
                assertNotNull(id);
                index++;
            }

            ReportUtility.pass("Passed");
        } catch (AssertionError e) {
            ReportUtility.fail("Test Case Failed: " + e.getMessage());
            throw e;
        }
    }
}
