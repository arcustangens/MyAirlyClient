public class CurrentMeasurements {
    private String airQualityIndex, pm1, pm25, pm10, pressure, humidity, temperature, pollutionLevel;

    public String cut(String string, int accuracy){
        if(accuracy<0 || !string.contains(".")) return string;
        if(accuracy==0) return string.substring(0, string.indexOf("."));
        return string.substring(0, string.indexOf(".")+accuracy+1);
    }

    @Override
    public String toString() {
        String result="▓▒░▒▓▒░▒▓▒░▒▓▒░▒▓▒\n";
        result+="Air quality index: " + cut(airQualityIndex,2) + "\n";
        //result+="PM1:               " + cut(pm1,2) + "µg/m3\n";
        result+="PM2.5:             " + cut(pm25,2) + "µg/m3\n";
        result+="PM10:              " + cut(pm10,2) + "µg/m3\n";
        result+="Pressure:          " + cut(pressure,2) + "Pa\n";
        result+="Humidity:          " + cut(humidity,2) + "%\n";
        result+="Temperature:       " + cut(temperature,2) + "°C\n";
        //result+="PollutionLevel:    " + cut(pollutionLevel,2) + "\n";
        return result;
    }

    public String shortToString() {
        String result="";
        result+="PM2.5:             " + cut(pm25,2) + "µg/m3\n";
        result+="PM10:              " + cut(pm10,2) + "µg/m3\n";
        return result;
    }
}
