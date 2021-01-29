package base;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BaseTest {

    protected String getData(String q) {
        // 1. json file ---> string
        String filePath = System.getProperty("user.dir") + "/data/testdata.json";
        String content = "";
        try{
            content = new String(Files.readAllBytes(Paths.get(filePath)));
        }
        catch (IOException ignore) {
            // do nothing
        }
        // 2. Jsonpath ---> extract
        String data = JsonPath.read(content, q);
        // 3. Return the extracted data
        return data;
    }
}
