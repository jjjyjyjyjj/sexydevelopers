package view;

import interfaceadapter.LoggedInState;
import interfaceadapter.ViewManagerModel;
import interfaceadapter.triedRecipes.TriedRecipesViewModel;


import javax.swing.*;
import java.awt.*;

public class TriedRecipesView extends JPanel {

    private final String viewName = "triedRecipes";
    private final TriedRecipesViewModel viewModel;
    private final LoggedInState loggedInState;
    private ViewManagerModel viewManagerModel;

    private JLabel triedRecipesLabel;
    private JLabel recipeNameLabel;
    private JLabel recipeImageLabel;
    private JButton viewRecipeButton;
    private JButton addToFavoriteButton;

    public TriedRecipesView(TriedRecipesViewModel viewModel, CardLayout cardLayout, JPanel cardPanel) {
        this.viewModel = viewModel;
        this.loggedInState = new LoggedInState();
        setupUI(cardLayout, cardPanel);
        setupListeners();
    }

    private void setupUI(CardLayout cardLayout, JPanel cardPanel) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.ORANGE);

        NavBarPanel navBar = new NavBarPanel(cardLayout, cardPanel);

        triedRecipesLabel = new JLabel("Your Tried Recipes");
        triedRecipesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        triedRecipesLabel.setFont(new Font("Arial", Font.BOLD, 24));
        triedRecipesLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 50, 0));

        // Recipe Information
        recipeNameLabel = new JLabel("Recipe Name");
        recipeNameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        recipeImageLabel = new JLabel(); // Placeholder for recipe image
        recipeImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Recipe buttons
        viewRecipeButton = new JButton("View Recipe");
        addToFavoriteButton = new JButton("Add to Favourite");

        JPanel recipeButtonPanel = new JPanel();
        recipeButtonPanel.add(viewRecipeButton);
        recipeButtonPanel.add(addToFavoriteButton);
        recipeButtonPanel.setBackground(Color.ORANGE);

        // Adding components
        this.add(triedRecipesLabel);
        this.add(recipeNameLabel);
        this.add(recipeImageLabel);
        this.add(recipeButtonPanel);
        this.add(navBar);
    }

    private void setupListeners() {
        // View Recipe Button
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

        // add to Favourite Recipes Button
        addToFavoriteButton.addActionListener(evt -> {
        });
    }

    public String getViewName() {
        return viewName;
    }
}
