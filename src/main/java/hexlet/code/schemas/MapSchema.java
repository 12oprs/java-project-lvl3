package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    private int size = -1;
    private Map<String, BaseSchema> shape = null;

    @Override
    public boolean isValid(final Object o) {
        Map<Object, Object> map = null;
        if (super.isValid(o)) {
            if (o == null) {
                return true;
            } else if (o instanceof Map) {
                map = (Map<Object, Object>) o;
            } else {
                return false;
            }
        } else {
            return false;
        }
        if (super.getRequired() && size >= 0 && map.size() < size) {
            return false;
        }
        if (shape != null && !checkShape(map)) {
            return false;
        }
        return true;
    }

    private boolean checkShape(Map<Object, Object> map) {
        for (Map.Entry<String, BaseSchema> entry : shape.entrySet()) {
            if (!entry.getValue().isValid(map.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public MapSchema sizeof(final int newSize) {
        size = newSize;
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
