import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;

    private static StationIndex stationIndex;
    private static String dataFile = "src/main/resources/map.json";
    RouteCalculator routeCalculator;

    Line lineViolet;
    Line lineRed;
    Line lineGreen;

    @Override
    protected void setUp() throws Exception {

        route = new ArrayList<>();

        createStationIndex();

        lineViolet = stationIndex.getLine(1);
        lineRed = stationIndex.getLine(2);
        lineGreen = stationIndex.getLine(3);

        routeCalculator = new RouteCalculator(stationIndex);

        route.add(stationIndex.getStation("Нарвская"));
        route.add(stationIndex.getStation("Проспект Ветеранов"));
        route.add(stationIndex.getStation("Беговая"));
        route.add(stationIndex.getStation("Обухово"));
        route.add(stationIndex.getStation("Невский проспект"));
        route.add(stationIndex.getStation("Звенигородская"));
    }

    public void testCalculateDuration() {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 15.5;
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteOnTheLine() {
        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex.getStation("Нарвская"), stationIndex.getStation("Проспект Ветеранов"));
        List<Station> expected = Arrays.asList(new Station("Нарвская", lineViolet),
                stationIndex.getStation("Кировский завод"),
                stationIndex.getStation("Автово"),
                stationIndex.getStation("Ленинский проспект"),
                stationIndex.getStation("Проспект Ветеранов"));
        assertEquals(expected,actual);
    }

    public void testGetShortestRouteWithOneConnection() {
        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex.getStation("Чернышевская"), stationIndex.getStation("Маяковская"));
        List<Station> expected = Arrays.asList(stationIndex.getStation("Чернышевская"),
                stationIndex.getStation("Площадь Восстания"),
                stationIndex.getStation("Маяковская"));
        assertEquals(expected,actual);

    }

    public void testGetShortestRouteWithTwoConnections() {
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Чернышевская"), stationIndex.getStation("Достоевская"));
        List<Station>expected = Arrays.asList(
                stationIndex.getStation("Чернышевская"),
                stationIndex.getStation("Площадь Восстания"),
                stationIndex.getStation("Владимирская"),
                stationIndex.getStation("Достоевская"));
        assertEquals(expected, actual);
    }


    private static void createStationIndex() {
        stationIndex = new StationIndex();
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

            JSONArray linesArray = (JSONArray) jsonData.get("lines");
            parseLines(linesArray);

            JSONObject stationsObject = (JSONObject) jsonData.get("stations");
            parseStations(stationsObject);

            JSONArray connectionsArray = (JSONArray) jsonData.get("connections");
            parseConnections(connectionsArray);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void parseConnections(JSONArray connectionsArray) {
        connectionsArray.forEach(connectionObject ->
        {
            JSONArray connection = (JSONArray) connectionObject;
            List<Station> connectionStations = new ArrayList<>();
            connection.forEach(item ->
            {
                JSONObject itemObject = (JSONObject) item;
                int lineNumber = ((Long) itemObject.get("line")).intValue();
                String stationName = (String) itemObject.get("station");

                Station station = stationIndex.getStation(stationName, lineNumber);
                if (station == null) {
                    throw new IllegalArgumentException("core.Station "+
                            stationName+" on line "+lineNumber+" not found");
                }
                connectionStations.add(station);
            });
            stationIndex.addConnection(connectionStations);
        });
    }

    private static void parseStations(JSONObject stationsObject) {
        stationsObject.keySet().forEach(lineNumberObject ->
        {
            int lineNumber = Integer.parseInt((String) lineNumberObject);
            Line line = stationIndex.getLine(lineNumber);
            JSONArray stationsArray = (JSONArray) stationsObject.get(lineNumberObject);
            stationsArray.forEach(stationObject ->
            {
                Station station = new Station((String) stationObject, line);
                stationIndex.addStation(station);
                line.addStation(station);
            });
        });
    }

    private static void parseLines(JSONArray linesArray) {
        linesArray.forEach(lineObject -> {
            JSONObject lineJsonObject = (JSONObject) lineObject;
            Line line = new Line(
                    ((Long) lineJsonObject.get("number")).intValue(),
                    (String) lineJsonObject.get("name")
            );
            stationIndex.addLine(line);
        });
    }

    private static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            String dataFile = "src/main/resources/map.json";
            List<String> lines = Files.readAllLines(Paths.get(dataFile));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
