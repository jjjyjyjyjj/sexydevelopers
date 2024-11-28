package use_case.remove_ingredient;

import entity.Fridge;
import entity.Ingredient;
import entity.User;

public class RemoveIngredientInputData {
    private final Ingredient ingredient;
    private final Fridge fridge;

    public RemoveIngredientInputData(Ingredient ingredient, Fridge fridge) {
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
