package hexlet.code.schemas;

public abstract class BaseSchema {

    private boolean required = false;

    /**
   * This implementation should be improved.
   * If you have some ideas, give me advice please
   * @return return true if value passed test
   * @param o - object for verification
   */
    public boolean isValid(final Object o) {
        if (required && o == null) {
            return false;
        }
        return true;
    }

    public final BaseSchema required() {
        required = true;
        return this;
    }

    protected  final boolean getRequired() {
        return required;
    }
}
