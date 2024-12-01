package entity;

import entity.exceptions.IngredientNotFoundException;

import java.util.ArrayList;

/**
 * A fridge
 */

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
        return ingredients.contains(ingredient);
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    @Override
    public void removeIngredient(String name) {
        ingredients.removeIf(ingredient -> ingredient.getName().equals(name));
    }
}