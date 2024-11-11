package interface_adapter.controller;

import entity.Fridge;
import entity.Ingredient;

public class FridgeController {
    private Fridge fridge;

    public FridgeController(Fridge fridge) {
        this.fridge = fridge;
    }

    // Add ingredient to the fridge
    public void addIngredient(Ingredient ingredient) {
        if (!fridge.hasIngredient(ingredient)) {
            fridge.getIngredients().add(ingredient);
            System.out.println("Ingredient added to fridge: " + ingredient.getName());
        } else {
            System.out.println("Ingredient already exists in fridge.");
        }
    }

    // Remove ingredient from the fridge
    public void removeIngredient(String ingredientId, int quantity) {
        Ingredient ingredientToRemove = null;
        for (Ingredient ingredient : fridge.getIngredients()) {
            if (ingredient.getId().equals(ingredientId) && ingredient.getQuantity() >= quantity) {
                ingredientToRemove = ingredient;
                break;
            }
        }

        if (ingredientToRemove != null) {
            ingredientToRemove.setQuantity(ingredientToRemove.getQuantity() - quantity);
            System.out.println("Removed " + quantity + " of " + ingredientToRemove.getName() + " from the fridge.");
        } else {
            System.out.println("Ingredient not found or insufficient quantity.");
        }
    }
}
