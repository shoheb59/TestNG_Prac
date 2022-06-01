import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public void saveData(String email, String password) throws IOException, ParseException {
        String fileName = "./src/test/resources/customer.json";
        JSONParser jsonParser = new JSONParser();
        Object object = jsonParser.parse(new FileReader(fileName));
        JSONObject customerObject = new JSONObject();

        customerObject.put("email",email);
        customerObject.put("password", password );

        JSONArray jsonArray = (JSONArray) object;
        jsonArray.add(customerObject);

        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();

    }

}
