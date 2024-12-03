package api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class recipeFinder implements recipeFinderInterface {
    private static final String API_URL = "https://api.spoonacular.com/recipes/findByIngredients";
    private static final String APP_KEY = "5ec040755f3843c0831136f62dffb896";
    private static final int SUCCESS_CODE = 200;

    public static String getAPIKey() {
        return APP_KEY;
    }

    @Override
    public List<Recipe> getRecipeByIngredient(ArrayList<Ingredient> ingredients) throws IOException {
        // Extract the ingredient names from the CommonIngredient objects
        List<String> ingredientNames = new ArrayList<>();
        for (Ingredient ingredient : ingredients) {
            ingredientNames.add(ingredient.getName());
        }

        String ingredientsParam = String.join(",", ingredientNames);
        System.out.println(ingredientsParam);
        System.out.println(getAPIKey());

        String url = String.format("%s?ingredients=%s&number=5&ranking=2&ignorePantry=true&apiKey=%s",
                API_URL, ingredientsParam, getAPIKey());

        System.out.println("Request URL: " + url);  // Log the URL

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.code() != SUCCESS_CODE) {
                String errorBody = response.body().string();  // Log the error response
                System.out.println("Response Code: " + response.code());
                System.out.println("Failed to fetch recipes: " + errorBody);
                throw new RuntimeException("Failed to fetch recipes: " + response.message());
            }

            String responseBody = response.body().string();
            System.out.println("Response Body: " + parseRecipes(responseBody));
            System.out.println(parseRecipes(responseBody).get(0).getImage());
            return parseRecipes(responseBody);
        }
    }

    private List<Recipe> parseRecipes(String responseBody) throws IOException {
        // Initialize the list to hold Recipe objects
        List<Recipe> recipesList = new ArrayList<>();

        // Use ObjectMapper to parse JSON array response
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootArray = objectMapper.readTree(responseBody); // Parse response as an array

        for (JsonNode recipeNode : rootArray) {
            try {
                // Extract fields directly from JSON
                int id = recipeNode.get("id").asInt();  // Recipe ID
                String title = recipeNode.get("title").asText();  // Recipe title
                String image = recipeNode.get("image").asText();  // Recipe image link

                // Parse used ingredients
                List<Ingredient> ingredientsList = new ArrayList<>();
                JsonNode usedIngredientsNode = recipeNode.get("usedIngredients");
                if (usedIngredientsNode != null && usedIngredientsNode.isArray()) {
                    for (JsonNode ingredientNode : usedIngredientsNode) {
                        String ingredientName = ingredientNode.get("name").asText();
                        int ingredientId = ingredientNode.get("id").asInt();
                        String unit = ingredientNode.get("unit").asText();

                        // Create Ingredient object
                        IngredientFactory ingredientFactory = new CommonIngredientFactory();
                        ingredientsList.add(ingredientFactory.create(ingredientName, unit, 0));
                    }
                }

                // Fetch recipe URL using `getRecipeInformation`
                String link = new getRecipeInformation().getRecipeURL(id);

                // Create Recipe object using factory
                RecipeFactory recipeFactory = new CommonRecipeFactory();
                Recipe recipe = recipeFactory.create(title, id, ingredientsList, image, link);

                // Add to recipes list
                recipesList.add(recipe);

            } catch (Exception e) {
                // Log error and skip to the next recipe
                System.out.println("Error parsing recipe: " + recipeNode);
                e.printStackTrace();
            }
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


