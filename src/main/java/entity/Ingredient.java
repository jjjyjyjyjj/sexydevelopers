package entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.jetbrains.annotations.NotNull;

/**
 * The representation of an ingredient in our program.
 */
@JsonDeserialize(using = IngredientDeserializer.class)
public interface Ingredient extends Comparable<Ingredient> {

    /**
     * Returns the name of the ingredient.
     * @return the name of the ingredient.
     */
    String getName();

    /**
     * Returns the unit of the ingredient.
     * @return the unit of the ingredient.
     */
    String getUnit();

    /**
     * Sets the id of the ingredient.
     * @param unit the unit of the ingredient.
     */
    void setUnit(String unit);


    /**
     * Returns the quantity of the ingredient.
     * @return the quantity of the ingredient.
     */
    double getQuantity();

    /**
     * Sets the quantity of the ingredient.
     * @param quantity the quantity of the ingredient.
     */
    void setQuantity(double quantity);

    /**
     * Compares Ingredients
     * @param o the ingredient being compared.
     */
    @Override
    int compareTo(@NotNull Ingredient o);
}
