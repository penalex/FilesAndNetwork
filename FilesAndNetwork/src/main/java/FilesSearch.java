import java.io.File;

public class FilesSearch {
    private final String folderPath = "DataCollector/stations-data/";
    private String JSONFilesAbsolutePath;
    private String CSVFilesAbsolutePath;

    public FilesSearch() {
        getJSONfiles(folderPath);
        getCSVfiles(folderPath);
    }

    private String getJSONfiles(String folderPath) {
        JSONFilesAbsolutePath = "";
        File folder = new File(folderPath);
        if (folder.isFile() && folder.getName().endsWith(".json")) {
            JSONFilesAbsolutePath += folder.getAbsolutePath() + "\n";
        }
        try {
            File[] files = folder.listFiles();
            for (File file : files) {
                JSONFilesAbsolutePath += getJSONfiles(file.getAbsolutePath());
            }
        } catch (NullPointerException e) {
            e.fillInStackTrace();
        }
        return JSONFilesAbsolutePath;
    }

    private String getCSVfiles(String folderPath) {
        CSVFilesAbsolutePath = "";
        File folder = new File(folderPath);
        if (folder.isFile() && folder.getName().endsWith(".csv")) {
            CSVFilesAbsolutePath += folder.getAbsolutePath() + "\n";
        }
        try {
            File[] files = folder.listFiles();
            for (File file : files) {
                CSVFilesAbsolutePath += getCSVfiles(file.getAbsolutePath());
            }
        } catch (NullPointerException e) {
            e.fillInStackTrace();
        }
        return CSVFilesAbsolutePath;
    }

    public String getJSONFilesAbsolutePath() {
        System.out.println(JSONFilesAbsolutePath);
        return JSONFilesAbsolutePath;
    }

    public String getCSVFilesAbsolutePath() {
        System.out.println(CSVFilesAbsolutePath);
        return CSVFilesAbsolutePath;
    }
}