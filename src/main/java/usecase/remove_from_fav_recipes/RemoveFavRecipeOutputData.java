package usecase.remove_from_fav_recipes;

import java.util.List;

import entity.Recipe;
import entity.SavedRecipes;
import entity.User;

/**
 * Output Data for the Add to Favourite Recipes Use Case.
 */
public final class RemoveFavRecipeOutputData {
    private final SavedRecipes favourited;
    private final boolean useCaseFailed;

    public RemoveFavRecipeOutputData(User user, boolean useCaseFailed) {
        this.favourited = user.getFavourited();
        this.useCaseFailed = useCaseFailed;
    }

    /**
     * Return the list of favourite recipes of the current use.
     * @return favourite recipes
     */
    public List<Recipe> getfavRecipes() {
        return favourited.getRecipes();
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
