package interface_adapter.controller;

import entity.Recipe;
import entity.User;

public class RecipeController {
    private User user;

    public RecipeController(User user) {
        this.user = user;
    }

    // Add recipe to favourites
    public void addRecipeToFavourites(Recipe recipe) {
        if (!user.getFavourited().getFavouritedRecipes().contains(recipe)) {
            user.getFavourited().getFavouritedRecipes().add(recipe);
            System.out.println("Recipe added to favourites: " + recipe.getName());
        } else {
            System.out.println("Recipe already in favourites.");
        }
    }

    // Remove recipe from favourites
    public void removeRecipeFromFavourites(Recipe recipe) {
        if (user.getFavourited().getFavouritedRecipes().contains(recipe)) {
            user.getFavourited().getFavouritedRecipes().remove(recipe);
            System.out.println("Recipe removed from favourites: " + recipe.getName());
        } else {
            System.out.println("Recipe not in favourites.");
        }
    }
}
