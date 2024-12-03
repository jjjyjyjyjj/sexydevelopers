package usecase.recipe_recommender;

import java.util.ArrayList;

import entity.Fridge;
import entity.Ingredient;
import entity.User;

/**
 * The Input Data for Recipe Reccomender Use Case.
 */
public class RecipeRecInputData {
    private User currentUser;
    private ArrayList<Ingredient> listIngredients;
    private Fridge userFridge;

    public RecipeRecInputData(User user) {
        this.currentUser = user;
        this.userFridge = user.getFridge();
        this.listIngredients = userFridge.getIngredients();
    }

    /**
     * Returns the current user.
     * @return current user
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Returns the current user's fridge.
     * @return current user's fridge
     */
    public Fridge getFridge() {
        return userFridge;
    }

    /**
     * Returns a list of ingredients in the current user's fridge.
     * @return list of ingredients in current user's fridge
     */
    public ArrayList<Ingredient> getIngredients() {
        return listIngredients;
    }
}
