import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;
@SuppressWarnings("unchecked")
//Станции

public class JsonStationsInfo {
    private JSONObject mainObject;

    private final ParseHtmlPage parseHtmlPage = new ParseHtmlPage();
    private final ParseJSONFile parseJsonFile = new ParseJSONFile();
    private final ParseCSVFile parseCsvFile = new ParseCSVFile();

    private final List<Station> stations = parseHtmlPage.getStations();
    private final List<Line> lines = parseHtmlPage.getLines();
    private final List<StationDepth> stationsDepth = parseJsonFile.getStationsDepth();
    private final List<StationDate> stationDates = parseCsvFile.getStationsDates();

    public JsonStationsInfo() {
        createJsonObject();
    }

    @SuppressWarnings("unchecked")
    private void createJsonObject() {
        mainObject = new JSONObject();

        JSONArray stationsArray = new JSONArray();
        for (Station station : stations) {
            JSONObject obj = new JSONObject();
            String etalonName = station.getName();
            obj.put("name", etalonName);

            for (Line line : lines) {
                if (station.getLine().equals(line.number())) {
                    String nameOfLine = line.name();
                    obj.put("line", nameOfLine);
                }
            }
            for (StationDate stationDate : stationDates) {
                if (stationDate.name().equals(etalonName)) {
                    obj.put("date", stationDate.date());
                }
            }

            for (StationDepth stationDepth : stationsDepth) {
                if (stationDepth.name().equals(etalonName)
                        && stationDepth.depth() != "-0") {
                    obj.put("depth", stationDepth.depth());
                }
            }

            obj.put("hasConnection", station.getHasConnection());
            stationsArray.add(obj);
        }
        String mainKey = "stations";
        mainObject.put(mainKey, stationsArray);
    }

    public JSONObject getMainObject() {
        return mainObject;
    }
}