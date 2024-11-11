package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User {
    private String username;
    private String password;

    private Map<String, Boolean> dietaryPreferences;
    private Fridge fridge;
    private int prepTime;
    private List<Recipe> favouriteRecipes;

    public User(String username, String password, Map<String, Boolean> dietaryPreferences, Fridge fridge, int prepTime, List<Recipe> favoriteRecipes) {
        this.username = username;
        this.password = password;
        this.dietaryPreferences = dietaryPreferences;
        this.prepTime = this.prepTime;
        this.fridge = this.fridge;
        this.favouriteRecipes = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList getFavouriteRecipes() {
        return (ArrayList) this.favouriteRecipes;
    }
}
