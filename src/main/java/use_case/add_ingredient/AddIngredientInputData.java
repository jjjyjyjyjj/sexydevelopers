package use_case.add_ingredient;

import entity.Fridge;
import entity.Ingredient;
import entity.User;

public class AddIngredientInputData {

    private final String name;
    private final String unit;
    private final double quantity;
    private final Fridge fridge;

    public AddIngredientInputData(String name, String unit, double quantity, Fridge fridge) {
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
        this.fridge = fridge;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public Fridge getFridge() {
        return fridge;
    }
}
