package utils;

import core.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.nio.file.Files;

public class ScreenshotUtils {

    public static String captureScreenshot(
            String screenshotName
    ) {

        try {

            File source =  ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);

            String destination =   "target/screenshots/" + screenshotName + ".png";

            Files.copy(
                    source.toPath(),
                    new File(destination).toPath()
            );

            return destination;

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to capture screenshot",
                    e
            );
        }
    }
}