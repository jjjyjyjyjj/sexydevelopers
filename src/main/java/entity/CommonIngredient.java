package entity;

/**
 * An ingredient
 */

public class CommonIngredient implements Ingredient, Comparable<Ingredient> {

    private final String name;
    private String unit;
    private double quantity;

    public CommonIngredient(String name, String unit, double quantity) {
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return name;
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
    public double getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Ingredient o) {
        return this.getName().compareTo(o.getName());
    }
}
