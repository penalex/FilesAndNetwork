public record Line(String name, String number) {
    //линии метро сокращенный класс

    @Override
    public String toString() {
        return "Line{"+"name='"+name+'\''+", number='"+number+'\''+'}';
    }
}
