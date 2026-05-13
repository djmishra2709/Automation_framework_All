package validators;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.apache.logging.log4j.Logger;
import utils.LoggerUtils;

import static org.hamcrest.MatcherAssert.assertThat;

public class SchemaValidator {
    private static final Logger logger =
            LoggerUtils.getLogger(ResponseValidator.class);
    public static void validateSchema(
            Response response,
            String schemaPath
    ) {

        assertThat(
                response.asString(),
                JsonSchemaValidator.matchesJsonSchemaInClasspath(schemaPath)
        );
        logger.info("Schema validation PASSED");
    }
}