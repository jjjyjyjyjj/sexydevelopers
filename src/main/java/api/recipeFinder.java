package api;

import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class recipeFinder implements recipeFinderInterface {
    private static final String API_URL = "https://api.edamam.com/search";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";
    private static final String APP_ID = "your_app_id";
    private static final String APP_KEY = "your_app_key";

    public static String getAPIKey() { return System.getenv(APP_KEY); }

    @Override
    public List<Map<String, Object>> getRecipeByIngredient(List<String> ingredients, int number, int ranking, boolean ignorePantry) {

        // Build the request to fetch recipes.
        final OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        final Request request = new Request.Builder()
                .url(String.format("%s/findByIngredients?ingredients=%s&number=%s", API_URL, ingredients, number, ranking, ignorePantry))
                .addHeader(APP_KEY, getAPIKey())
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();
    return null;};

    @Override
    public List<Map<String, Object>> getRecipeByIngredient(List<String> ingredients) {
        return List.of();
    }


}
