package api;

import entity.CommonIngredient;
import entity.Ingredient;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class searchIngredients implements  searchIngredientsInterface {
    private static final String API_URL = "https://api.spoonacular.com/food/ingredients/search";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";
    private static final String APP_KEY = "00ab640014494f1ab81008310af8ec28"; // Replace with your actual key
    private static final int SUCCESS_CODE = 200;

    public static String getAPIKey() {
        return System.getenv(APP_KEY);
    }

    @Override
    public List<Ingredient> findIngredients(String query) throws IOException {
        String url = String.format("%s/search?query=%s&number=%d&apiKey=%s", API_URL, query, getAPIKey());

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.code() != SUCCESS_CODE) {
                throw new RuntimeException("Failed to fetch ingredients: " + response.message());
            }

            String responseBody = response.body().string();
            List<Ingredient> ingredients = parseIngredients(responseBody);

            // Fetch aisle information for each ingredient
            for (Ingredient ingredient : ingredients) {
                String aisle = fetchInfoForIngredient(ingredient.getId()).get(0);
                String unit = fetchInfoForIngredient(ingredient.getId()).get(1);
                ingredient.setAisle(aisle);
                ingredient.setUnit(unit);
            }

            return ingredients;
        }
    }

    private static List<String> fetchInfoForIngredient(int ingredientId) throws IOException {
        String url = String.format("%s/%d/information?apiKey=%s", API_URL, ingredientId, getAPIKey());

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.code() != SUCCESS_CODE) {
                throw new RuntimeException("Failed to fetch ingredient info: " + response.message());
            }

            String responseBody = response.body().string();

            // Extract the aisle and unit values
            String aisle = extractValue(responseBody, "\"aisle\":\"", "\"");
            String unit = extractValue(responseBody, "\"unit\":\"", "\"");

            // Return them as a list
            List<String> info = new ArrayList<>();
            info.add(aisle);
            info.add(unit);

            return info;
        }
    }

    private static List<Ingredient> parseIngredients(String responseBody) {
        List<Ingredient> ingredientList = new ArrayList<>();

        // Extract the "results" array from the JSON response
        String results = extractValue(responseBody, "\"results\":[", "]");

        if (!results.isEmpty()) {
            String[] ingredientStrings = results.split("},\\{");

            for (String ingredientString : ingredientStrings) {
                // Normalize JSON fragments
                if (!ingredientString.startsWith("{")) ingredientString = "{" + ingredientString;
                if (!ingredientString.endsWith("}")) ingredientString += "}";

                // Extract fields from each ingredient object
                int id = Integer.parseInt(extractValue(ingredientString, "\"id\":", ",").trim());
                String name = extractValue(ingredientString, "\"name\":\"", "\",");
                String image = extractValue(ingredientString, "\"image\":\"", "\"");
                String unit = extractValue(ingredientString, "\"unit\":\"", "\"");
                String aisle = extractValue(ingredientString, "\"aisle\":\"", "\"");

                // Create and add the Ingredient object
                CommonIngredient ingredient = new CommonIngredient(name, id, unit, aisle);
                ingredientList.add(ingredient);
            }
        }

        return ingredientList;
    }

    private static String extractValue(String text, String startDelimiter, String endDelimiter) {
        int startIndex = text.indexOf(startDelimiter) + startDelimiter.length();
        int endIndex = text.indexOf(endDelimiter, startIndex);
        if (startIndex == -1 || endIndex == -1) {
            return "";
        }
        return text.substring(startIndex, endIndex);
    }
}
