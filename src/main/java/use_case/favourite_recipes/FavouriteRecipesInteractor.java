package use_case.favourite_recipes;

import entity.CommonRecipe;
import entity.FavouritedRecipes;
import entity.PantryPalUser;

/**
 * The Favourite Recipes Interactor.
 */
public class FavouriteRecipesInteractor implements FavouriteRecipesInputBoundary {
    private final PantryPalUser user;
    private final FavouriteRecipesDataAccessInterface userDataAccessObject;
    private final FavouriteRecipesOutputBoundary userPresenter;
    private final CommonRecipe newfavRecipe;

    public FavouriteRecipesInteractor(FavouriteRecipesDataAccessInterface favouriteRecipesDataAccessInterface,
                                      FavouriteRecipesOutputBoundary favouriteRecipesOutputBoundary,
                                      CommonRecipe newfavRecipe, PantryPalUser user) {
        this.userDataAccessObject = favouriteRecipesDataAccessInterface;
        this.userPresenter = favouriteRecipesOutputBoundary;
        this.newfavRecipe = newfavRecipe;
        this.user = user;
    }

    @Override
    public void execute(FavouriteRecipesInputData favouriteRecipesInputData) {
        final FavouritedRecipes favRecipes = favouriteRecipesInputData.getFavouriteRecipes();
        userDataAccessObject.FavouriteRecipes(user, newfavRecipe);

        final FavouriteRecipesOutputData favouriteRecipesOutputData = new FavouriteRecipesOutputData(
                favRecipes,
                false);
        userPresenter.prepareSuccessView(favouriteRecipesOutputData);
    }
}