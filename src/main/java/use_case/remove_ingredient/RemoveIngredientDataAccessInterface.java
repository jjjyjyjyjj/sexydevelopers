package use_case.remove_ingredient;

import entity.Fridge;

public interface RemoveIngredientDataAccessInterface {
    /**
     * Updates the system to record this removed ingredient.
     * @param fridge the fridge the ingredient is being removed from.
     * @param name the name of the ingredient being removed.
     */
    void removeIngredient(Fridge fridge, String name);
}
