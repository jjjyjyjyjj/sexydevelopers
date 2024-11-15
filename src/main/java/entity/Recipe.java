package entity;

import java.util.List;

/**
 * A recipe
 */

public class Recipe {
    private String name;
    private String id;
    private List<Ingredient> ingredients;
    private String image;
    private double calories;
    private double protein;

    public Recipe(String name, String id, List<Ingredient> ingredients, String image) {
        this.name = name;
        this.id = id;
        this.ingredients = ingredients;
        this.image = image;
        this.calories = calories;
        this.protein = protein;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String image() {
        return image;
    }

    public double getCalories() { return calories; }

    public void setCalories(double calories) { this.calories = calories; }

    public double getProtein() { return protein; }

    public void setProtein(double protein) { this.protein = protein; }

}
