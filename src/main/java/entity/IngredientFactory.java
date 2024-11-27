package entity;

/**
 * Factory for creating ingredients.
 */

public interface IngredientFactory {

    /**
     * Creates a new Ingredient.
     * @param name the name of the ingredient.
     * @param id the id of the ingredient.
     * @param unit the unit of the ingredient.
     * @param aisle the aisle of the ingredient.
     * @return the new ingredient.
     */
    Ingredient create(String name, int id, String unit, String aisle);
}
