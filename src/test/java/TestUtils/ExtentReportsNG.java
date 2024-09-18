package TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
    static ExtentReports extent;

    public static ExtentReports getreportr()
    {
        String path = System.getProperty("user.dir")+"//reports//report.html";;

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Appium Automation Report");
        reporter.config().setDocumentTitle("Appium Automation Results");

     extent = new ExtentReports();
    extent.attachReporter(reporter);
    extent.setSystemInfo("Tester", "Prajwal");
    return extent;



    }



}
