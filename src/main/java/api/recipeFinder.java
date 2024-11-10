package api;

import java.util.List;
import java.util.Map;

public class recipeFinder implements recipeFinderInterface {
    private static final String API_URL = "https://api.edamam.com/search";
    private static final String APP_ID = "your_app_id";
    private static final String APP_KEY = "your_app_key";

    @Override
    public List<Map<String, Object>> getRecipeByIngredient(List<String> ingredients) {
    };


}
