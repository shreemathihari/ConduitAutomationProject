package utils;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(
                            "target/ExtentReport.html");

            reporter.config().setReportName(
                    "Conduit Automation Report");

            reporter.config().setDocumentTitle(
                    "Automation Test Results");

            extent = new ExtentReports();

            extent.attachReporter(reporter);
        }

        return extent;
    }
}
