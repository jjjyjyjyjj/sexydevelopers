package view;

import interfaceadapter.LoggedInState;
import interfaceadapter.login.LoginState;
import interfaceadapter.login.LoginViewModel;
import interfaceadapter.recipeRecommendation.RecipeRecViewModel;

import javax.swing.*;
import java.awt.*;

public class LoginViewTest {
    public static void main(String[] args) {
        // Create dummy instances for required dependencies
        LoginState loginState = new LoginState();
        LoginViewModel viewModel = new LoginViewModel();

        // Initialize the SavedForLaterView
        LoginView loginView = new LoginView(viewModel);

        // Set up JFrame to display the view
        JFrame frame = new JFrame("Login View Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(loginView);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
