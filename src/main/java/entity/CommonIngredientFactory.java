package entity;

/**
 * Factory for creating Common Ingredient entity.
 */
public class CommonIngredientFactory implements IngredientFactory {
    /**
     * Creates a new CommonIngredient.
     * @param name the name of the new ingredient
     * @param unit the unit of the new ingredient
     * @param quantity the quantity of the ingredient
     * @return the new ingredient
     */
    
    public Ingredient create(String name, String unit, double quantity) {
        return new CommonIngredient(name, unit, quantity);
    }
}
