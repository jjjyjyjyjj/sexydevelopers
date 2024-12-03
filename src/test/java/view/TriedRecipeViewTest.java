package view;

import javax.swing.*;
import interfaceadapter.LoggedInState;
import interfaceadapter.triedRecipes.TriedRecipesViewModel;
import view.TriedRecipesView;

import java.awt.*;

public class TriedRecipeViewTest {

    public static void main(String[] args) {
        // Create dummy instances for required dependencies
        LoggedInState loggedInState = new LoggedInState();
        TriedRecipesViewModel viewModel = new TriedRecipesViewModel();

        // Create a CardLayout and a JPanel (cardPanel) for navigation
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Initialize the TriedRecipesView
        TriedRecipesView triedRecipesView = new TriedRecipesView(viewModel, cardLayout, cardPanel);

        // Add TriedRecipesView to the cardPanel
        cardPanel.add(triedRecipesView, "TriedRecipesView");

        // Set up JFrame to display the cardPanel
        JFrame frame = new JFrame("Tried Recipes View Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.add(cardPanel);
        frame.setVisible(true);

        // Show the TriedRecipesView using CardLayout
        cardLayout.show(cardPanel, "TriedRecipesView");
    }
}
