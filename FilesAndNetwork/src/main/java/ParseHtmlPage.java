import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
//..
public class ParseHtmlPage {
    private final String htmlPath = "DataCollector/data/code.html";
    public List<Line> lines;
    public List<Station> stations;

    public ParseHtmlPage() {
        parseHtml();
    }

    private void getHtmlPage() {
        try {
            String url = "https://skillbox-java.github.io/";
            Document htmlFile = Jsoup.connect(url).get();
            PrintWriter writer = new PrintWriter(htmlPath);
            writer.write(htmlFile.outerHtml());
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void parseHtml() {
        lines = new ArrayList<>();
        stations = new ArrayList<>();
        File htmlFile = new File(htmlPath);

        if (htmlFile.length() == 0) {
            getHtmlPage();
        }
        try {

            Document doc = Jsoup.parse(htmlFile, "UTF-8");
            Elements linesInfo = doc.select("span.js-metro-line");
            for (Element element : linesInfo) {
                lines.add(new Line(element.text(), element.attr("data-line")));
            }

            Elements stationsPerLine = doc.getElementsByClass("js-metro-stations");
            for (Element element : stationsPerLine) {
                Elements stationsInfo = element.getElementsByClass("single-station");
                for (Element station : stationsInfo) {
                    String name = station.getElementsByClass("name").text();
                    String line = element.attr("data-line");
                    Boolean hasConnection = station.select("span.t-icon-metroln").hasAttr("title");
                    stations.add(new Station(name, line, hasConnection));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Station> getStations() {
        return stations;
    }


}
