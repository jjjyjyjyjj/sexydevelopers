package use_case.remove_ingredient;

import entity.Fridge;
import entity.Ingredient;
import entity.User;

public interface RemoveIngredientDataAccessInterface {
    /**
     * Updates the system to record this removed ingredient.
     * @param fridge the fridge the ingredient is being removed from.
     * @param ingredient the ingredient being removed.
     */
    void removeIngredient(Fridge fridge, Ingredient ingredient);
}
