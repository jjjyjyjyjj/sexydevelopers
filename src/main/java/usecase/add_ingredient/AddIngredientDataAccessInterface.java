package usecase.add_ingredient;

import entity.Ingredient;
import entity.User;

/**
 * The DAO for Add Ingredient Use Case.
 */
public interface AddIngredientDataAccessInterface {

    /**
     * Updates the system to save this user.
     * @param user user
     */
    void save(User user);

    /**
     * Updates the system to record this added ingredient.
     * @param user the user whose fridge the ingredient is being added to.
     * @param ingredient the ingredient being added.
     */
    void addIngredient(User user, Ingredient ingredient);

    /**
     * Returns true if ingredient is present in user's fridge, false otherwise.
     * @param ingredient ingredient
     * @param user current user
     * @return true if ingredient is present in user's fridge, false otherwise
     */
    boolean existsByIngredient(Ingredient ingredient, User user);
}
