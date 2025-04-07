package Utils;

import com.jayway.jsonpath.JsonPath;
import org.json.JSONObject;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonUtils {
    private static final String JSON_PATH = "src/test/resources/";
    String JsonReader;
    String JsonFilename;

    public JsonUtils(String jsonFilename) {
        this.JsonFilename = jsonFilename;

    try {
        JSONObject data = (JSONObject) new org.json.simple.parser.JSONParser().parse(new FileReader(JSON_PATH) + jsonFilename + ".json");
        JsonReader = data.toString();
    } catch (Exception e) {

        LogsUtils.Error( "Error in reading JSON file "+ e.getMessage());
    }}

    public  String getJasonData(String jsonpath){

        String testData = " ";

        try {

             testData = JsonPath.read(Files.readString(Paths.get(JSON_PATH + JsonFilename + ".json")), jsonpath);
        } catch (Exception e) {
            LogsUtils.Error( "Error in reading JSON file"+ e.getMessage());
        }
        return testData;

    }
}

