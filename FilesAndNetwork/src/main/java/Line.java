public record Line(String name, String number) {

    @Override
    public String toString() {
        return "Line{"+"name='"+name+'\''+", number='"+number+'\''+'}';
    }
}
