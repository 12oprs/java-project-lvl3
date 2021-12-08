package hexlet.code.schemas;

public final class StringSchema extends BaseSchema {

    private int minLength = 0;
    private String sample = null;

    @Override
    public boolean isValid(final Object o) {
        String string = null;
        if (super.isValid(o)) {
            if (o == null) {
                return true;
            } else if (o instanceof String) {
                string = (String) o;
            } else {
                return false;
            }
        } else {
            return false;
        }

        if (super.getRequired() && string.length() == 0) {
            return false;
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

    public StringSchema contains() {
        sample = null;
        return this;
    }

}
