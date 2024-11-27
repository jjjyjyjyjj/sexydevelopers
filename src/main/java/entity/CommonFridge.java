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
    public void removeIngredient(Ingredient ingredient) {
        try {
            checkFridge(ingredient);
        } catch (IngredientNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            ingredients.remove(ingredient);
        }
    }

    @Override
    public void checkFridge(Ingredient ingredient) throws IngredientNotFoundException {
        if (!hasIngredient(ingredient)) {
            throw new IngredientNotFoundException("This ingredient is not in your fridge!");
        }
    }
}
