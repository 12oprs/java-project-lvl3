package hexlet.code;

class StringSchema {

    private boolean required = false;
    private int minLength = -1;
    private String sample = null;

    boolean isValid(String string) {
        if ((required) && (string == null || string.length() == 0)) {
            return false;
        }
        if ((minLength >= 0) && (string.length() < minLength)) {
            return false;
        }
        if ((sample != null) && (!string.contains(sample))) {
            return false;
        }
        return true;
    }

    StringSchema required() {
        required = true;
        return this;
    }

    StringSchema minLength(int newMinLength) {
        minLength = newMinLength;
        return this;
    }

    StringSchema contains(String newSample) {
        sample = newSample;
        return this;
    }

}
