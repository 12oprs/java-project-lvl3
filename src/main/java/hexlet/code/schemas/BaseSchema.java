package hexlet.code.schemas;

public abstract class BaseSchema {

    private boolean required = false;

    /**
   * This implementation should be improved.
   * If you have some ideas, give me advice please
   * I tried to do it with generics but lost
   * @return return true if value passed test
   * @param o - object for verification
   */
    public boolean isValid(final Object o) {
        if (required && o == null) {
            return false;
        }
        return true;
    }

    /**
   * This implementation appeared because "v.number().required().positive()" didn't work.
   * @return return *Schema.class
   * @param <T> child-class for return
   */
    public <T extends BaseSchema> T required() {
        required = true;
        return (T) this;
    }

    protected final boolean getRequired() {
        return required;
    }
}
