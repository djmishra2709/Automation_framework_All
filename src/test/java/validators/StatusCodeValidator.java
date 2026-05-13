package validators;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import utils.LoggerUtils;

public class StatusCodeValidator {

    private static final Logger logger =
            LoggerUtils.getLogger(StatusCodeValidator.class);
    public static void validateStatusCode(
            int actualStatusCode,
            int expectedStatusCode
    ) {

        Assert.assertEquals(
                actualStatusCode,
                expectedStatusCode,
                "Status code validation failed"
        );
        logger.info("Status Code validation PASSED");
    }
}