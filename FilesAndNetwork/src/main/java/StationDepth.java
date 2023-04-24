public record StationDepth(String name, String depth) {
//..
    @Override
    public String toString() {
        return "StationDepth{"+"name='"+name+'\''+", depth='"+depth+'\''+'}';
    }
}
