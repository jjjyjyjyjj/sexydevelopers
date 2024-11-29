package view;

import entity.Recipe;
import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.LoggedInState;
import interface_adapter.logout.LogoutController;
import interface_adapter.recipeRecommendation.RecipeRecViewModel;
import entity.CommonRecipe;

import javax.swing.*;
import java.awt.*;

/**
 * The Home View displaying a single recommended recipe and additional user actions.
 */
public class HomeView extends JPanel {

    private final String viewName = "home";
    private final RecipeRecViewModel viewModel;
    private LogoutController logoutController;
    private ChangePasswordController changePasswordController;
    private final LoggedInState loggedInState;
    private ViewManagerModel viewManagerModel;

    private JLabel recipeNameLabel;
    private JLabel recipeImageLabel;
    private JButton viewRecipeButton;
    private JButton saveRecipeButton;
    private JButton skipRecipeButton;
    private JButton logoutButton;
    private JButton changePasswordButton;

    public HomeView(RecipeRecViewModel viewModel, LoggedInState loggedInState) {
        this.viewModel = viewModel;
        this.loggedInState = loggedInState;
        setupUI();
        setupListeners();
    }

    private void setupUI() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        NavBarPanel navBarPanel = new NavBarPanel(
                e -> viewManagerModel.setState("home"),
                e -> viewManagerModel.setState("fridge"),
                e -> viewManagerModel.setState("savedForLater"),
                e -> viewManagerModel.setState("triedRecipes")
        );

        // Recipe Information
        recipeNameLabel = new JLabel("PantryPal Home");
        recipeNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        recipeImageLabel = new JLabel(); // Placeholder for recipe image
        recipeImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Recipe Buttons
        viewRecipeButton = new JButton("View Recipe");
        saveRecipeButton = new JButton("Save for Later");
        skipRecipeButton = new JButton("Skip");

        JPanel recipeButtonPanel = new JPanel();
        recipeButtonPanel.add(viewRecipeButton);
        recipeButtonPanel.add(saveRecipeButton);
        recipeButtonPanel.add(skipRecipeButton);

        // User Action Buttons
        logoutButton = new JButton("Logout");
        changePasswordButton = new JButton("Change Password");

        JPanel userButtonPanel = new JPanel();
        userButtonPanel.add(changePasswordButton);
        userButtonPanel.add(logoutButton);

        this.add(recipeNameLabel);
        this.add(recipeImageLabel);
        this.add(recipeButtonPanel);
        this.add(userButtonPanel);
        this.add(navBarPanel);
    }

    private void setupListeners() {
        // View Recipe
        viewRecipeButton.addActionListener(evt -> {
            String recipeLink = viewModel.getState().getCurrentRecipe().getLink();
            if (recipeLink != null && !recipeLink.isEmpty()) {
                try {
                    Desktop.getDesktop().browse(new java.net.URI(recipeLink));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Failed to open recipe link.");
                }
            }
        });

        // Save Recipe
        saveRecipeButton.addActionListener(evt -> {
            // TODO: Implement save recipe functionality
        });

        // Skip Recipe
        skipRecipeButton.addActionListener(evt -> {
            // TODO: Implement skip recipe functionality
        });

        // Logout
        logoutButton.addActionListener(evt -> {
            if (logoutController != null) {
                logoutController.execute(loggedInState.getUsername());
            }
        });

        // Change Password
        changePasswordButton.addActionListener(evt -> {
            if (changePasswordController != null) {
                String newPassword = JOptionPane.showInputDialog(this, "Enter new password:");
                if (newPassword != null && !newPassword.trim().isEmpty()) {
                    changePasswordController.execute(newPassword, loggedInState.getUsername());
                }
            }
        });

    }

    public void setLogoutController(LogoutController logoutController) {

        this.logoutController = logoutController;
    }

    public void setChangePasswordController(ChangePasswordController changePasswordController) {
        this.changePasswordController = changePasswordController;
    }

    public String getViewName() {
        return viewName;
    }

    public void updateRecipeDisplay(Recipe recipe) {
        recipeNameLabel.setText(recipe.getName());
        // Load image from recipe.getImage()
        ImageIcon recipeImage = new ImageIcon(recipe.getImage());
        recipeImageLabel.setIcon(recipeImage);
    }
}
