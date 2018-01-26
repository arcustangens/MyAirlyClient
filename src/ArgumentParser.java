public class ArgumentParser {
    private String args[];

    public String sensorID = null;
    public String APIKey = "b6cee0be3e674ed29535cc4b3d8ca798";
    public String latitude = null;
    public String longitude = null;
    public boolean history = false;

    private String sensorIDRegex = "--sensor-id=.*";
    private String APIKeyRegex = "--api-key=.*";
    private String latitudeRegex = "--latitude=.*";
    private String longitudeRegex = "--longitude=.*";
    private String historyRegex = "--history";

    public ArgumentParser(String args[]){
        this.args = args;
    }

    public void parseArgs() throws IllegalArgumentException{
        for(String arg : args){
            if(arg.matches(sensorIDRegex)){
                sensorID = arg.substring(sensorIDRegex.length()-2);
            }
            if(arg.matches(APIKeyRegex)){
                APIKey = arg.substring(APIKeyRegex.length()-2);
            }
            if(arg.matches(latitudeRegex)){
                latitude = arg.substring(latitudeRegex.length()-2);
            }
            if(arg.matches(longitudeRegex)){
                longitude = arg.substring(longitudeRegex.length()-2);
            }
            if(arg.matches(historyRegex)){
                history = true;
            }
        }
        if(sensorID == null && (latitude == null || longitude == null)) throw new IllegalArgumentException("Sensor ID or latitude&longitude required");
    }
}
