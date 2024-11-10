package api;

import java.util.List;
import java.util.Map;

public interface recipeFinderInterface {
    List<Map<String, Object>> getRecipeByIngredient(List<String> ingredients);
}
