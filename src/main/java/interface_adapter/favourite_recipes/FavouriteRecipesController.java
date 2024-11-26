package interface_adapter.favourite_recipes;

import entity.CommonRecipe;
import entity.PantryPalUser;
import use_case.favourite_recipes.FavouriteRecipesInputData;
import use_case.favourite_recipes.FavouriteRecipesInputBoundary;

public class FavouriteRecipesController {
        private final FavouriteRecipesInputBoundary favRecipesUseCaseInteractor;

        public FavouriteRecipesController(FavouriteRecipesInputBoundary favRecipesUseCaseInteractor) {
            this.favRecipesUseCaseInteractor = favRecipesUseCaseInteractor;
        }

    /**
     * Executes the Favourite Recipe Use Case.
     * @param recipe the new recipe that is favourited
     * @param username the username whose favourite recipes list is being changed
     */
        public void execute(CommonRecipe recipe, PantryPalUser username) {
           final FavouriteRecipesInputData favouriteRecipesInputData = new FavouriteRecipesInputData(recipe, username);

           favRecipesUseCaseInteractor.execute(favouriteRecipesInputData);
        }
}

// Responsibility: take the Input Data and execute the use case, looking up information in the Data
//Access object when necessary and manipulating
//Entities. This might create new data that needs
//to be saved in the Data Access layer.
//When complete, create an Output Data object —
//the use case result — and pass it to the
//Presenter.