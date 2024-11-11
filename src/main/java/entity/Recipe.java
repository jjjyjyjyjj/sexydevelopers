package entity;

/**
 * A recipe
 */

public class Recipe {
    private String name;
    private String id;
    private Ingredient[] ingredients;
    private String image;

    public Recipe(String name, String id, Ingredient[] ingredients, String image) {
        this.name = name;
        this.id = id;
        this.ingredients = ingredients;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return id;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public String image() {
        return image;
    }

}
