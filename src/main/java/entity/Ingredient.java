package entity;

/**
 * An ingredient
 */

public class Ingredient {

    private String name;
    private String id;
    private String unit;
    private String aisle;
    private double quantity;

    public Ingredient(String name, String id, String unit, String aisle) {
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

    public String getAisle() {
        return aisle;
    }

    public double getQuantity() {
        return quantity;
    }

}
