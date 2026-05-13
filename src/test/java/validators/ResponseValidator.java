package validators;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import utils.LoggerUtils;

public class ResponseValidator {
    private static final Logger logger =
            LoggerUtils.getLogger(ResponseValidator.class);
    public static void validateEquals(
            Object actual,
            Object expected,
            String message
    ) {

        Assert.assertEquals(
                actual,
                expected,
                message
        );
        logger.info("Validation PASSED");
    }

    public static void validateNotNull(
            Object actual,
            String message
    ) {

        Assert.assertNotNull(
                actual,
                message
        );
        logger.info("Validation PASSED");
    }

    public static void validateTrue(
            boolean condition,
            String message
    ) {

        Assert.assertTrue(
                condition,
                message
        );
        logger.info("Validation PASSED");
    }
}