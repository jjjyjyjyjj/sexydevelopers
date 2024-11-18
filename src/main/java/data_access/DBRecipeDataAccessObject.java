package data_access;

import entity.Recipe;
import entity.User;
import use_case.favourite_recipes.FavouriteRecipesDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

public class DBRecipeDataAccessObject implements FavouriteRecipesDataAccessInterface, SignupUserDataAccessInterface {
    /**
     * Updates the system to update this user's favourite recipes.
     *
     * @param recipe the recipe that is to be added to favourite recipes
     */
    @Override
    public void FavouriteRecipes(Recipe recipe) {

    }

    /**
     * Checks if given recipe is in user's favpurited recipe list.
     *
     * @param recipe the recipe to look for
     * @param user   the user whose list we're searching through
     * @return true if recipe is in user's list; false otherwise
     */
    @Override
    public boolean existsByRecipe(Recipe recipe, User user) {
        return false;
    }

    /**
     * Checks if the given username exists.
     *
     * @param username the username to look for
     * @return true if a user with the given username exists; false otherwise
     */
    @Override
    public boolean existsByName(String username) {
        return false;
    }

    /**
     * Saves the user.
     *
     * @param user the user to save
     */
    @Override
    public void save(User user) {

    }
}
