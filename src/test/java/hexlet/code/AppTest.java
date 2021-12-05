package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.MapSchema;
import java.util.Map;
import java.util.HashMap;

class AppTest {

    private static Validator v;

    @BeforeEach
    void preparing() {
        v = new Validator();
    }

    @Test
    @DisplayName("Test StringSchema")
    void stringSchemaTest() {

        StringSchema schema = v.string();

        assertEquals(true, schema.isValid(""));
        assertEquals(true, schema.isValid(null));

        schema.required();
        assertEquals(true, schema.isValid("what does the fox say"));
        assertEquals(true, schema.isValid("hexlet"));
        assertEquals(false, schema.isValid(null));
        assertEquals(false, schema.isValid(""));
        assertEquals(false, schema.isValid(2));

        assertEquals(true, schema.contains("what").isValid("what does the fox say"));
        assertEquals(false, schema.contains("whatthe").isValid("what does the fox say"));
    }

    @Test
    @DisplayName("Test NumberSchema")
    @SuppressWarnings("checkstyle:magicnumber")
    void numberSchemaTest() {
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

    @Test
    @DisplayName("Test MapSchema")
    void mapSchemaTest() {
        MapSchema schema = v.map();

        assertEquals(true, schema.isValid(null));

        schema.required();
        assertEquals(false, schema.isValid(null));
        assertEquals(true, schema.isValid(new HashMap()));
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertEquals(true, schema.isValid(data));

        schema.sizeof(2);
        assertEquals(false, schema.isValid(data));
        data.put("key2", "value2");
        assertEquals(true, schema.isValid(data));
    }
}
