package com.bibit.base;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.bibit.utils.ReportUtility;

public class BaseApiTest {
    @BeforeClass
    public static void beforeAll() {
        ReportUtility.setup();
    }

    @AfterClass
    public static void afterAll() {
        ReportUtility.tearDown();
    }
}
