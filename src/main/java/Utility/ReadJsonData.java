package Utility;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Random;

public class ReadJsonData {
    String n;
    String j;
    String k;
    Random random;
    private static String[] firstNames = {"John", "Emma", "Olivia", "Ava", "Isabella", "Sophia", "Robin"};
    private static String[] lastNames = {"Doe", "Smith", "Johnson", "Williams", "Jones", "Brown", "Hood"};

    String path=System.getProperty("user.dir")+ File.separator +"TestData"+File.separator + "Data.json";

    public String ReadJSONData(String keyword) throws IOException, org.json.simple.parser.ParseException {

        Reader reader = new FileReader(path);
        JSONParser parser = new JSONParser();
        JSONArray jsonArr = (JSONArray) parser.parse(reader);
        for (Object obj : jsonArr) {

            JSONObject jo = (JSONObject) obj;
            j = (String) jo.get(keyword);
        }
        return j;
    }


    public String getEmailAddress() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public String Generate_First_Name(){
        random=new Random();
        String FirstName = firstNames[random.nextInt(firstNames.length)];
        System.out.println("Random name: " + FirstName);
        return FirstName;
    }

    public String Generate_Last_Name(){
        random=new Random();
        String LastName = firstNames[random.nextInt(lastNames.length)];
        System.out.println("Random name: " + LastName);
        return LastName;
    }


}
