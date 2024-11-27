package use_case.favourite_recipes;

import entity.*;

import java.util.List;

/**
 * Output Data for the Favourite Recipes Use Case.
 */
public class FavouriteRecipesOutputData {

    private final SavedRecipes favourited;
    private final boolean useCaseFailed;

    public FavouriteRecipesOutputData(User user, boolean useCaseFailed) {
        this.favourited = user.getFavourited();
        this.useCaseFailed = useCaseFailed;
    }

    public List<Recipe> getfavRecipes() {
        return favourited.getRecipes();
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}

