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

        // Initialize the FavouriteRecipesView
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel();
        FavouriteRecipesView favouriteRecipesView = new FavouriteRecipesView(viewModel, cardLayout,cardPanel);

        // Set up JFrame to display the view
        JFrame frame = new JFrame("Favourite Recipes View Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.add(favouriteRecipesView);
        frame.setVisible(true);
    }
}