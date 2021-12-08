package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {

    private int size = -1;

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
        return true;
    }

    public MapSchema sizeof(final int newSize) {
        size = newSize;
        return this;
    }
}
