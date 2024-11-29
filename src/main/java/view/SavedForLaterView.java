package view;

import interface_adapter.LoggedInState;
import interface_adapter.ViewManagerModel;
import interface_adapter.recipeRecommendation.RecipeRecViewModel;
import interface_adapter.saveforlater.SaveForLaterViewModel;


import javax.swing.*;
import java.awt.*;

public class SavedForLaterView extends JPanel {

    private final String viewName = "SavedForLater";
    private final SaveForLaterViewModel viewModel;
    private final LoggedInState loggedInState;
    private ViewManagerModel viewManagerModel;

    private JLabel savedRecipesLabel;
    private JButton viewRecipeButton;
    private JButton removeRecipeButton;

    public SavedForLaterView(SaveForLaterViewModel viewModel, LoggedInState loggedInState) {
        this.viewModel = viewModel;
        this.loggedInState = loggedInState;
        setupUI();
        setupListeners();
    }

    private void setupUI() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        NavBarPanel navBar = new NavBarPanel(
                e -> viewManagerModel.setState("home"),
                e -> viewManagerModel.setState("fridge"),
                e -> viewManagerModel.setState("savedForLater"),
                e -> viewManagerModel.setState("triedRecipes")
        );
        savedRecipesLabel = new JLabel("Your Saved Recipes:");
        savedRecipesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Recipe buttons
        viewRecipeButton = new JButton("View Recipe");
        removeRecipeButton = new JButton("Remove Recipe");

        JPanel recipeButtonPanel = new JPanel();
        recipeButtonPanel.add(viewRecipeButton);
        recipeButtonPanel.add(removeRecipeButton);

        // Adding components
        this.add(savedRecipesLabel);
        this.add(recipeButtonPanel);
        this.add(navBar);
    }

    private void setupListeners() {
        // View Recipe Button
        viewRecipeButton.addActionListener(evt -> {
        });

        // Remove Recipe Button
        removeRecipeButton.addActionListener(evt -> {
        });
    }

    public String getViewName() {
        return "savedForLater";
    }
}
