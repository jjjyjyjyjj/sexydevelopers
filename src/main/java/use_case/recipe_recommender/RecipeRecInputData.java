package use_case.recipe_recommender;

import entity.Fridge;
import entity.Ingredient;
import entity.User;

import java.util.ArrayList;


public class RecipeRecInputData {
    private User currentUser;
    private ArrayList<Ingredient> listIngredients;
    private Fridge userFridge;

    public RecipeRecInputData(User user){
        this.currentUser = user;
        this.userFridge = user.getFridge();
        this.listIngredients = userFridge.getIngredients();
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public Fridge getFridge(){
        return userFridge;
    }

    public ArrayList<Ingredient> getIngredients(){

        return listIngredients;
    }
}
