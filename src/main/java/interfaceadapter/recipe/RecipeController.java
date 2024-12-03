package interfaceadapter.recipe;

import entity.Recipe;
import entity.User;

public class RecipeController {
    private User user;

    public RecipeController(User user) {
        this.user = user;
    }

    // Add recipe to favourites
    public void addRecipeToFavourites(Recipe recipe) {
        if (!user.getFavourited().getRecipes().contains(recipe)) {
            user.getFavourited().getRecipes().add(recipe);
            System.out.println("CommonRecipe added to favourites: " + recipe.getName());
        } else {
            System.out.println("CommonRecipe already in favourites.");
        }
    }

    // Remove recipe from favourites
    public void removeRecipeFromFavourites(Recipe recipe) {
        if (user.getFavourited().getRecipes().contains(recipe)) {
            user.getFavourited().getRecipes().remove(recipe);
            System.out.println("CommonRecipe removed from favourites: " + recipe.getName());
        } else {
            System.out.println("CommonRecipe not in favourites.");
        }
    }
}
