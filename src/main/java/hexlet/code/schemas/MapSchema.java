package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<Object, Object>> {

    private Map<String, BaseSchema> shape = null;

    public boolean isValid(final Object o) {
        if (o instanceof Map || o == null) {
            if (shape != null) {
                return checkShape((Map) o);
            } else {
                return super.isValid(o);
            }
        }
        return false;
    }

    private boolean checkShape(Map<Object, Object> map) {
        for (Map.Entry<String, BaseSchema> entry : shape.entrySet()) {
            BaseSchema schema = entry.getValue();
            Object value = map.get(entry.getKey());
            if (!schema.isValid(value)) {
                return false;
            }
        }
        return true;
    }

    public MapSchema sizeof(final int newSize) {
        addCondition(map -> map.size() != newSize);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> newShape) {
        shape = newShape;
        return this;
    }

    public MapSchema shape() {
        shape = null;
        return this;
    }

    public MapSchema required() {
        return super.<MapSchema>required();
    }
}
