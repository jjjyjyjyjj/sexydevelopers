package usecase.add_ingredient;

import entity.Fridge;
import entity.Ingredient;
import entity.User;

public interface AddIngredientDataAccessInterface {
    /**
     * Updates the system to record this added ingredient.
     * @param fridge the fridge the ingredient is being added to.
     * @param ingredient the ingredient being added.
     */
    void addIngredient(Fridge fridge, Ingredient ingredient);

    boolean existsByIngredient(Ingredient ingredient, User user);
}
