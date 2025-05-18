package com.bibit.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtility {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static void setup() {
        if (extent == null) {
            String reportPath = "target/ExtentReport.html";
            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            extent = new ExtentReports();
            extent.attachReporter(spark);
            System.out.println("[LOG] Report setup at: " + reportPath);
        }
    }

    public static void startTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void info(String message) {
        if (test != null) test.info(message);
    }

    public static void pass(String message) {
        if (test != null) test.pass(message);
    }

    public static void fail(String message) {
        if (test != null) test.fail(message);
    }

    public static void tearDown() {
        if (extent != null) {
            extent.flush();
            System.out.println("[LOG] Report flushed!");
        }
    }
}
