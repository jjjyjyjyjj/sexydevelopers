package use_case.reciperecommender;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RecipeReccomenderTest2 {

    public static void main(String[] args) {
        String apiUrl = "https://api.spoonacular.com/recipes/findByIngredients";
        String ingredients = "bread crumbs,milk,eggs";
        String apiKey = "00ab640014494f1ab81008310af8ec28";

        String url = String.format("%s?ingredients=%s&number=5&ranking=2&ignorePantry=true&apiKey=%s",
                apiUrl, ingredients, apiKey);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            // '200' indicates a success
            System.out.println("Response Code: " + response.code());
            System.out.println("Response Body: " + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//
//        public static void main(String[] args) {
//            try {
//                // 1. Mock or create sample ingredients
//                ArrayList<Ingredient> ingredients = new ArrayList<>();
//                Ingredient bread = IngredientFactory.create("bread crumbs",  "", 1);
//                Ingredient milk = IngredientFactory.create("milk",  "", 1);
//                Ingredient egg = IngredientFactory.create("Eggs",  "", 1);
//                ingredients.add(bread);
//                ingredients.add(milk);
//                ingredients.add(egg);
//
//                // 2. Create a recipeFinder instance
//                recipeFinder finder = new recipeFinder();
//
//                List<Recipe> recipes = finder.getRecipeByIngredient(ingredients, 5, 2, true);
//
//                System.out.println("Recommended Recipes:");
//                for (Recipe recipe : recipes) {
//                    System.out.println("Title: " + recipe.getName());
//                    System.out.println("ID: " + recipe.getID());
//                    System.out.println("Image: " + recipe.getImage());
//                    System.out.println("Ingredients:");
//                    for (Ingredient ingredient : recipe.getIngredients()) {
//                        System.out.println(" - " + ingredient.getName());
//                    }
//                    System.out.println("----------------------------------------");
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }

