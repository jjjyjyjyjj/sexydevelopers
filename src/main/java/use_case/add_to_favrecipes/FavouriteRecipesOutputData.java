package use_case.add_to_favrecipes;

import entity.*;

import java.util.List;

/**
 * Output Data for the Add to Favourite Recipes Use Case.
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
