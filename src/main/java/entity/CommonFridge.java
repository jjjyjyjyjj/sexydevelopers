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

    public ArrayList<CommonIngredient> getIngredients() {
        return ingredients;
    }

    public Boolean hasIngredient(CommonIngredient ingredient) {
        return ingredients.contains(ingredient);
    }

    public void addIngredient(CommonIngredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngredient(CommonIngredient ingredient){
        try {
            checkFridge(ingredient);
        } catch (IngredientNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            ingredients.remove(ingredient);
        }
    }

    public void checkFridge(CommonIngredient ingredient) throws IngredientNotFoundException {
        if (!ingredients.contains(ingredient)) {
            throw new IngredientNotFoundException("This ingredient is not in your fridge!");
        }
    }
}
