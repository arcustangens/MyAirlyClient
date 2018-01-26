public class Client {
    public static void main(String args[]){
        ArgumentParser parser = new ArgumentParser(args);
        try{
            parser.parseArgs();
            String address;
            if(parser.sensorID!=null) address = "https://airapi.airly.eu/v1/sensor/measurements?sensorId="+parser.sensorID;
            else address = "https://airapi.airly.eu/v1/mapPoint/measurements?latitude="+parser.latitude+"&longitude="+parser.longitude;
            String APIKey = parser.APIKey;
            Requester req = new Requester(address, APIKey);
            //System.out.println(req.toString());
            Data data = req.extractJson();
            if(parser.history) {
                System.out.println(data.toString());
            }
            else {
                System.out.println(data.toStringWithoutHistory());
            }
        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
