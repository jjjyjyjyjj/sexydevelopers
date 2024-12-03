package interfaceadapter.recipe;

import entity.Recipe;
import entity.User;

/**
 * Controller for Recipe.
 */
public class RecipeController {
    private User user;

    public RecipeController(User user) {
        this.user = user;
    }

    /**
     * Add new recipe to favourite recipes.
     * @param recipe recipe being added
     */
    public void addRecipeToFavourites(Recipe recipe) {
        if (!user.getFavourited().getRecipes().contains(recipe)) {
            user.getFavourited().getRecipes().add(recipe);
            System.out.println("CommonRecipe added to favourites: " + recipe.getName());
        }
        else {
            System.out.println("CommonRecipe already in favourites.");
        }
    }

    /**
     * Removing a recipe from Favourited Recipes.
     * @param recipe recipe being removed
     */
    public void removeRecipeFromFavourites(Recipe recipe) {
        if (user.getFavourited().getRecipes().contains(recipe)) {
            user.getFavourited().getRecipes().remove(recipe);
            System.out.println("CommonRecipe removed from favourites: " + recipe.getName());
        }
        else {
            System.out.println("CommonRecipe not in favourites.");
        }
    }
}
