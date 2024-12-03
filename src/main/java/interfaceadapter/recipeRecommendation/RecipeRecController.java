package interfaceadapter.recipeRecommendation;

import api.recipeFinder;
import entity.*;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class RecipeRecController {

    /**
     * Retrieves recipes based on the ingredients in the user's fridge.
     *
     * @param user The user whose fridge is used to fetch ingredients.
     * @return A list of recipes recommended based on the fridge's ingredients.
     * @throws IOException If there is an issue with API communication.
     */
    public static List<Recipe> getRecipes(User user) throws IOException {

        Fridge fridge = user.getFridge();
        ArrayList<Ingredient> ingredients = fridge.getIngredients();

        recipeFinder finder = new recipeFinder();
        return finder.getRecipeByIngredient(ingredients);
    }

    public static Recipe getNextRecipe(List<Ingredient> fridgeContents) throws IOException {
        // Log fridge contents for debugging
        System.out.println("Fridge Contents Passed to API: " + fridgeContents);

        if (fridgeContents == null || fridgeContents.isEmpty()) {
            System.out.println("Fridge is empty. Using default ingredients.");
            fridgeContents = List.of(
                    new CommonIngredient("milk", "", 1),
                    new CommonIngredient("eggs", "", 1),
                    new CommonIngredient("flour", "", 1)
            );
        }

        recipeFinder finder = new recipeFinder();
        List<Recipe> recipes = finder.getRecipeByIngredient(new ArrayList<>(fridgeContents));

        if (recipes == null || recipes.isEmpty()) {
            throw new IOException("No recipes available for the given ingredients.");
        }

        // Return the first recipe from the list
        return recipes.get(0);
    }



//    public static Recipe getNextRecipe(List<Ingredient> fridgeContents) {
//        // Return a dummy recipe for testing
//        return new CommonRecipe("Chicken Rice", 1, fridgeContents, "https://www.andy-cooks.com/cdn/shop/articles/20230911192023-andy-20cooks-20-20hainanese-20chicken-20rice_1181x.jpg?v=1694460111", "https://www.andy-cooks.com/blogs/recipes/hainanese-chicken-rice");
//    }


}