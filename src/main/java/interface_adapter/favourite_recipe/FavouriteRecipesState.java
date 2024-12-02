package interface_adapter.favourite_recipe;

import java.util.ArrayList;
import java.util.List;

import entity.Recipe;
import entity.User;

/**
 * The State for Favourite Recipes.
 */
public class FavouriteRecipesState {
    private User user;
    private List<Recipe> favRecipes = new ArrayList<>();
    private String removeRecipeError;

    /**
     * Return the current user.
     * @return current user
     */
    public User getUser() {
        return user;
    }

    /**
     * Return the list of favourite recipes.
     * @return list of favourite recipes.
     */
    public List<Recipe> getfavRecipes() {
        return favRecipes;
    }

    /**
     * Sets a new favourited recipe to favourite recipes list.
      * @param favRecipe the new recipe
     */
    public void setaddRecipe(Recipe favRecipe) {
        this.favRecipes.add(favRecipe);
    }

    /**
     * Sets the error message that'll appear if an error occurs.
     * @param removeRecipeerror error message
     */
    public void setremoveRecipeError(String removeRecipeerror) {
        this.removeRecipeError = removeRecipeerror;
    }
}

