import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;

public class dataMan {
    
    public static void main(String []args){
        manipulateData();
    }

    public static void manipulateData(){
        try {
            // OpenSky Network API URL
            String urlString = "https://opensky-network.org/api/states/all";
            URL url = new URL(urlString);

            // Create HTTP connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Read response
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            List<String> dataList = new ArrayList<>();
            while ((inputLine = in.readLine()) != null) {
            dataList.add(inputLine);
            }
            in.close();

            ArrayList<String> data = new ArrayList<>();

            for(String datum : dataList){
                data.add(datum);
            }

            BufferedWriter writer;
            String path = "C:\\Users\\kaan\\Desktop\\481test\\CyberSavants\\api\\data\\flights.json";

            for(String datum : data){
                writer = new BufferedWriter(new FileWriter(path));
                writer.write(datum);

                writer.close();
            }
            

            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
