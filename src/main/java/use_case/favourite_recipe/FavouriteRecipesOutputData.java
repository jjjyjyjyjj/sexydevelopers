package use_case.favourite_recipe;

import entity.Favourited;

public class FavouriteRecipesOutputData {

    private final Favourited favourited;
    private final boolean useCaseFailed;

    public FavouriteRecipesOutputData(Favourited favourited, boolean useCaseFailed) {
        this.favourited = favourited;
        this.useCaseFailed = useCaseFailed;
    }

    public Favourited getFavouriteRecipes() {return favourited; }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}

