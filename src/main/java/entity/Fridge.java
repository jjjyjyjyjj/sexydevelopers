package entity;

import java.util.ArrayList;

public class Fridge {
    private ArrayList<Ingredient> ingredients;

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public Boolean hasIngredient(Ingredient ingredient) {
        return ingredients.contains(ingredient);
    }

    public void addIngredient(Ingredient ingredient) {
        //put stuff here
    }

    public void removeIngredient(String ingredient, int quantity){
        //put stuff here
    }
}

