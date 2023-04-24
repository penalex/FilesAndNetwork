public class Line {

    private final String name;
    private final String number;

    public Line(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Line{" + "name='" + name + '\'' + ", number='" + number + '\'' + '}';
        }
    }
