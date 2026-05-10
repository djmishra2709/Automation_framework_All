package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "@target/failed_scenarios.txt",
        glue = {
                "stepdefinitions",
                "hooks"
        },
        plugin = {
                "pretty",
                "html:target/rerun-cucumber-report.html"
        },
        monochrome = true
)
public class RerunFailedTestRunner
        extends AbstractTestNGCucumberTests {
}