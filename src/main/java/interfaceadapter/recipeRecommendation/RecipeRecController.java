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
    public static List<Recipe> getRecipes(PantryPalUser user) throws IOException {

        Fridge fridge = user.getFridge();
        ArrayList<Ingredient> ingredients = fridge.getIngredients();

        recipeFinder finder = new recipeFinder();
        return finder.getRecipeByIngredient(ingredients);
    }
}