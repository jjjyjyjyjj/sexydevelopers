package use_case.favourite_recipes;

import entity.Favourited;
import entity.Recipe;
import entity.User;

/**
 * The Favourite Recipes Interactor.
 */
public class FavouriteRecipesInteractor implements FavouriteRecipesInputBoundary {
    private final User user;
    private final FavouriteRecipesDataAccessInterface userDataAccessObject;
    private final FavouriteRecipesOutputBoundary userPresenter;
    private final Recipe newfavRecipe;

    public FavouriteRecipesInteractor(FavouriteRecipesDataAccessInterface favouriteRecipesDataAccessInterface,
                                      FavouriteRecipesOutputBoundary favouriteRecipesOutputBoundary,
                                      Recipe newfavRecipe, User user) {
        this.userDataAccessObject = favouriteRecipesDataAccessInterface;
        this.userPresenter = favouriteRecipesOutputBoundary;
        this.newfavRecipe = newfavRecipe;
        this.user = user;
    }

    @Override
    public void execute(FavouriteRecipesInputData favouriteRecipesInputData) {
        final Favourited favRecipes = favouriteRecipesInputData.getFavouriteRecipes();
        userDataAccessObject.FavouriteRecipes(user, newfavRecipe);

        final FavouriteRecipesOutputData favouriteRecipesOutputData = new FavouriteRecipesOutputData(
                favRecipes,
                false);
        userPresenter.prepareSuccessView(favouriteRecipesOutputData);
    }
}