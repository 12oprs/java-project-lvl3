package hexlet.code.schemas;

abstract class BaseSchema {

    private boolean required = false;

    public boolean isValid(final Object o) {
        if (required && o == null) {
            return false;
        }
        return true;
    }

    public BaseSchema required() {
        required = true;
        return this;
    }

    public boolean getRequired() {
        return required;
    }
}
