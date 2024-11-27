package interface_adapter.favourite_recipes;

import entity.PantryPalUser;
import entity.Recipe;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class FavouriteRecipesState {
    private User user;
    private List<Recipe> favRecipes = new ArrayList<>();

    public User getUser() {
            return user;
    }

    public List<Recipe> getfavRecipes() {
        return favRecipes;
        }

    public void setFavRecipes(Recipe favRecipe) {
            this.favRecipes.add(favRecipe);
        }
    }

