package use_case.change_quantity;

import entity.Ingredient;
import entity.User;

public class ChangeQuantityInputData {

    private final Ingredient ingredient;
    private final Double amount;

    public ChangeQuantityInputData(Ingredient ingredient, Double amount) {
        this.ingredient = ingredient;
        this.amount = amount;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Double getAmount() {
        return amount;
    }
}
