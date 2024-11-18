package api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.Ingredient;
import entity.Recipe;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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
    public List<Recipe> getRecipeByIngredient(List<Ingredient> ingredients, int number, int ranking, boolean ignorePantry) throws IOException {
        // Extract the ingredient names from the Ingredient objects
        List<String> ingredientNames = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            ingredientNames.add(ingredient.getName());
        }

        String ingredientsParam = String.join(",", ingredientNames);

        String url = String.format("%s/findByIngredients?ingredients=%s&number=%d&ranking=%d&ignorePantry=%b&apiKey=%s",
                API_URL, ingredientsParam, number, ranking, ignorePantry, getAPIKey());

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.code() != SUCCESS_CODE) {
                throw new RuntimeException("Failed to fetch recipes: " + response.message());
            }

            String responseBody = response.body().string();
            return parseRecipes(responseBody);
        }
    }

    public List<Recipe> getRecipeByNutrition(int calories, int protein, int carbs, boolean maxCalories, boolean maxProtein, boolean maxCarbs) throws IOException {
        // Build query parameters based on the provided nutritional limits
        StringBuilder urlBuilder = new StringBuilder(API_URL).append("/findByNutrients?");

        if (maxCalories) {
            urlBuilder.append("maxCalories=").append(calories).append("&");
        } else {
            urlBuilder.append("minCalories=").append(calories).append("&");
        }

        if (maxProtein) {
            urlBuilder.append("maxProtein=").append(protein).append("&");
        } else {
            urlBuilder.append("minProtein=").append(protein).append("&");
        }

        if (maxCarbs) {
            urlBuilder.append("maxCarbs=").append(carbs).append("&");
        } else {
            urlBuilder.append("minCarbs=").append(carbs).append("&");
        }

        // Append API key
        urlBuilder.append("apiKey=").append(getAPIKey());

        String url = urlBuilder.toString();

        // Create and execute the HTTP request
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.code() != SUCCESS_CODE) {
                throw new RuntimeException("Failed to fetch recipes: " + response.message());
            }

            String responseBody = response.body().string();
            return parseRecipes(responseBody);
        }
    }

    private List<Recipe> parseRecipes(String responseBody) {
        List<Recipe> recipesList = new ArrayList<>();
        responseBody = responseBody.substring(1, responseBody.length() - 1);
        String[] recipeStrings = responseBody.split("},\\{");

        for (String recipeString : recipeStrings) {
            if (!recipeString.startsWith("{")) recipeString = "{" + recipeString;
            if (!recipeString.endsWith("}")) recipeString += "}";

            String id = extractValue(recipeString, "\"id\":", ",").trim();
            String title = extractValue(recipeString, "\"title\":\"", "\",");
            String image = extractValue(recipeString, "\"image\":\"", "\",");

            // Extract and create Ingredient objects from `usedIngredients`
            List<Ingredient> ingredientsList = new ArrayList<>();
            String usedIngredientsString = extractValue(recipeString, "\"usedIngredients\":[", "]");

            if (!usedIngredientsString.isEmpty()) {
                String[] usedIngredients = usedIngredientsString.split("},\\{");
                for (String ingredientString : usedIngredients) {
                    String ingredientName = extractValue(ingredientString, "\"name\":\"", "\",");
                    String ingredientId = extractValue(ingredientString, "\"id\":", ",").trim();
                    String unit = extractValue(ingredientString, "\"unit\":\"", "\",");
                    String aisle = extractValue(ingredientString, "\"aisle\":\"", "\",");
                    ingredientsList.add(new Ingredient(ingredientName, ingredientId, unit, aisle));
                }
            }

            // Create Recipe object and add it to the list
            Recipe recipe = new Recipe(title, id, ingredientsList, image);
            recipesList.add(recipe);
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


