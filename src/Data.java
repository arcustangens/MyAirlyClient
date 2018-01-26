public class Data {
    private CurrentMeasurements currentMeasurements;
    private MeasurementsHistory history[];

    @Override
    public String toString(){
        String result="";
        result+=currentMeasurements.toString();
        for(MeasurementsHistory measurement : history){
            result+=measurement.toString();
        }
        result+="▓▒░▒▓▒░▒▓▒░▒▓▒░▒▓▒";
        return result;
    }

    public String toStringWithoutHistory(){
        String result="";
        result+=currentMeasurements.toString();
        result+="▓▒░▒▓▒░▒▓▒░▒▓▒░▒▓▒";
        return result;
    }

    public CurrentMeasurements getCurrentMeasurements() {
        return currentMeasurements;
    }
}
