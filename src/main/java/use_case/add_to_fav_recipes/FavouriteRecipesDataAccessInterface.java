package use_case.add_to_fav_recipes;

import entity.Recipe;
import entity.User;

public interface FavouriteRecipesDataAccessInterface {
    /**
     * Saves the user.
     * @param user the user to save
     */
    void save(User user);

    /**
     * Updates the system to record this user's new recipe list.
     *
     * @param user the user whose favourited recipes list changed
     * @param newRecipe the recipe that is being added to the list
     */
    void saveFavouriteRecipes(User user, Recipe newRecipe);

    /**
     * Updates the system to update this user's favourite recipes.
     *
     * @param user the user whose favourite recipes list is to be updated
     * @param recipe the recipe that is to be removed from favourite recipes
     */
    void updateFavouriteRecipes(User user, Recipe recipe);

}
