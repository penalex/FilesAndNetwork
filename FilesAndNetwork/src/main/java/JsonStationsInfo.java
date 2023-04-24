import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class JsonStationsInfo {
    private JSONObject mainObject;
    private JSONArray stationsArray;
    private final String mainKey = "stations";

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

    private JSONObject createJsonObject() {
        mainObject = new JSONObject();

        stationsArray = new JSONArray();
        for (int stationIndex = 0; stationIndex < stations.size(); stationIndex++) {
            JSONObject obj = new JSONObject();
            String etalonName = stations.get(stationIndex).getName();
            obj.put("name", etalonName);

            for (int lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
                if (stations.get(stationIndex).getLine().equals(lines.get(lineIndex).getNumber())) {
                    String nameOfLine = lines.get(lineIndex).getName();
                    obj.put("line", nameOfLine);
                }
            }
            for (int dateIndex = 0; dateIndex < stationDates.size(); dateIndex++) {
                if (stationDates.get(dateIndex).getName().equals(etalonName)) {
                    obj.put("date", stationDates.get(dateIndex).getDate());
                }
            }

            for (int depthIndex = 0; depthIndex < stationsDepth.size(); depthIndex++) {
                if (stationsDepth.get(depthIndex).getName().equals(etalonName)
                        && stationsDepth.get(depthIndex).getDepth() != "-0") {
                    obj.put("depth", stationsDepth.get(depthIndex).getDepth());
                }
            }

            obj.put("hasConnection", stations.get(stationIndex).getHasConnection());
            stationsArray.add(obj);
        }
        mainObject.put(mainKey, stationsArray);
        return mainObject;
    }

    public JSONObject getMainObject() {
        return mainObject;
    }
}