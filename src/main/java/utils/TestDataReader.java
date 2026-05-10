package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class TestDataReader {

    private static JsonNode testData;

    static {

        try
        {
                 ObjectMapper mapper = new ObjectMapper();
                 testData = mapper.readTree(
                    new File("src/test/resources/testdata/testdata.json" ));
        }

        catch (Exception e)
        {
            throw new RuntimeException( "Failed to load test data file",  e  );
        }
    }

    public static String get(String key) {

        return testData.get(key).asText();
    }
}