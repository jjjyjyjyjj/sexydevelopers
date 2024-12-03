package use_case.add_ingredient;\
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

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }

    public double getQuantity() {
        return quantity;
    }


    public User getUser() {
        return user;

    }
}
