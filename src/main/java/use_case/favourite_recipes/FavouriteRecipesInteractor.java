package use_case.favourite_recipes;

import entity.CommonRecipe;
import entity.FavouritedRecipes;
import entity.PantryPalUser;

/**
 * The Favourite Recipes Interactor.
 */
public class FavouriteRecipesInteractor implements FavouriteRecipesInputBoundary {
    private final FavouriteRecipesDataAccessInterface userDataAccessObject;
    private final FavouriteRecipesOutputBoundary userPresenter;

    public FavouriteRecipesInteractor(FavouriteRecipesDataAccessInterface favouriteRecipesDataAccessInterface,
                                      FavouriteRecipesOutputBoundary favouriteRecipesOutputBoundary) {
        this.userDataAccessObject = favouriteRecipesDataAccessInterface;
        this.userPresenter = favouriteRecipesOutputBoundary;
    }

    // Adding the new recipe to favourite recipes list
    public void execute(FavouriteRecipesInputData favouriteRecipesInputData) {
        PantryPalUser user = favouriteRecipesInputData.getUser();
        FavouritedRecipes favRecipes = favouriteRecipesInputData.getFavouriteRecipes();
        CommonRecipe toAddRecipe = favouriteRecipesInputData.getTargetRecipe();

        favRecipes.addRecipe(toAddRecipe);
        userDataAccessObject.saveFavouriteRecipes(user, toAddRecipe);

        final FavouriteRecipesOutputData favouriteRecipesOutputData = new FavouriteRecipesOutputData(
                user, false);
        userPresenter.prepareSuccessView(favouriteRecipesOutputData);
    }

    // Removing a recipe from the favourite recipes list
    public void remove(FavouriteRecipesInputData favouriteRecipesInputData, CommonRecipe recipetoremove) {
        PantryPalUser user = favouriteRecipesInputData.getUser();
        FavouritedRecipes favRecipes = favouriteRecipesInputData.getFavouriteRecipes();
        CommonRecipe toRemoveRecipe = favouriteRecipesInputData.getTargetRecipe();

        if (favRecipes.getRecipes().contains(recipetoremove)) {
            favRecipes.removeRecipe(recipetoremove);
        }

        userDataAccessObject.updateFavouriteRecipes(user,toRemoveRecipe);

        final FavouriteRecipesOutputData favouriteRecipesOutputData = new FavouriteRecipesOutputData(
                user, false);
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