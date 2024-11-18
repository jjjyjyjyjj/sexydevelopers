package entity;

/**
 * An ingredient
 */

public class CommonIngredient implements Ingredient{

    private final String name;
    private final String id;
    private String unit;
    private String aisle;
    private double quantity;

    public CommonIngredient(String name, String id, String unit, String aisle) {
        this.name = name;
        this.id = id;
        this.unit = unit;
        this.aisle = aisle;
        this.quantity = 0;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public double getQuantity() {
        return quantity;
    }

    public void addQuantity(double quantity) {
        this.quantity += quantity;
    }
}
