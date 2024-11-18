package use_case.favourite_recipes;

import entity.Favourited;
import entity.Recipe;

import java.util.List;

/**
 * Output Data for the Favourite Recipes Use Case.
 */
public class FavouriteRecipesOutputData {

    private final Favourited favourited;
    private final boolean useCaseFailed;

    public FavouriteRecipesOutputData(Favourited favourited, boolean useCaseFailed) {
        this.favourited = favourited;
        this.useCaseFailed = useCaseFailed;
    }

    public List<Recipe> getfavRecipes() {
        return favourited.getFavouritedRecipes();
    }
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}

