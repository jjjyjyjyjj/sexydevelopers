package use_case.remove_ingredient;

import entity.Fridge;
import entity.Ingredient;
import entity.User;

public class RemoveIngredientInputData {
    private final String name;
    private final Fridge fridge;

    public RemoveIngredientInputData(String name, Fridge fridge) {
        this.name = name;
        this.fridge = fridge;
    }

    public String getName() {
        return name;
    }

    public Fridge getFridge() {
        return fridge;
    }
}
