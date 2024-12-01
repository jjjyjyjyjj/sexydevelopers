package entity;

/**
 * Factory for creating ingredients.
 */

public interface IngredientFactory {

    /**
     * Creates a new Ingredient.
     *
     * @param name     the name of the ingredient.
     * @param unit     the unit of the ingredient.
     * @param quantity the quantity of the ingredient
     * @return the new ingredient.
     */
    static Ingredient create(String name, String unit, double quantity) {
        return new CommonIngredient(name, unit, quantity);
    }
}

