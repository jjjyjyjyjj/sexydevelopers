package view;

import api.summarizeRecipe;
import data_access.FileUserDataAccessObject;
import entity.Recipe;
import interfaceadapter.ViewManagerModel;
import interfaceadapter.change_password.ChangePasswordController;
import interfaceadapter.LoggedInState;
import interfaceadapter.logout.LogoutController;
import interfaceadapter.recipeRecommendation.RecipeRecViewModel;
import interfaceadapter.recipeRecommendation.RecipeRecController;
import interfaceadapter.saveforlater.SaveForLaterController;
import interfaceadapter.saveforlater.SaveForLaterViewModel;
import interfaceadapter.triedRecipes.TriedRecipesController;
import interfaceadapter.triedRecipes.TriedRecipesViewModel;
import usecase.tried_recipes.TriedRecipesInteractor;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Home View displaying a single recommended recipe and additional user actions.
 */
public class HomeView extends JPanel {

    private final String viewName = "home";
    private final RecipeRecViewModel viewModel;
    private final summarizeRecipe summarizeRecipe;

    private LogoutController logoutController;
    private ChangePasswordController changePasswordController;
    private SaveForLaterController saveForLaterController;
    private final LoggedInState loggedInState;
    private ViewManagerModel viewManagerModel;
    private SaveForLaterViewModel saveForLaterViewModel;

    private JLabel homeScreenTitleLabel;
    private JLabel recipeNameLabel;
    private JLabel recipeImageLabel;
    private JLabel recipeDescriptionLabel;
    private JButton tryRecipeButton;
    private JButton viewRecipeButton;
    private JButton saveRecipeButton;
    private JButton skipRecipeButton;
    private JButton logoutButton;
    private JButton changePasswordButton;

    public HomeView(RecipeRecViewModel viewModel, CardLayout cardLayout, JPanel cardPanel, LoggedInState loggedInState) {
        this.viewModel = viewModel;
        this.loggedInState = new LoggedInState();
        System.out.println("LoggedInState in HomeView: " + System.identityHashCode(loggedInState));
        this.summarizeRecipe = new summarizeRecipe();
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
        recipeNameLabel.setFont(new Font("Arial", Font.BOLD, 18));

        recipeImageLabel = new JLabel(); // Placeholder for recipe image
        recipeImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        recipeImageLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        recipeDescriptionLabel = new JLabel("Recipe Description");
        recipeDescriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        recipeDescriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Recipe Buttons
        viewRecipeButton = new JButton("View Recipe");
        tryRecipeButton = new JButton("Try Recipe");
        saveRecipeButton = new JButton("Save for Later");
        skipRecipeButton = new JButton("Skip");

        JPanel recipeButtonPanel = new JPanel();
        recipeButtonPanel.setBackground(Color.ORANGE);
        recipeButtonPanel.add(viewRecipeButton);
        recipeButtonPanel.add(tryRecipeButton);
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
        this.add(recipeDescriptionLabel);
        this.add(recipeButtonPanel);
        this.add(userButtonPanel);
        this.add(navBarPanel);
    }

    private void setupListeners() {
        System.out.println("LoggedInState in HomeView: " + System.identityHashCode(loggedInState));

        viewRecipeButton.addActionListener(evt -> {
            Recipe currentRecipe = loggedInState.getCurrentRecipe();  // Use loggedInState to get currentRecipe

            if (currentRecipe != null) {
                String recipeLink = currentRecipe.getLink();  // Get the recipe's link
                if (recipeLink != null && !recipeLink.isEmpty()) {
                    try {
                        Desktop.getDesktop().browse(new java.net.URI(recipeLink));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Failed to open recipe link. Please try again.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No recipe link available.",
                            "No Link Found", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No recipe selected. Please try again later.",
                        "No Recipe", JOptionPane.WARNING_MESSAGE);
            }
        });



        try {
            // Instantiate FileUserDataAccessObject with proper exception handling
            FileUserDataAccessObject userDao = new FileUserDataAccessObject("users.json");

            // Create TriedRecipesController with the user DAO and a new TriedRecipesViewModel
            TriedRecipesController triedRecipesController = new TriedRecipesController(
                    new TriedRecipesInteractor(userDao, new TriedRecipesViewModel())
            );

            // Add action listener for "Try Recipe" button
            tryRecipeButton.addActionListener(evt -> {
                Recipe currentRecipe = loggedInState.getCurrentRecipe();
                System.out.println("Try Recipe Button Clicked: Current Recipe = " + (currentRecipe != null ? currentRecipe.getName() : "null"));
                if (currentRecipe != null) {
                    try {
                        loggedInState.getTriedRecipes().addRecipe(currentRecipe); // Add to Tried Recipes
                        System.out.println("Added to Tried Recipes: " + currentRecipe.getName());
                        fetchAndDisplayNextRecipe(); // Move to next recipe
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Failed to add recipe to Tried Recipes.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "No recipe available to try.");
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to initialize user data access. Please try again.");
        }


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

    public void fetchAndDisplayRecipe() throws IOException {
        // Fetch the recommended recipe based on the current fridge
        List<Recipe> recommendedRecipe = RecipeRecController.getRecipes(loggedInState.getUser());

        // Set the current recipe in LoggedInState
        loggedInState.setCurrentRecipe(recommendedRecipe.get(0));

        // Update the UI with the fetched recipe
        updateRecipeDisplay(loggedInState.getCurrentRecipe());
    }

    private void fetchAndDisplayRecipeSummary(int recipeId) {
        new Thread(() -> {
            try {
                // Call the summarizeRecipe API to get the summary
                String summary = summarizeRecipe.getRecipeSummary(recipeId);

                // Update the UI on the Event Dispatch Thread
                SwingUtilities.invokeLater(() -> {
                    // Apply HTML formatting to center the text
                    String centeredSummary = "<html><div style='text-align:center; width:300px;'>" + summary + "</div></html>";
                    recipeDescriptionLabel.setText(centeredSummary);
                });
            } catch (IOException e) {
                e.printStackTrace();
                SwingUtilities.invokeLater(() -> {
                    recipeDescriptionLabel.setText("Failed to load recipe summary.");
                });
            }
        }).start();
    }

    //Holding off for testing purposes:

//    public void updateRecipeDisplay(Recipe recipe) {
//        SwingUtilities.invokeLater(() -> {
//            if (recipe != null) {
//                recipeNameLabel.setText(recipe.getName());
//
//                try {
//                    // Load and display the recipe image
//                    URL imageUrl = new URL(recipe.getImage());
//                    BufferedImage image = ImageIO.read(imageUrl);
//                    ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
//                    recipeImageLabel.setIcon(imageIcon);
//                } catch (Exception e) {
//                    System.out.println("Failed to load image: " + e.getMessage());
//                    recipeImageLabel.setIcon(new ImageIcon("path/to/default_image.jpg"));
//                }
//
//                // Fetch and display the recipe summary
//                fetchAndDisplayRecipeSummary(recipe.getID());
//            } else {
//                recipeNameLabel.setText("No Recipe Found");
//                recipeImageLabel.setIcon(null);
//                recipeDescriptionLabel.setText("No description available.");
//            }
//        });
//    }

    public void updateRecipeDisplay(Recipe recipe) {
        SwingUtilities.invokeLater(() -> {
            if (recipe != null) {
                // Update the current recipe in LoggedInState
                loggedInState.setCurrentRecipe(recipe);

                // Update the UI components
                recipeNameLabel.setText(recipe.getName());

                try {
                    // Load and display the recipe image
                    URL imageUrl = new URL(recipe.getImage());
                    BufferedImage image = ImageIO.read(imageUrl);
                    ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
                    recipeImageLabel.setIcon(imageIcon);
                } catch (Exception e) {
                    System.out.println("Failed to load image: " + e.getMessage());
                    recipeImageLabel.setIcon(new ImageIcon("path/to/default_image.jpg"));
                }

                // Fetch and display the recipe summary
                fetchAndDisplayRecipeSummary(recipe.getID());
            } else {
                // Update the UI to reflect no recipe found
                loggedInState.setCurrentRecipe(null); // Clear the current recipe
                recipeNameLabel.setText("No Recipe Found");
                recipeImageLabel.setIcon(null);
                recipeDescriptionLabel.setText("No description available.");
            }
        });
    }


    private void fetchAndDisplayNextRecipe() {
        try {
            // Log fridge contents for debugging
            System.out.println("Fridge Contents Before API Call: " + loggedInState.getFridgeContents());
            System.out.println("LoggedInState Identity: " + System.identityHashCode(loggedInState));

            Recipe nextRecipe = RecipeRecController.getNextRecipe(loggedInState.getFridgeContents());
            System.out.println("Fetched Next Recipe: " + (nextRecipe != null ? nextRecipe.getName() : "null"));

            if (nextRecipe != null) {
                loggedInState.setCurrentRecipe(nextRecipe); // Update LoggedInState
                updateRecipeDisplay(nextRecipe); // Update UI
            } else {
                JOptionPane.showMessageDialog(this, "No more recipes available.");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Log the exception for debugging
            JOptionPane.showMessageDialog(this, "Failed to fetch the next recipe. Please check your internet connection or fridge contents.");
        }
    }







//    public void updateRecipeDisplay(Recipe recipe) {
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



