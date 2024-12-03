package entity;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * The representation of a fridge in our program.
 */

@JsonDeserialize(using = FridgeDeserializer.class)
public interface Fridge {

    /**
     * Returns a list of the ingredients in the fridge.
     * @return a list of the ingredients in the fridge.
     */
    ArrayList<Ingredient> getIngredients();

    /**
     * Returns true if this ingredient is in the fridge, false otherwise.
     * @param ingredient the ingredient being checked for.
     * @return true if this ingredient is in the fridge, false otherwise.
     */
    Boolean hasIngredient(Ingredient ingredient);

    /**
     * Returns true if this ingredient is in the fridge, false otherwise.
     * This function checks by name instead of class.
     * @param name ingredient name
     * @return true if ingredient is present, false otherwsie.
     */
    Boolean hasIngredientByName(String name);

    /**
     * Adds this ingredient to the fridge.
     * @param ingredient the ingredient being added.
     */
    void addIngredient(Ingredient ingredient);

    /**
     * Removes this ingredient from the fridge.
     * @param name the name of the ingredient being removed.
     */
    void removeIngredient(String name);

    /**
     * Converts the Fridge into a string.
     * @return Fridge as a string
     */
    String parseFridge();
}
