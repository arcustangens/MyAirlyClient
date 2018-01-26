import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;

public class Requester {
    private String data="";
    private String address="";
    private String APIKey="";

    public Requester(String address, String APIKey){
        this.address=address;
        this.APIKey=APIKey;
        try {
            updateData();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public void updateData() throws Exception{
        String updatedData="", tmp;
        BufferedReader reader;
        URL adr = new URL(address);
        HttpURLConnection connection = (HttpURLConnection) adr.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("apikey", APIKey);
        reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        tmp=reader.readLine();
        while (tmp != null) {
            updatedData+=tmp;
            tmp=reader.readLine();
        }
        reader.close();
        this.data=updatedData;
    }

    public Data extractJson(){
        Gson gson = new Gson();
        return gson.fromJson(this.data, Data.class);
    }

    @Override
    public String toString(){
        return data;
    }
}
