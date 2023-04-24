public class Station {
//..
    private final String name;
    private final String line;
    private final Boolean connection;

    public Station(String name, String line, Boolean connection) {
        this.name = name;
        this.line = line;
        this.connection = connection;
    }

    public String getLine() {
        return line;
    }

    public String getName() {
        return name;
    }

    public Boolean getHasConnection() {
        return connection;
    }

    @Override
    public String toString() {
        return "Station{" + "name='" + name + '\'' + ", line='" + line + '\'' + '}';
    }
}
