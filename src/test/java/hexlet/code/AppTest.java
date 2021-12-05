package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

// import hexlet.code.Validator;
// import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.BeforeAll;

class AppTest {


    @Test
    @DisplayName("Test StringSchema")
    void stringSchemaTest() {

        Validator v = new Validator();
        StringSchema schema = v.string();

        assertEquals(true, schema.isValid(""));
        assertEquals(true, schema.isValid(null));

        schema.required();
        assertEquals(true, schema.isValid("what does the fox say"));
        assertEquals(true, schema.isValid("hexlet"));
        assertEquals(false, schema.isValid(null));
        assertEquals(false, schema.isValid(""));
        assertEquals(false, schema.isValid(5));

        assertEquals(true, schema.contains("what").isValid("what does the fox say"));
        assertEquals(false, schema.contains("whatthe").isValid("what does the fox say"));
    }

    @Test
    @DisplayName("Test NumberSchema")
    void numberSchemaTest() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertEquals(true, schema.isValid(null));

        schema.required();
        assertEquals(false, schema.isValid(null));
        assertEquals(true, schema.isValid(10));
        assertEquals(false, schema.isValid("5"));

        assertEquals(true, schema.positive().isValid(10));
        assertEquals(false, schema.isValid(-10));

        schema.range(5, 10);
        assertEquals(true, schema.isValid(5));
        assertEquals(true, schema.isValid(10));
        assertEquals(false, schema.isValid(4));
        assertEquals(false, schema.isValid(11));
    }
}
