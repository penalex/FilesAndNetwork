import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {

        String pathMapMoscow = "DataCollector/data/map.json";
        String pathStationsInfo = "DataCollector/data/stations.json";

        JsonMoscowMap mapMoscow = new JsonMoscowMap();
        JsonStationsInfo stationsInfo = new JsonStationsInfo();

        JSONObject objMapMoscow = mapMoscow.getMainObject();
        JSONObject objStationsInfo = stationsInfo.getMainObject();

        JsonWriter.writer(objMapMoscow, pathMapMoscow);
        JsonWriter.writer(objStationsInfo, pathStationsInfo);

        FilesSearch filesSearch = new FilesSearch();
        filesSearch.getCSVFilesAbsolutePath();
        filesSearch.getJSONFilesAbsolutePath();
    }
}
