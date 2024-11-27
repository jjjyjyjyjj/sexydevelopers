package use_case.add_to_favrecipes;

import entity.*;

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

    // Adding the new recipe to favourite recipes list
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

    // Removing a recipe from the favourite recipes list
    public void remove(FavouriteRecipesInputData favouriteRecipesInputData, Recipe recipetoremove) {
        User user = favouriteRecipesInputData.getUser();
        SavedRecipes favRecipes = favouriteRecipesInputData.getFavouriteRecipes();
        Recipe toRemoveRecipe = favouriteRecipesInputData.getTargetRecipe();

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