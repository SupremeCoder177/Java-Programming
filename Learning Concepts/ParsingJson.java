import com.google.gson.*;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ParsingJson {
    public static void main(String[] args) throws Exception{

        String data = new String(Files.readAllBytes(Paths.get("Learning Concepts/data.json")));
        JsonObject obj = JsonParser.parseString(data).getAsJsonObject();

        System.out.println(obj.get("0").getAsJsonArray().get(1));
    }
}
