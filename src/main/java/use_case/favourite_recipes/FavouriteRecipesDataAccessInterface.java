package use_case.favourite_recipes;

import entity.CommonRecipe;
import entity.PantryPalUser;
import entity.User;

/**
 * The interface of the DAO for the Favourite CommonRecipe Use Case.
 */
public interface FavouriteRecipesDataAccessInterface {
    /**
     * Saves the user.
     * @param user the user to save
     */
    void save(User user);

    /**
     * Updates the system to record this user's new recipe list
     * @param user the user whose favourited recipes list changed
     */
    void saveFavouriteRecipes(PantryPalUser user, CommonRecipe newRecipe);

    /**
     * Updates the system to update this user's favourite recipes.
     *
     * @param user the user whose favourite recipes list is to be updated
     * @param recipe the recipe that is to be removed from favourite recipes
     */
    void updateFavouriteRecipes(PantryPalUser user, CommonRecipe recipe);

}