package view;

import javax.swing.*;
import interface_adapter.LoggedInState;
import interface_adapter.recipeRecommendation.RecipeRecViewModel;
import interface_adapter.saveforlater.SaveForLaterViewModel;
import view.HomeView;

import java.awt.*;

public class HomeViewTest {

    public static void main(String[] args) {
        // Create dummy instances for required dependencies
        LoggedInState loggedInState = new LoggedInState();
        RecipeRecViewModel viewModel = new RecipeRecViewModel();

        // Initialize the SavedForLaterView
        HomeView homeView = new HomeView(viewModel, loggedInState);

        // Set up JFrame to display the view
        JFrame frame = new JFrame("Home View Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(homeView);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
