import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
//..
public class ParseCSVFile {
    private List<StationDate> stationsDates;

    public ParseCSVFile() {
        parse();
        listFormatted();
    }

    private void parse() {
        stationsDates = new ArrayList<>();
        List<String> lines = getCsvInLines();
        for (String line : lines) {
            String[] tokens = line.split(",");
            if (tokens.length != 2) {
                System.out.println("Wrong line = " + line);
            }
            stationsDates.add(new StationDate(tokens[0], tokens[1]));
        }
    }

    private List<String> getCsvInLines() {
        List<String> lines;
        List<String> csvLines = new ArrayList<>();

        FilesSearch filesSearch = new FilesSearch();
        String[] paths = filesSearch.getCSVFilesAbsolutePath().split("\n");
        for (String path : paths) {
            try {
                lines = Files.readAllLines(Path.of(path));
                lines.remove(0);
                csvLines.addAll(lines);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvLines;
    }

    private void listFormatted() {
        for (int i = 0; i < stationsDates.size(); i ++) {
            String name = stationsDates.get(i).name();
            String date = stationsDates.get(i).date();
            for (int j = 0; j <stationsDates.size(); j++) {
                String anotherName = stationsDates.get(j).name();
                String anotherdate = stationsDates.get(j).date();
                if (name.equals(anotherName) && date.equals(anotherdate)) {
                    stationsDates.remove(j);
                }
            }
        }
    }


    public List<StationDate> getStationsDates() {
        return stationsDates;
    }
}