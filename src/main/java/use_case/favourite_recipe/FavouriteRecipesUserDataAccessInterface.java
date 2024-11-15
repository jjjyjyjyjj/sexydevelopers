package use_case.favourite_recipe;

import entity.User;

/**
 * The interface of the DAO for the Favourite Recipe Use Case.
 */
public interface FavouriteRecipesUserDataAccessInterface {

    /**
     * Updates the system to record this user's favourite recipes.
     * @param user the user whose favourite recipes is to be updated
     */
    void FavouriteRecipes(User user);
}