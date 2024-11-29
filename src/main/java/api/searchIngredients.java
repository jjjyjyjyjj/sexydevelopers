package api;

import entity.Ingredient;

import java.io.IOException;
import java.util.List;

public class searchIngredients implements  searchIngredientsInterface{
    private static final String API_URL = "https://api.spoonacular.com/recipes";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String APPLICATION_JSON = "application/json";
    private static final String APP_KEY = "your_app_key"; // Replace with your actual key
    private static final int SUCCESS_CODE = 200;

    public static String getAPIKey() {
        return System.getenv(APP_KEY);
    }

    @Override
    public List<Ingredient> findIngredients(String query) throws IOException {
        return null;
    }
}
