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
    private List<RecipeBank> favoriteRecipes;

    public User(String username, String password, Map<String, Boolean> dietaryPreferences) {
        this.username = username;
        this.password = password;
        this.dietaryPreferences = dietaryPreferences;
        this.prepTime = prepTime;
        this.fridge = fridge;
        this.favoriteRecipes = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
