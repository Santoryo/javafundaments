import java.util.Map;

public class Record {
    private Map<String, Object> fields;

    public Record(Map<String, Object> fields) {
        this.fields = fields;
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public Object getField(String key) {
        return fields.get(key);
    }

    public void setField(String key, Object value) {
        fields.put(key, value);
    }

    @Override
    public String toString() {
        return fields.toString();
    }
}
