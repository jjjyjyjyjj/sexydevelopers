//package view;
//
//import javax.swing.*;
//
//import entity.CommonIngredient;
//import entity.Ingredient;
//import entity.IngredientFactory;
//import interface_adapter.LoggedInState;
//import interface_adapter.recipeRecommendation.RecipeRecViewModel;
//import interface_adapter.saveforlater.SaveForLaterViewModel;
//import view.HomeView;
//
//import java.awt.*;
//
//public class HomeViewTest {
//
//    public static void main(String[] args) {
//        // Create dummy instances for required dependencies
//        LoggedInState loggedInState = new LoggedInState();
//        RecipeRecViewModel viewModel = new RecipeRecViewModel();
//
//        // Initialize the SavedForLaterView
//        HomeView homeView = new HomeView(viewModel, loggedInState);
//
//        // Set up JFrame to display the view
//        JFrame frame = new JFrame("Home View Test");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(homeView);
//        frame.setMinimumSize(new Dimension(800, 600));
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//
//        Ingredient bread = IngredientFactory.create("bread crumbs",  "", 1);
//        Ingredient milk = IngredientFactory.create("milk",  "", 1);
//        Ingredient egg = IngredientFactory.create("Eggs",  "", 1);
//
//        // Add some ingredients to the fridge
//        loggedInState.getFridge().addIngredient(bread);
//        loggedInState.getFridge().addIngredient(milk);
//        loggedInState.getFridge().addIngredient(egg);
//
//    }
//}
package view;

import javax.swing.*;

import entity.*;
import interface_adapter.LoggedInState;
import interface_adapter.recipeRecommendation.RecipeRecController;
import interface_adapter.recipeRecommendation.RecipeRecViewModel;
import interface_adapter.saveforlater.SaveForLaterViewModel;
import view.HomeView;

import java.awt.*;
import java.util.List;
import java.io.IOException;

public class HomeViewTest {
    public static void main(String[] args) {
        // Initialize dependencies
        LoggedInState loggedInState = new LoggedInState();
        RecipeRecViewModel viewModel = new RecipeRecViewModel();

        // Create a PantryPalUser object
        PantryPalUser user = new PantryPalUser("testUser", "password123");

        // Add ingredients to the user's fridge
        CommonFridge fridge = user.getFridge();
        fridge.addIngredient(new CommonIngredient("milk", "", 1));
        fridge.addIngredient(new CommonIngredient("bread crumbs", "", 1));
        fridge.addIngredient(new CommonIngredient("eggs", "", 1));

        // Create the CardLayout and JPanel (cardPanel)
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Initialize HomeView
        HomeView homeView = new HomeView(viewModel, cardLayout, cardPanel);

        // Add HomeView to the cardPanel
        cardPanel.add(homeView, "HomeView");

        // Set up JFrame to display the cardPanel
        JFrame frame = new JFrame("Home View Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(cardPanel);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Fetch and display recipes
        try {
            List<Recipe> recipes = RecipeRecController.getRecipes(user);
            if (recipes != null && !recipes.isEmpty()) {
                Recipe recipe = recipes.get(0); // Display the first recipe
                homeView.updateRecipeDisplay(recipe);
            } else {
                System.out.println("No recipes found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

