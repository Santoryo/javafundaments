import java.util.List;

public class Table {
    private String name;
    private List<String> columnsNames;
    private List<Record> rows;

    public Table(String name, JSONArray columnsNames) {
        this.name = name;
        this.columnsNames = columnsNames.toList();
        this.rows = new ArrayList<>();
    }
}
