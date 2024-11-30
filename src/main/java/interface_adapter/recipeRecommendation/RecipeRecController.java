package interface_adapter.recipeRecommendation;

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
    public List<Recipe> getRecipes(User user) throws IOException {
        CommonFridge fridge = new CommonFridge();
        fridge = (CommonFridge) user.getFridge();

        ArrayList<Ingredient> ingredients = fridge.getIngredients();

        recipeFinder finder = new recipeFinder();
        return recipeFinder.getRecipeByIngredient(ingredients, 10, 2, true);
    }

}