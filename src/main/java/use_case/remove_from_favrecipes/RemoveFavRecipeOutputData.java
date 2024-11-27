package use_case.remove_from_favrecipes;

import entity.Recipe;
import entity.SavedRecipes;
import entity.User;

import java.util.List;

/**
 * Output Data for the Add to Favourite Recipes Use Case.
 */
public class RemoveFavRecipeOutputData {
    private final SavedRecipes favourited;
    private final boolean useCaseFailed;

    public RemoveFavRecipeOutputData(User user, boolean useCaseFailed) {
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
