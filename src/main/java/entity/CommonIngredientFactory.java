package entity;

public class CommonIngredientFactory implements IngredientFactory {
    /**
     * Creates a new CommonIngredient.
     * @param name the name of the new ingredient
     * @param id the id of the new ingredient
     * @param unit the unit of the new ingredient
     * @param aisle the hypothetical location of the new ingredient in a grocery store
     * @return the new ingredient
     */

    @Override
    public Ingredient create(String name, String id, String unit, String aisle) {
        return new CommonIngredient(name, id, unit, aisle);
    }
}
