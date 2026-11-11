/*package utils;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
public class ScreenshotUtil {

    public static void captureScreenshot(
            WebDriver driver,
            String screenshotName)
            throws IOException {

        TakesScreenshot ts =
                (TakesScreenshot) driver;

        File source =
                ts.getScreenshotAs(OutputType.FILE);

        File destination =
                new File("screenshots/"
                        + screenshotName
                        + ".png");

        FileUtils.copyFile(source, destination);

        System.out.println(
                "Screenshot saved: "
                        + destination.getAbsolutePath());
    }
}*/
package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(
            WebDriver driver,
            String scenarioName) {

        String timeStamp =
                new SimpleDateFormat("yyyyMMdd_HHmmss")
                        .format(new Date());

        String filePath =
                "screenshots/"
                        + scenarioName.replaceAll(" ", "_")
                        + "_"
                        + timeStamp
                        + ".png";

        try {

            File srcFile =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);

            File destFile =
                    new File(filePath);

            FileUtils.copyFile(srcFile, destFile);

            System.out.println(
                    "Screenshot saved: "
                            + destFile.getAbsolutePath()
            );

        } catch (IOException e) {

            System.out.println(
                    "Failed to capture screenshot"
            );

            e.printStackTrace();
        }

        return filePath;
    }
}

