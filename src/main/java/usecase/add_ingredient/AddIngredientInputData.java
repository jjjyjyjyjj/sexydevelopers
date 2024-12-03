package usecase.add_ingredient;

import entity.User;

/**
 * Input Data for Add Ingredient Use Case.
 */
public class AddIngredientInputData {

    private final String name;
    private final String unit;
    private final double quantity;
    private final User user;

    public AddIngredientInputData(String name, String unit, double quantity, User user) {
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
        this.user = user;
    }

    /**
     * Returns name of ingredient.
     * @return name of ingredient
     */
    public String getName() {
        return name;
    }

    /**
     * Returns unit measurement of the ingredient.
     * @return unit measurement
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Return quantity of ingredient user has.
     * @return quantity of ingredient
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * Returns current user.
     * @return user
     */
    public User getUser() {
        return user;
    }
}
