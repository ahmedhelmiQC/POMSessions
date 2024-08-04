package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtili {

    private final static String Test_Data_PATH = "src/test/resources/TestData/";

    //ToDo: reading data from json file
    public static String getJsonData(String filename , String field) throws FileNotFoundException  // file + field
    {
        FileReader Reader = new FileReader(Test_Data_PATH + filename + ".json");
        // src/test/resources/TestData/validloginData.json
        JsonElement jsonElement = JsonParser.parseReader(Reader);
        return jsonElement.getAsJsonObject().get(field).getAsString();

    }


    //ToDo: reading data from property file
    public static String getpropertyvalue(String filelname ,String key) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(Test_Data_PATH+filelname+".properties"));
        return properties.getProperty(key);
    }
}
