package hooks;

import com.aventstack.extentreports.ExtentTest;
import core.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ConfigReader;
import utils.ExtentManager;
import utils.ReportManager;
import utils.ScreenshotUtils;

public class Hooks {

    private static final Logger logger =
            LogManager.getLogger(Hooks.class);

    // Thread-safe feature node
    private static final ThreadLocal<ExtentTest>
            featureNode = new ThreadLocal<>();

    @Before
    public void setUp(Scenario scenario) {

        logger.info(
                "========== TEST STARTED: {} ==========",
                scenario.getName()
        );

        // Initialize browser
        DriverManager.initDriver();
        // Launch application
        DriverManager.getDriver().get(ConfigReader.get("url")
        );

        /*
         * Extract feature file name
         * Example:
         * smoke.feature
         */
        String featureName =
                scenario.getUri()
                        .toString()
                        .substring(
                                scenario.getUri()
                                        .toString()
                                        .lastIndexOf("/") + 1
                        );

        // Create Feature level node
        ExtentTest feature =
                ReportManager.getInstance()
                        .createTest(featureName);

        featureNode.set(feature);

        // Create Scenario level node
        ExtentTest scenarioNode =
                featureNode.get()
                        .createNode(
                                scenario.getName()
                        );

        // Store in ThreadLocal
        ExtentManager.setTest(scenarioNode);

        ExtentManager.getTest().info(
                "Browser launched successfully"
        );
    }

    @After
    public void tearDown(Scenario scenario) {

        try {

            if (scenario.isFailed()) {

                logger.error(
                        "========== TEST FAILED: {} ==========",
                        scenario.getName()
                );

                String screenshotPath =
                        ScreenshotUtils.captureScreenshot(
                                scenario.getName()
                                        .replaceAll(" ", "_")
                        );

                ExtentManager.getTest().fail(
                        "Scenario Failed"
                );

                ExtentManager.getTest()
                        .addScreenCaptureFromPath(
                                screenshotPath
                        );

            } else {

                logger.info(
                        "========== TEST PASSED: {} ==========",
                        scenario.getName()
                );

                ExtentManager.getTest().pass(
                        "Scenario Passed"
                );
            }

        } catch (Exception e) {

            logger.error(
                    "Error while updating report",
                    e
            );

        } finally {

            // Flush Extent report
            ReportManager
                    .getInstance()
                    .flush();

            // Quit browser
            DriverManager.quitDriver();

            logger.info(
                    "========== DRIVER CLOSED =========="
            );
        }
    }
}