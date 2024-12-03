package interface_adapter.add_ingredient;

/**
 * The state for the Add Ingredient View Model.
 */
public class AddIngredientState {
    private String name = "";
    private String unit = "";
    private double quantity = 0;
    private String addError;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getAddError() {
        return addError;
    }

    public void setAddError(String addError) {
        this.addError = addError;
    }

    @Override
    public String toString() {
        return "AddIngredient{"
                + "name='" + name + '\''
                + ", unit='" + unit + '\''
                + ", quantity='" + quantity + '\''
                + '}';
    }
}
