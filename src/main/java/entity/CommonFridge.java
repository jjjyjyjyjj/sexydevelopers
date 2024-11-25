package entity;

import entity.exceptions.IngredientNotFoundException;

import java.util.ArrayList;

/**
 * A fridge
 */

public class CommonFridge implements Fridge {
    private ArrayList<CommonIngredient> ingredients;

    public CommonFridge() {
        this.ingredients = new ArrayList<CommonIngredient>();
    }

    @Override
    public ArrayList<CommonIngredient> getIngredients() {
        return ingredients;
    }

    @Override
    public Boolean hasIngredient(CommonIngredient ingredient) {
        return ingredients.contains(ingredient);
    }

    @Override
    public void addIngredient(CommonIngredient ingredient) {
        ingredients.add(ingredient);
    }

    @Override
    public void removeIngredient(CommonIngredient ingredient) {
        try {
            checkFridge(ingredient);
        } catch (IngredientNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            ingredients.remove(ingredient);
        }
    }

    @Override
    public void checkFridge(CommonIngredient ingredient) throws IngredientNotFoundException {
        if (!hasIngredient(ingredient)) {
            throw new IngredientNotFoundException("This ingredient is not in your fridge!");
        }
    }
}
