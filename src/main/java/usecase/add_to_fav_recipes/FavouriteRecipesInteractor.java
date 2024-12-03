package usecase.add_to_fav_recipes;

import entity.Recipe;
import entity.SavedRecipes;
import entity.User;

/**
 * The Add a Recipe to Favourite Recipes List Interactor.
 */
public class FavouriteRecipesInteractor implements FavouriteRecipesInputBoundary {
    private final FavouriteRecipesDataAccessInterface userDataAccessObject;
    private final FavouriteRecipesOutputBoundary userPresenter;

    public FavouriteRecipesInteractor(FavouriteRecipesDataAccessInterface favouriteRecipesDataAccessInterface,
                                    FavouriteRecipesOutputBoundary favouriteRecipesOutputBoundary) {

        this.userDataAccessObject = favouriteRecipesDataAccessInterface;
        this.userPresenter = favouriteRecipesOutputBoundary;

    }

    /**
     * Executes the new recipe to favourite recipes list.
     *
     * @param favouriteRecipesInputData the input data for this use case
     *
     */
    public void execute(FavouriteRecipesInputData favouriteRecipesInputData) {
        User user = favouriteRecipesInputData.getUser();
        SavedRecipes favRecipes = favouriteRecipesInputData.getFavouriteRecipes();
        Recipe toAddRecipe = favouriteRecipesInputData.getTargetRecipe();

        favRecipes.addRecipe(toAddRecipe);
        userDataAccessObject.saveFavouriteRecipes(user, toAddRecipe);

        final FavouriteRecipesOutputData favouriteRecipesOutputData = new FavouriteRecipesOutputData(
                user, false);
        userPresenter.prepareSuccessView(favouriteRecipesOutputData);
    }
}
