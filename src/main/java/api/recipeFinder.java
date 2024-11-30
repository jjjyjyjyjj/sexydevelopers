package api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class recipeFinder implements recipeFinderInterface {
    private static final String API_URL = "https://api.spoonacular.com/recipes/findByIngredients";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";
    private static final String APP_KEY = "00ab640014494f1ab81008310af8ec28";
    private static final int SUCCESS_CODE = 200;

    public static String getAPIKey() {
        return System.getenv(APP_KEY);
    }

    @Override
    public List<Recipe> getRecipeByIngredient(ArrayList<Ingredient> ingredients, int number, int ranking, boolean ignorePantry) throws IOException {
        // Extract the ingredient names from the CommonIngredient objects
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

    private List<Recipe> parseRecipes(String responseBody) throws IOException {
        List<Recipe> recipesList = new ArrayList<>();
        responseBody = responseBody.substring(1, responseBody.length() - 1);
        String[] recipeStrings = responseBody.split("},\\{");

        for (String recipeString : recipeStrings) {
            if (!recipeString.startsWith("{")) recipeString = "{" + recipeString;
            if (!recipeString.endsWith("}")) recipeString += "}";

            int id = Integer.parseInt(extractValue(recipeString, "\"id\":", ",").trim());
            String title = extractValue(recipeString, "\"title\":\"", "\",");
            String image = extractValue(recipeString, "\"image\":\"", "\",");

            // Extract and create CommonIngredient objects from `usedIngredients`
            List<Ingredient> ingredientsList = new ArrayList<>();
            String usedIngredientsString = extractValue(recipeString, "\"usedIngredients\":[", "]");

            if (!usedIngredientsString.isEmpty()) {
                String[] usedIngredients = usedIngredientsString.split("},\\{");
                for (String ingredientString : usedIngredients) {
                    String ingredientName = extractValue(ingredientString, "\"name\":\"", "\",");
                    int ingredientId = Integer.parseInt(extractValue(ingredientString, "\"id\":", ",").trim());
                    String unit = extractValue(ingredientString, "\"unit\":\"", "\",");
                    String aisle = extractValue(ingredientString, "\"aisle\":\"", "\",");
                    IngredientFactory ingredientFactory = new CommonIngredientFactory();
                    ingredientsList.add(ingredientFactory.create(ingredientName, ingredientId, unit, aisle));
                }
            }

            // Create CommonRecipe object and add it to the list
            String link = new getRecipeInformation().getRecipeURL(id, false, false, false);
            RecipeFactory recipeFactory = new CommonRecipeFactory();
            Recipe recipe = recipeFactory.create(title, id, ingredientsList, image, link);
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


