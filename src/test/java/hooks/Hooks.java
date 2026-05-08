package hooks;

import core.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.Logger;
import utils.LoggerUtils;

public class Hooks {

    private static final Logger logger =
            LoggerUtils.getLogger(Hooks.class);

    @Before
    public void setUp() {
        logger.info("Initializing Driver...");
        DriverManager.initDriver();
    }

    @After
    public void tearDown() {
        logger.info("Closing Driver...");
        DriverManager.quitDriver();
    }
}