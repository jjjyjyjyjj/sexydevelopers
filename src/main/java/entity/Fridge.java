package entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import entity.exceptions.IngredientNotFoundException;

import java.util.ArrayList;

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
     * Returns True if this ingredient is in the fridge, False otherwise.
     * @param ingredient the ingredient being checked for.
     * @return True if this ingredient is in the fridge, False otherwise.
     */
    Boolean hasIngredient(Ingredient ingredient);

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
     */
    String parseFridge();

}
