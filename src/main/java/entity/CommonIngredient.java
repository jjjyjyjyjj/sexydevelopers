package entity;

/**
 * An ingredient
 */

public class CommonIngredient implements Ingredient{

    private final String name;
    private final int id;
    private String unit;
    private String aisle;
    private double quantity;

    public CommonIngredient(String name, int id, String unit, String aisle) {
        this.name = name;
        this.id = id;
        this.unit = unit;
        this.aisle = aisle;
        this.quantity = 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getUnit() {
        return unit;
    }

    @Override
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String getAisle() {
        return aisle;
    }

    @Override
    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    @Override
    public double getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
