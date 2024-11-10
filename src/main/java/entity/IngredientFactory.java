package entity;

public class IngredientFactory {
    /**
     * Creates a new Ingredient.
     * @param name the name of the new ingredient
     * @param id the id of the new ingredient
     * @param unit the unit of the new ingredient
     * @param aisle the hypothetical location of the new ingredient in a grocery store
     * @return the new ingredient
     */
    public Ingredient create(String name, String id, String unit, String aisle) {
        return new Ingredient(name, id, unit, aisle);
    }
}
