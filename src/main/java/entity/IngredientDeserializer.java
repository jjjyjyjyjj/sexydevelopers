package entity;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Deserializes ingredient variables after being read from the json file.
 */
public class IngredientDeserializer extends JsonDeserializer<Ingredient> {
    @Override
    public Ingredient deserialize(JsonParser jp, DeserializationContext context) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = mapper.readTree(jp);

        return mapper.readValue(root.toString(), CommonIngredient.class);
    }
}
