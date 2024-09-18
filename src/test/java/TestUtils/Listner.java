package TestUtils;

import Utils.Appiumutils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listner extends Appiumutils implements ITestListener {
    AppiumDriver driver;
    ExtentReports extent = ExtentReportsNG.getreportr();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
        test.log(Status.PASS, "Test  has passed: ");
    }

    @Override
//    public void onTestFailure(ITestResult result) {
//        System.out.println("Test failed: " + result.getName());
//        test.log(Status.FAIL, "Test has failed: " + result.getThrowable());
//        try {
//            driver=(AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            throw new RuntimeException(e);
//
//        }
//
//
//        try {
//            test.addScreenCaptureFromPath(getScreenshotpath(result.getMethod().getMethodName(),driver),result.getMethod().getMethodName());// throwable will give the error message
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void onTestFailure(ITestResult result) {
//        System.out.println("Test failed: " + result.getName());
//        test.log(Status.FAIL, "Test has failed: " + result.getThrowable());
//
//        try {
//            driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            // Add screenshot to the report using the relative path returned by getScreenshotpath()
//            String screenshotPath = getScreenshotpath(result.getMethod().getMethodName(), driver);
//            test.addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

            System.out.println("Test failed: " + result.getName());
            test.log(Status.FAIL, "Test has failed: " + result.getThrowable());

            try {
                // Retrieve driver using reflection
                driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // Log more information if reflection fails
                System.out.println("Error accessing driver field: " + e.getMessage());
                throw new RuntimeException(e);
            }

            // Ensure driver is not null before taking screenshot
            if (driver != null) {
                try {
                    // Add screenshot to the report using the relative path returned by getScreenshotpath()
                    String screenshotPath = getScreenshotpath(result.getMethod().getMethodName(), driver);
                    test.addScreenCaptureFromPath(screenshotPath, result.getMethod().getMethodName());
                } catch (IOException e) {
                    // Log if screenshot capture fails
                    System.out.println("Error capturing screenshot: " + e.getMessage());
                    throw new RuntimeException(e);
                }
            } else {
                // Log and handle if driver is null
                test.log(Status.FAIL, "Driver is null, unable to capture screenshot.");
                System.out.println("Driver is null, cannot capture screenshot.");
            }
        }

        @Override
        public void onTestSkipped (ITestResult result){
            System.out.println("Test skipped: " + result.getName());
        }
        @Override
        public void onTestFailedButWithinSuccessPercentage (ITestResult result){
            // TODO Auto-generated method stub
        }
        @Override
        public void onStart (ITestContext context){
            // TODO Auto-generated method stub
        }
        @Override
        public void onFinish (ITestContext context){

        extent.flush();
        }


    }


