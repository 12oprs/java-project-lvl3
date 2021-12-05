package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    private int size = -1;

    public boolean isValid(final Object o) {
        Map map = null;
        if (super.isValid(o)) {
            if (o instanceof Map) {
                map = (Map) o;
            } else if (o != null) {
                return false;
            }
        } else {
            return false;
        }
        if (size >= 0 && map.size() < size) {
            return false;
        }
        return true;
    }

    public MapSchema sizeof(final int newSize) {
        size = newSize;
        return this;
    }
}
