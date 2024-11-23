package interface_adapter.recipe;

import entity.CommonRecipe;
import entity.PantryPalUser;

public class RecipeController {
    private PantryPalUser user;

    public RecipeController(PantryPalUser user) {
        this.user = user;
    }

    // Add recipe to favourites
    public void addRecipeToFavourites(CommonRecipe recipe) {
        if (!user.getFavourited().getRecipes().contains(recipe)) {
            user.getFavourited().getRecipes().add(recipe);
            System.out.println("CommonRecipe added to favourites: " + recipe.getName());
        } else {
            System.out.println("CommonRecipe already in favourites.");
        }
    }

    // Remove recipe from favourites
    public void removeRecipeFromFavourites(CommonRecipe recipe) {
        if (user.getFavourited().getRecipes().contains(recipe)) {
            user.getFavourited().getRecipes().remove(recipe);
            System.out.println("CommonRecipe removed from favourites: " + recipe.getName());
        } else {
            System.out.println("CommonRecipe not in favourites.");
        }
    }
}
