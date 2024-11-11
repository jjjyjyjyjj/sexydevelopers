package entity;

import java.util.HashMap;
import java.util.Map;

public class Fridge {
    private Map<String, Integer> ingredients = new HashMap<>();

    public static Map<String, Integer> getIngredients() {
        return ingredients;
    }

    public void addIngredient(String ingredient, int quantity) {
        ingredients.put(ingredient, ingredients.getOrDefault(ingredient, 0) + quantity);
    }

    public void removeIngredient(String ingredient, int quantity) {
        if (ingredients.containsKey(ingredient)) {
            int newQuantity = ingredients.get(ingredient) - quantity;
            if (newQuantity > 0) {
                ingredients.put(ingredient, newQuantity);
            } else {
                ingredients.remove(ingredient);
            }
        }
    }

    public boolean hasIngredient(String ingredient) {
        return ingredients.containsKey(ingredient);
    }

    public int getIngredientQuantity(String ingredient) {
        return ingredients.getOrDefault(ingredient, 0);
    }
}
