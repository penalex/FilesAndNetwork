public record StationDate(String name, String date) {

    @Override
    public String toString() {
        return "StationsDates{"+"name='"+name+'\''+", date='"+date+'\''+'}';
    }
}
