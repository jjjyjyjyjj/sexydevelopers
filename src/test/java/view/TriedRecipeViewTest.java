package view;

import javax.swing.*;
import interface_adapter.LoggedInState;
import interface_adapter.triedRecipes.TriedRecipesViewModel;
import view.TriedRecipesView;

import java.awt.*;

public class TriedRecipeViewTest {

    public static void main(String[] args) {
        // Create dummy instances for required dependencies
        LoggedInState loggedInState = new LoggedInState();
        TriedRecipesViewModel viewModel = new TriedRecipesViewModel();

        // Initialize the TriedRecipesView
        TriedRecipesView triedRecipesView = new TriedRecipesView(viewModel, loggedInState);

        // Set up JFrame to display the view
        JFrame frame = new JFrame("Tried Recipe View Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.add(triedRecipesView);
        frame.setVisible(true);
    }
}
