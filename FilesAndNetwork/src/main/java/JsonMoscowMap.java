import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class JsonMoscowMap {
    private JSONObject mainObject;
    private LinkedHashMap<String, String> stationsPerLine;

    private final ParseHtmlPage parseHtmlPage = new ParseHtmlPage();
    private final List<Station> stations = parseHtmlPage.getStations();
    private final List<Line> lines = parseHtmlPage.getLines();

    public JsonMoscowMap() {
        createJsonObject();
    }


    @SuppressWarnings("unchecked")
    private void createJsonObject() {
        String keyStations = "stations";
        String keyLines = "lines";
        getStationsPerLine();
        mainObject = new JSONObject();


        JSONObject stationsObjectJson = new JSONObject();
        for (Line value : lines) {
            JSONArray stationsArray = new JSONArray();
            String listStations = stationsPerLine.get(value.number()).trim();
            String[] fragments = listStations.split("\\s{2}");
            Collections.addAll(stationsArray, fragments);
            stationsObjectJson.put(value.number(), stationsArray);
        }

        JSONArray linesArrayJson = new JSONArray();
        for (Line line : lines) {
            JSONObject obj = new JSONObject();
            obj.put("number", line.number());
            obj.put("name", line.name());
            linesArrayJson.add(obj);
        }

        mainObject.put(keyStations, stationsObjectJson);
        mainObject.put(keyLines, linesArrayJson);
    }

    private void getStationsPerLine() {
        stationsPerLine = new LinkedHashMap<>();

        for (Station station : stations) {
            if (!stationsPerLine.containsKey(station.getLine())) {
                stationsPerLine.put(station.getLine(), "");
            }
            stationsPerLine.put(station.getLine(),
                    stationsPerLine.get(station.getLine())+"  "+station.getName());
        }
    }

    public JSONObject getMainObject() {
        return mainObject;
    }

}