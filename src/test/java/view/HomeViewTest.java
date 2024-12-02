package view;

import javax.swing.*;
import interface_adapter.LoggedInState;
import interface_adapter.recipeRecommendation.RecipeRecViewModel;
import interface_adapter.saveforlater.SaveForLaterViewModel;
import view.HomeView;

import java.awt.*;

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

