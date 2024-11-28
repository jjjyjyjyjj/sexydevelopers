package use_case.change_quantity;

import entity.Ingredient;
import entity.User;

public interface ChangeQuantityDataAccessInterface {
    /**
     * Updates the system to record this changed quantity.
     * @param amount the amount by which the quantity is being changed.
     * @param ingredient the ingredient whose quantity is being changed.
     */
    void changeQuantity(Double amount, Ingredient ingredient);
}
