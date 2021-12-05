package hexlet.code;

class StringSchema extends BaseSchema {

    private int minLength = 0;
    private String sample = null;

    boolean isValid(final Object o) {
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
        
        if (required) {
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

    StringSchema minLength(final int newMinLength) {
        minLength = newMinLength;
        return this;
    }

    StringSchema contains(final String newSample) {
        sample = newSample;
        return this;
    }

}
