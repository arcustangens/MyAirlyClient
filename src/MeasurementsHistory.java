public class MeasurementsHistory {
    private String fromDateTime, tillDateTime;
    private CurrentMeasurements measurements;

    @Override
    public String toString(){
        String result="▓▒░▒▓▒░▒▓▒░▒▓▒░▒▓▒\n";
        result+="From      "+fromDateTime+"\n";
        result+="Until     "+tillDateTime+"\n";
        result+=measurements.shortToString();
        //result+="▓▒░▒▓▒░▒▓▒░▒▓▒░▒▓▒\n";
        return result;
    }
}
