package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    private int minLength = 0;
    private String sample = null;

    public boolean isValid(final Object o) {
        String string = null;
        if (super.isValid(o)) {
            if (o instanceof String) {
                string = (String) o;
            } else if (o != null) {
                return false;
            }
        } else {
            return false;
        }

        if (super.getRequired()) {
            minLength = 1;
        }
        if (minLength > 0 && string.length() < minLength) {
            return false;
        }
        if ((sample != null) && (!string.contains(sample))) {
            return false;
        }
        return true;
    }

    public StringSchema minLength(final int newMinLength) {
        minLength = newMinLength;
        return this;
    }

    public StringSchema contains(final String newSample) {
        sample = newSample;
        return this;
    }

}
