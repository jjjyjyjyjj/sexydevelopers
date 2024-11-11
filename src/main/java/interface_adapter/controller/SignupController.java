package interface_adapter.controller;

import entity.Fridge;
import entity.Recipe;
import entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignupController {

    public User createNewUser(String username, String password, Map<String, Boolean> dietaryPreferences) {
        Fridge fridge = new Fridge();
        int prepTime = 0;
        List<Recipe> favoriteRecipes = List.of();
        User newUser = new User(username, password, dietaryPreferences, fridge, prepTime, favoriteRecipes);
        // Here you might save the user in a database, if needed
        System.out.println("New user created: " + username);
        return newUser;
    }

    // Example of initializing dietary preferences (e.g., vegetarian, gluten-free)
    // Need
    public Map<String, Boolean> setupDietaryPreferences() {
        Map<String, Boolean> dietaryPreferences = new HashMap<>();
        dietaryPreferences.put("Vegetarian", true);
        dietaryPreferences.put("Gluten-Free", false);
        return dietaryPreferences;
    }

    /**
     * Initializes prep time for the user. This is an example and can be set dynamically as per user needs.
     *
     * @return the prep time in minutes
     */
    public int setupPrepTime() {
        // You can further modify this to accept dynamic input
        return 30; // Default: user prefers recipes that take 30 minutes or less
    }

    /**
     * Initializes all attributes of a user, including username, password, dietary preferences, prep time, and others.
     *
     * @param username           the username of the user
     * @param password           the password of the user
     * @param dietaryPreferences the dietary preferences of the user (e.g., vegetarian, gluten-free)
     * @param prepTime           the prep time preference for the user (in minutes)
     * @return a fully initialized User object
     */
    public User fullSetup(String username, String password, Map<String, Boolean> dietaryPreferences, int prepTime) {
        // Create a new user using the provided details
        return createNewUser(username, password, dietaryPreferences, prepTime);
    }

    /**
     * Creates a new User object.
     *
     * @param username           the username of the user
     * @param password           the password of the user
     * @param dietaryPreferences the dietary preferences (e.g., vegetarian, gluten-free)
     * @param prepTime           the prep time preference (in minutes)
     * @return a fully initialized User object
     */
    private User createNewUser(String username, String password, Map<String, Boolean> dietaryPreferences, int prepTime) {
        // Initialize fridge (new Fridge) and favoriteRecipes (empty list)
        Fridge fridge;
        fridge = new Fridge();
        List<Recipe> favoriteRecipes = new ArrayList<>();

        // Create and return a User instance
        return new User(username, password, dietaryPreferences, fridge, prepTime, favoriteRecipes);
    }
}