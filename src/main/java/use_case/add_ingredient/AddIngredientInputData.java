package use_case.add_ingredient;

import entity.Fridge;
import entity.Ingredient;
import entity.User;

public class AddIngredientInputData {

    private final Ingredient ingredient;
    private final Fridge fridge;

    public AddIngredientInputData(Ingredient ingredient, Fridge fridge) {
        this.ingredient = ingredient;
        this.fridge = fridge;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Fridge getFridge() {
        return fridge;
    }
}
