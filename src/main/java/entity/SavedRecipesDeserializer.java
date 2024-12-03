package entity;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Deserializes savevd recipes variables after being read from the json file.
 */
public class SavedRecipesDeserializer extends JsonDeserializer<SavedRecipes> {
    @Override
    public SavedRecipes deserialize(JsonParser jp, DeserializationContext context) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = mapper.readTree(jp);

        if (root.has("name") && root.get("name").asText().equals("tried recipe")) {
            return mapper.readValue(root.toString(), TriedRecipes.class);
        }
        else if (root.has("name") && root.get("name").asText().equals("saved for later")) {
            return mapper.readValue(root.toString(), SavedForLater.class);
        }
        return mapper.readValue(root.toString(), FavouritedRecipes.class);
    }
}
