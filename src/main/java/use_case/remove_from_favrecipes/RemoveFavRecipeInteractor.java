package use_case.remove_from_favrecipes;

import entity.Recipe;
import entity.SavedRecipes;
import entity.User;
import use_case.remove_from_favrecipes.*;

/**
 * The Remove a Recipe from Favourite Recipes List Interactor.
 */

public class RemoveFavRecipeInteractor implements RemoveFavRecipeInputBoundary {
        private final RemoveFavRecipeDataAccessInterface userDataAccessObject;
        private final RemoveFavRecipeOutputBoundary userPresenter;

        public RemoveFavRecipeInteractor(RemoveFavRecipeDataAccessInterface removeFavRecipeDataAccessInterface,
                                          RemoveFavRecipeOutputBoundary removeFavRecipeOutputBoundary) {
            this.userDataAccessObject = removeFavRecipeDataAccessInterface;
            this.userPresenter = removeFavRecipeOutputBoundary;
        }

        // Removing a recipe from the favourite recipes list
        public void execute(RemoveFavRecipeInputData removeFavRecipeInputData, Recipe recipetoremove) {
            User user = removeFavRecipeInputData.getUser();
            SavedRecipes favRecipes = removeFavRecipeInputData.getFavouriteRecipes();
            Recipe toRemoveRecipe = removeFavRecipeInputData.getTargetRecipe();

            if (favRecipes.getRecipes().contains(recipetoremove)) {
                favRecipes.removeRecipe(recipetoremove);
            }

            userDataAccessObject.updateFavouriteRecipes(user,toRemoveRecipe);

            final RemoveFavRecipeOutputData removeFavRecipeOutputData = new RemoveFavRecipeOutputData(
                    user, false);
            userPresenter.prepareSuccessView(removeFavRecipeOutputData);
        }
}
