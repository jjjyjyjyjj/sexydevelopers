package api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.RecipeBank;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class recipeFinder implements recipeFinderInterface {
    private static final String API_URL = "https://api.spoonacular.com/recipes";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";
    private static final String APP_KEY = "your_app_key"; // Replace with your actual key
    private static final int SUCCESS_CODE = 200;

    public static String getAPIKey() {
        return System.getenv(APP_KEY);
    }

    @Override
    public List<Map<String, Object>> getRecipeByIngredient(List<String> ingredients, int number, int ranking, boolean ignorePantry) throws IOException {
        // Prepare ingredients for the URL query
        String ingredientsParam = String.join(",", ingredients);

        // Build the request URL with necessary parameters
        String url = String.format("%s/findByIngredients?ingredients=%s&number=%d&ranking=%d&ignorePantry=%b&apiKey=%s",
                API_URL, ingredientsParam, number, ranking, ignorePantry, getAPIKey());

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();

        // Execute the request and parse the response manually
        try (Response response = client.newCall(request).execute()) {
            if (response.code() != SUCCESS_CODE) {
                throw new RuntimeException("Failed to fetch recipes: " + response.message());
            }

            String responseBody = response.body().string();
            return parseRecipes(responseBody);
        }
    }

    private List<Map<String, Object>> parseRecipes(String responseBody) {
        List<Map<String, Object>> recipesList = new ArrayList<>();

        // Strip the leading and trailing brackets from the JSON array
        responseBody = responseBody.substring(1, responseBody.length() - 1);
        String[] recipeStrings = responseBody.split("},\\{");

        for (String recipeString : recipeStrings) {
            Map<String, Object> recipeMap = new HashMap<>();

            // Clean up the individual recipe JSON string by adding brackets as needed
            if (!recipeString.startsWith("{")) recipeString = "{" + recipeString;
            if (!recipeString.endsWith("}")) recipeString += "}";

            // Extract recipe ID
            String id = extractValue(recipeString, "\"id\":", ",");
            recipeMap.put("id", Integer.parseInt(id.trim()));

            // Extract title
            String title = extractValue(recipeString, "\"title\":\"", "\",");
            recipeMap.put("title", title);

            // Extract image
            String image = extractValue(recipeString, "\"image\":\"", "\",");
            recipeMap.put("image", image);

            // Build URL
            recipeMap.put("url", "https://spoonacular.com/recipes/" + title.replaceAll(" ", "-") + "-" + id);

            // Extract only `usedIngredients`
            List<String> ingredientsList = new ArrayList<>();
            String usedIngredientsString = extractValue(recipeString, "\"usedIngredients\":[", "]");

            if (!usedIngredientsString.isEmpty()) {
                String[] usedIngredients = usedIngredientsString.split("},\\{");
                for (String ingredient : usedIngredients) {
                    ingredientsList.add(extractValue(ingredient, "\"original\":\"", "\","));
                }
            }

            recipeMap.put("ingredients", ingredientsList);
            recipesList.add(recipeMap);
        }

        return recipesList;
    }

    private String extractValue(String text, String startDelimiter, String endDelimiter) {
        int startIndex = text.indexOf(startDelimiter) + startDelimiter.length();
        int endIndex = text.indexOf(endDelimiter, startIndex);
        if (startIndex == -1 || endIndex == -1) {
            return "";
        }
        return text.substring(startIndex, endIndex);
    }
}

//public class recipeFinder implements recipeFinderInterface {
//    private static final String API_URL = "https://api.spoonacular.com/recipes/findByIngredients";
//    private static final String CONTENT_TYPE = "Content-Type";
//    private static final String APPLICATION_JSON = "application/json";
//    private static final String STATUS_CODE = "status_code";
//    private static final String MESSAGE = "message";
//    private static final String RECIPE = "recipe";
//    private static final String APP_ID = "your_app_id";
//    private static final String APP_KEY = "your_app_key";
//
//    private static final int SUCCESS_CODE = 200;
//
//    public static String getAPIKey() { return System.getenv(APP_KEY); }
//
//    @Override
//    public List<Map<String, Object>> getRecipeByIngredient(List<String> ingredients, int number, int ranking, boolean ignorePantry) throws IOException {
//
//        // Build the request to fetch recipes.
//        final OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        final Request request = new Request.Builder()
//                .url(String.format("%s/findByIngredients?ingredients=%s&number=%s", API_URL, ingredients, number, ranking=2, ignorePantry))
//                .addHeader(APP_KEY, getAPIKey())
//                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
//                .build();
//
//        // Hint: look at the API documentation to understand what the response looks like.
//        try {
//            final Response response = client.newCall(request).execute();
//            final JSONObject responseBody = new JSONObject(response.body().string());
//
//            if (responseBody.getInt(STATUS_CODE) == SUCCESS_CODE) {
//                final JSONObject recipe = responseBody.getJSONObject(RECIPE);
//                return Recipe.builder()
//                        .title(recipe.getString("title"))
//                        .image()
//                        .url()
//                        .id()
//                        .ingredients()
//                        .build();
//            }
//            else {
//            throw new RuntimeException(responseBody.getString(MESSAGE));
//        }
//    }
//        catch (IOException | JSONException event) {
//        throw new RuntimeException(event);
//    }
//}
//}


