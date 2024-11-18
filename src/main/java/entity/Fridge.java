package entity;

import entity.exceptions.IngredientNotFoundException;

import java.util.ArrayList;

/**
 * A fridge
 */

public class Fridge {
    private ArrayList<Ingredient> ingredients;

    public Fridge() {
        this.ingredients = new ArrayList<Ingredient>();
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public Boolean hasIngredient(Ingredient ingredient) {
        return ingredients.contains(ingredient);
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient){
        try {
            checkFridge(ingredient);
        } catch (IngredientNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            ingredients.remove(ingredient);
        }
    }

    public void checkFridge(Ingredient ingredient) throws IngredientNotFoundException {
        if (!ingredients.contains(ingredient)) {
            throw new IngredientNotFoundException("This ingredient is not in your fridge!");
        }
    }
}
