package entity;
/**
 * The representation of an ingredient in our program.
 */

public interface Ingredient {

    /**
     * Returns the name of the ingredient.
     * @return the name of the ingredient.
     */
    String getName();

    /**
     * Returns the id of the ingredient.
     * @return the id of the ingredient.
     */
    int getId();

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
     * Returns the aisle the ingredient might appear in in a grocery store.
     * @return the aisle of the ingredient.
     */
    String getAisle();

    /**
     * Sets the aisle the ingredient might appear in in a grocery store.
     * @param aisle the aisle of the ingredient.
     */
    void setAisle(String aisle);

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
}
