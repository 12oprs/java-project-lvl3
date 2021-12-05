package hexlet.code;

abstract class BaseSchema {

    protected boolean required = false;

    boolean isValid(final Object o) {
        if (required && o == null) {
            return false;
        }
        return true;
    }
    
    BaseSchema required() {
        required = true;
        return this;
    }
}
