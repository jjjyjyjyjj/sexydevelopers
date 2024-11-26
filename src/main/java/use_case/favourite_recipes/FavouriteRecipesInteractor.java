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

// need to save the data inputted to the list
//Responsibility: take the Input Data and execute
//the use case, looking up information in the Data
//Access object when necessary and manipulating
//Entities. This might create new data that needs
//to be saved in the Data Access layer.
//When complete, create an Output Data object —
//the use case result — and pass it to the
//Presenter.