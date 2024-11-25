package entity;

import entity.exceptions.IngredientNotFoundException;

import java.util.ArrayList;

/**
 * The representation of a fridge in our program.
 */

public interface Fridge {

    /**
     * Returns a list of the ingredients in the fridge.
     * @return a list of the ingredients in the fridge.
     */
    ArrayList<CommonIngredient> getIngredients();

    /**
     * Returns True if this ingredient is in the fridge, False otherwise.
     * @param ingredient the ingredient being checked for.
     * @return True if this ingredient is in the fridge, False otherwise.
     */
    Boolean hasIngredient(CommonIngredient ingredient);

    /**
     * Adds this ingredient to the fridge.
     * @param ingredient the ingredient being added.
     */
    void addIngredient(CommonIngredient ingredient);

    /**
     * Removes this ingredient from the fridge.
     * @param ingredient the ingredient being removed.
     */
    void removeIngredient(CommonIngredient ingredient);

    /**
     * Checks if this ingredient is in the fridge.
     * @param ingredient the ingredient being checked for.
     * @throws IngredientNotFoundException If the fridge does not contain this ingredient.
     */
    void checkFridge(CommonIngredient ingredient) throws IngredientNotFoundException;
}
