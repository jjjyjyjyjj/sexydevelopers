package use_case.favourite_recipes;

import entity.CommonRecipe;
import entity.FavouritedRecipes;
import entity.Recipe;

import java.util.List;

/**
 * Output Data for the Favourite Recipes Use Case.
 */
public class FavouriteRecipesOutputData {

    private final FavouritedRecipes favourited;
    private final boolean useCaseFailed;

    public FavouriteRecipesOutputData(FavouritedRecipes favourited, boolean useCaseFailed) {
        this.favourited = favourited;
        this.useCaseFailed = useCaseFailed;
    }

    public List<Recipe> getfavRecipes() {
        return favourited.getRecipes();
    }
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}

