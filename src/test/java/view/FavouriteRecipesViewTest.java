package view;
import javax.swing.*;
import interface_adapter.LoggedInState;
import interface_adapter.favourite_recipe.FavouriteRecipesViewModel;

import java.awt.*;

public class FavouriteRecipesViewTest {

    public static void main(String[] args) {
        // Create dummy instances for required dependencies
        LoggedInState loggedInState = new LoggedInState();
        FavouriteRecipesViewModel viewModel = new FavouriteRecipesViewModel();

        // Create the CardLayout and JPanel (cardPanel)
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Initialize the FavouriteRecipesView
        FavouriteRecipesView favouriteRecipesView = new FavouriteRecipesView(viewModel, cardLayout, cardPanel);

        // Add FavouriteRecipesView to the cardPanel
        cardPanel.add(favouriteRecipesView, "FavouriteRecipesView");

        // Set up JFrame to display the cardPanel
        JFrame frame = new JFrame("Favourite Recipes View Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.add(cardPanel);
        frame.setVisible(true);

        // Optionally, show the FavouriteRecipesView using the CardLayout
        cardLayout.show(cardPanel, "FavouriteRecipesView");
    }
}
