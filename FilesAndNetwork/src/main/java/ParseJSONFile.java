import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParseJSONFile {

    private List<StationDepth> stationsDepth;


    public ParseJSONFile(){
        parse();
        listFormatted();
    }

    public List<StationDepth> getStationsDepth() {
        return stationsDepth;
    }

    private List<String> getJsonToString() {

        List<String> jsonToString = new ArrayList<>();
        FilesSearch search = new FilesSearch();
        String[] paths = search.getJSONFilesAbsolutePath().split("\n");

        for (String path : paths) {
            try {
                jsonToString.add(Files.readAllLines(Paths.get(path)).toString());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return jsonToString;
    }

    private void parse() {
        stationsDepth = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        try {
            for (String string : getJsonToString()) {
                JSONArray jsonData = (JSONArray) jsonParser.parse(string);
                for (Object infoDepth : jsonData) {
                    JSONObject stationDepth = (JSONObject) infoDepth;
                    String name = (String) stationDepth.get("station_name");
                    String depth = (String) stationDepth.get("depth");
                    String depth1 = depth.replaceAll(",", ".");
                    String depth2 = depth1.replaceAll("\\?", "-0");
                    stationsDepth.add(new StationDepth(name, depth2));
                }
            }
        } catch (ClassCastException e) {
            e.getStackTrace();
        } catch (ParseException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void listFormatted() {
        for (int i = 0; i < stationsDepth.size(); i++) {
            String name = stationsDepth.get(i).name();
            Double depth = Double.parseDouble(stationsDepth.get(i).depth());
            for (int j = 0; j < stationsDepth.size(); j++) {
                String anotherName = stationsDepth.get(j).name();
                Double anotherDepth = Double.parseDouble(stationsDepth.get(j).depth());
                String sameName2 = "Бауманская";
                String sameName1 = "Курская";
                if (name.equals(anotherName) && !name.equals(sameName1) && !name.equals(sameName2)) {
                    if (depth.compareTo(anotherDepth) > 0) {
                        stationsDepth.remove(j);
                        } else {
                        stationsDepth.remove(i);
                       }
                    }
                }
            }
       }
   }
