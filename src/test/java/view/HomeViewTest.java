package view;

import javax.swing.*;

import entity.*;
import interfaceadapter.LoggedInState;
import interfaceadapter.recipeRecommendation.RecipeRecController;
import interfaceadapter.recipeRecommendation.RecipeRecViewModel;
import interfaceadapter.triedRecipes.TriedRecipesViewModel;
import view.HomeView;
import view.TriedRecipesView;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeViewTest {
    public static void main(String[] args) {
        // Initialize dependencies
        LoggedInState loggedInState = new LoggedInState();
        System.out.println("LoggedInState in Test: " + System.identityHashCode(loggedInState)); // Debugging statement
        RecipeRecViewModel viewModel = new RecipeRecViewModel();

        // Create a PantryPalUser and populate the fridge
        User user = new PantryPalUser("testUser", "password123");
        Fridge fridge = user.getFridge(); // Fridge is managed via the User
        fridge.addIngredient(new CommonIngredient("milk", "liters", 2));
        fridge.addIngredient(new CommonIngredient("bread crumbs", "cups", 1));
        fridge.addIngredient(new CommonIngredient("eggs", "units", 12));
        fridge.addIngredient(new CommonIngredient("cheese", "grams", 500));
        fridge.addIngredient(new CommonIngredient("butter", "grams", 250));
        fridge.addIngredient(new CommonIngredient("flour", "kilograms", 1));
        fridge.addIngredient(new CommonIngredient("sugar", "kilograms", 2));
        fridge.addIngredient(new CommonIngredient("salt", "grams", 500));
        fridge.addIngredient(new CommonIngredient("chicken", "kilograms", 1.5));
        fridge.addIngredient(new CommonIngredient("rice", "kilograms", 5));
        fridge.addIngredient(new CommonIngredient("onion", "units", 6));
        fridge.addIngredient(new CommonIngredient("garlic", "cloves", 12));
        fridge.addIngredient(new CommonIngredient("tomatoes", "units", 10));
        fridge.addIngredient(new CommonIngredient("potatoes", "kilograms", 2));
        fridge.addIngredient(new CommonIngredient("carrots", "units", 8));
        fridge.addIngredient(new CommonIngredient("mushrooms", "grams", 300));
        fridge.addIngredient(new CommonIngredient("spinach", "grams", 500));
        fridge.addIngredient(new CommonIngredient("broccoli", "units", 3));
        fridge.addIngredient(new CommonIngredient("ground beef", "kilograms", 1));
        fridge.addIngredient(new CommonIngredient("pasta", "kilograms", 1.5));
        fridge.addIngredient(new CommonIngredient("olive oil", "liters", 1));
        fridge.addIngredient(new CommonIngredient("soy sauce", "milliliters", 500));
        fridge.addIngredient(new CommonIngredient("vinegar", "milliliters", 250));
        fridge.addIngredient(new CommonIngredient("bacon", "grams", 200));
        fridge.addIngredient(new CommonIngredient("cream", "milliliters", 300));
        fridge.addIngredient(new CommonIngredient("chocolate", "grams", 400));
        fridge.addIngredient(new CommonIngredient("cocoa powder", "grams", 200));
        fridge.addIngredient(new CommonIngredient("honey", "milliliters", 500));
        fridge.addIngredient(new CommonIngredient("yogurt", "liters", 1));

        System.out.println("Fridge Contents in Test: " + fridge.getIngredients());

        // Create CardLayout and JPanel
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Initialize HomeView
        HomeView homeView = new HomeView(viewModel, cardLayout, cardPanel, loggedInState);

        // Add HomeView to the cardPanel
        cardPanel.add(homeView, "HomeView");

        JScrollPane scrollPane = new JScrollPane(cardPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Set up JFrame to display the cardPanel
        JFrame frame = new JFrame("Home View Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Fetch recipes and set the first recipe in LoggedInState
        try {
            List<Recipe> recipes = RecipeRecController.getRecipes(user); // Pass the User object to fetch recipes
            System.out.println("Fetched Recipes:");
            if (recipes != null && !recipes.isEmpty()) {
                for (Recipe recipe : recipes) {
                    System.out.println(recipe.getName() + " - " + recipe.getImage()); // Log recipe name and image URL
                }

                Recipe firstRecipe = recipes.get(0); // Get the first recipe
                loggedInState.setCurrentRecipe(firstRecipe); // Update the LoggedInState
                System.out.println("Initial Recipe Set: " + firstRecipe.getName());
                homeView.updateRecipeDisplay(firstRecipe); // Update the UI
            } else {
                System.out.println("No recipes found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

