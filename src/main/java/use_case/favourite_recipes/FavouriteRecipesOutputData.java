package use_case.favourite_recipes;

import entity.Favourited;
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

    public String getfavRecipes() {
        return favourited.toString();
    }
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}

