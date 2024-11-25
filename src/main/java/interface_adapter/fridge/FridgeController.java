package interface_adapter.fridge;

import entity.CommonFridge;
import entity.CommonIngredient;

public class FridgeController {
    private CommonFridge fridge;

    public FridgeController(CommonFridge fridge) {
        this.fridge = fridge;
    }

    // Add ingredient to the fridge
    public void addIngredient(CommonIngredient ingredient) {
        if (!fridge.hasIngredient(ingredient)) {
            fridge.getIngredients().add(ingredient);
            System.out.println("CommonIngredient added to fridge: " + ingredient.getName());
        } else {
            System.out.println("CommonIngredient already exists in fridge.");
        }
    }

    // Remove ingredient from the fridge
    public void removeIngredient(String ingredientId, int quantity) {
        CommonIngredient ingredientToRemove = null;
        for (CommonIngredient ingredient : fridge.getIngredients()) {
            if (ingredient.getId().equals(ingredientId) && ingredient.getQuantity() >= quantity) {
                ingredientToRemove = ingredient;
                break;
            }
        }

        if (ingredientToRemove != null) {
            ingredientToRemove.setQuantity(ingredientToRemove.getQuantity() - quantity);
            System.out.println("Removed " + quantity + " of " + ingredientToRemove.getName() + " from the fridge.");
        } else {
            System.out.println("CommonIngredient not found or insufficient quantity.");
        }
    }
}
