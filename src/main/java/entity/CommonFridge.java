package entity;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * A fridge.
 */

@JsonDeserialize(as = CommonFridge.class)
public class CommonFridge implements Fridge {
    private ArrayList<Ingredient> ingredients;

    public CommonFridge() {
        this.ingredients = new ArrayList<Ingredient>();
    }

    @Override
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public Boolean hasIngredient(Ingredient ingredient) {
        for (Ingredient i : ingredients) {
            if (i.getName().equals(ingredient.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean hasIngredientByName(String name) {
        for (Ingredient i : ingredients) {
            if (i.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    @Override
    public void removeIngredient(String name) {
        ingredients.removeIf(ingredient -> ingredient.getName().equals(name));
    }

    @Override
    public String parseFridge() {
        // Directly use 'this.ingredients' to extract the names
        return String.join(", ",
                this.ingredients.stream()
                        // Extract the names
                        .map(Ingredient::getName)
                        // Convert to an array of Strings
                        .toArray(String[]::new));
    }
}
