package interface_adapter.favourite_recipes;

import entity.PantryPalUser;
import entity.Recipe;

import java.util.ArrayList;
import java.util.List;

public class FavouriteRecipesState {
    private PantryPalUser user;
    private List<Recipe> favRecipes = new ArrayList<>();

    public PantryPalUser getUser() {
            return user;
    }

    public List<Recipe> getfavRecipes() {
        return favRecipes;
        }

    public void setFavRecipes(Recipe favRecipe) {
            this.favRecipes.add(favRecipe);
        }
    }

