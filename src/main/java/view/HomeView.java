package view;

import entity.Ingredient;
import entity.Recipe;
import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;
import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.LoggedInState;
import interface_adapter.logout.LogoutController;
import interface_adapter.recipeRecommendation.RecipeRecViewModel;
import entity.CommonRecipe;
import interface_adapter.saveforlater.SaveForLaterController;
import interface_adapter.saveforlater.SaveForLaterState;
import interface_adapter.saveforlater.SaveForLaterViewModel;
import use_case.add_to_favrecipes.FavouriteRecipesInputBoundary;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Home View displaying a single recommended recipe and additional user actions.
 */
public class HomeView extends JPanel {

    private final String viewName = "home";
    private final RecipeRecViewModel viewModel;

    private LogoutController logoutController;
    private ChangePasswordController changePasswordController;
    private SaveForLaterController saveForLaterController;
    private final LoggedInState loggedInState;
    private ViewManagerModel viewManagerModel;
    private SaveForLaterViewModel saveForLaterViewModel;

    private JLabel homeScreenTitleLabel;
    private JLabel recipeNameLabel;
    private JLabel recipeImageLabel;
    private JButton viewRecipeButton;
    private JButton saveRecipeButton;
    private JButton skipRecipeButton;
    private JButton logoutButton;
    private JButton changePasswordButton;

    public HomeView(RecipeRecViewModel viewModel, CardLayout cardLayout, JPanel cardPanel) {
        this.viewModel = viewModel;
        this.loggedInState = new LoggedInState();
        setupUI(cardLayout, cardPanel);
        setupListeners();
    }

    private void setupUI(CardLayout cardLayout, JPanel cardPanel) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.ORANGE);

        NavBarPanel navBarPanel = new NavBarPanel(cardLayout, cardPanel);

        homeScreenTitleLabel = new JLabel("PantryPal Home Screen");
        homeScreenTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        homeScreenTitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        homeScreenTitleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 50, 0));

        // Recipe Information
        recipeNameLabel = new JLabel("Recipe Name");
        recipeNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        recipeImageLabel = new JLabel(); // Placeholder for recipe image
        recipeImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Recipe Buttons
        viewRecipeButton = new JButton("View Recipe");
        saveRecipeButton = new JButton("Save for Later");
        skipRecipeButton = new JButton("Skip");

        JPanel recipeButtonPanel = new JPanel();
        recipeButtonPanel.setBackground(Color.ORANGE);
        recipeButtonPanel.add(viewRecipeButton);
        recipeButtonPanel.add(saveRecipeButton);
        recipeButtonPanel.add(skipRecipeButton);

        // User Action Buttons
        logoutButton = new JButton("Logout");
        changePasswordButton = new JButton("Change Password");

        JPanel userButtonPanel = new JPanel();
        userButtonPanel.setBackground(Color.ORANGE);
        userButtonPanel.add(changePasswordButton);
        userButtonPanel.add(logoutButton);

        this.add(homeScreenTitleLabel);
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

        saveRecipeButton.addActionListener(
             new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
           if (evt.getSource().equals(saveRecipeButton)) {
               final LoggedInState currentState = saveForLaterViewModel.getState();

             saveForLaterController.execute(
                    viewModel.getState().getCurrentRecipe(),
                    currentState.getUser());
          }
         }
        });

        // Skip Recipe
        //skipRecipeButton.addActionListener(evt -> {
        // TODO: Implement skip recipe functionality
        //});


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
//        recipeNameLabel.setText(recipe.getName());
//        // Load image from recipe.getImage()
//        ImageIcon recipeImage = new ImageIcon(recipe.getImage());
//        recipeImageLabel.setIcon(recipeImage);
//        List<Ingredient> fridgeContents = loggedInState.getFridge(); // Get the fridge contents
//        List<Recipe> recipes = recipeRecViewModel.fetchRecipesByIngredients(fridgeContents);
//        if (!recipes.isEmpty()) {
//            Recipe currentRecipe = recipes.get(0);  // Assuming first recipe for simplicity
//            recipeNameLabel.setText(currentRecipe.getName());
//            ImageIcon recipeImage = new ImageIcon(currentRecipe.getImage());
//            recipeImageLabel.setIcon(recipeImage);
//        } else {
//            recipeNameLabel.setText("No Recipe Found");
//            recipeImageLabel.setIcon(null);
    }
}
