package hexlet.code.schemas;

import java.util.Map;

public class NumberSchema extends BaseSchema {

    private boolean positive = false;
    private Map<String, Integer> range = null;

    public boolean isValid(final Object o) {
        Integer number = null;
        if (super.isValid(o)) {
            if (o instanceof Integer) {
                number = (Integer) o;
            } else if (o != null) {
                return false;
            }
        } else {
            return false;
        }
        if (positive && number < 0) {
            return false;
        }
        if (range != null && (number < range.get("min") || number > range.get("max"))) {
            return false;
        }
        return true;
    }

    public NumberSchema positive() {
        positive = true;
        return this;
    }

    public NumberSchema range(final int min, final int max) {
        range = Map.of(
            "min", min,
            "max", max
            );
        return this;
    }

}
