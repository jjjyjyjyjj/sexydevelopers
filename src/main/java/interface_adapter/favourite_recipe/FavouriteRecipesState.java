package interface_adapter.favourite_recipe;

import entity.Recipe;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class FavouriteRecipesState {
    private User user;
    private List<Recipe> favRecipes = new ArrayList<>();
    private String removeRecipeError;

    public User getUser() {
            return user;
    }

    public List<Recipe> getfavRecipes() {
        return favRecipes;
        }

    public void setaddRecipe(Recipe favRecipe) {
            this.favRecipes.add(favRecipe);
        }

    public void setremoveRecipeError(String removeRecipeerror) { this.removeRecipeError = removeRecipeerror; }
}

