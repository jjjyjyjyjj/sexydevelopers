package usecase.add_ingredient;

import entity.Ingredient;
import entity.User;

public interface AddIngredientDataAccessInterface {

    void save(User user);
    /**
     * Updates the system to record this added ingredient.
     * @param user the user whose fridge the ingredient is being added to.
     * @param ingredient the ingredient being added.
     */

    void addIngredient(User user, Ingredient ingredient);

    boolean existsByIngredient(Ingredient ingredient, User user);
}
