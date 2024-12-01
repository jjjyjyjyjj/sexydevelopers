package view;

import interface_adapter.LoggedInState;
import interface_adapter.ViewManagerModel;
import interface_adapter.triedRecipes.TriedRecipesViewModel;


import javax.swing.*;
import java.awt.*;

public class TriedRecipesView extends JPanel {

    private final String viewName = "triedRecipes";
    private final TriedRecipesViewModel viewModel;
    private final LoggedInState loggedInState;
    private ViewManagerModel viewManagerModel;

    private JLabel triedRecipesLabel;
    private JButton viewRecipeButton;
    private JButton addToFavoriteButton;

    public TriedRecipesView(TriedRecipesViewModel viewModel, LoggedInState loggedInState) {
        this.viewModel = viewModel;
        this.loggedInState = loggedInState;
        setupUI();
        setupListeners();
    }

    private void setupUI() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.ORANGE);

        NavBarPanel navBar = new NavBarPanel(loggedInState,
                e -> loggedInState.setViewName("home"),
                e -> loggedInState.setViewName("fridge"),
                e -> loggedInState.setViewName("savedForLater"),
                e -> loggedInState.setViewName("triedRecipes"),
                e -> loggedInState.setViewName("favouriteRecipes")
        );
        triedRecipesLabel = new JLabel("Your Tried Recipes");
        triedRecipesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        triedRecipesLabel.setFont(new Font("Arial", Font.BOLD, 24));
        triedRecipesLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 50, 0));

        // Recipe buttons
        viewRecipeButton = new JButton("View Recipe");
        addToFavoriteButton = new JButton("Add to Favourite");

        JPanel recipeButtonPanel = new JPanel();
        recipeButtonPanel.add(viewRecipeButton);
        recipeButtonPanel.add(addToFavoriteButton);
        recipeButtonPanel.setBackground(Color.ORANGE);

        // Adding components
        this.add(triedRecipesLabel);
        this.add(recipeButtonPanel);
        this.add(navBar);
    }

    private void setupListeners() {
        // View Recipe Button
        viewRecipeButton.addActionListener(evt -> {
        });

        // add to Favourite Recipes Button
        addToFavoriteButton.addActionListener(evt -> {
        });
    }

    public String getViewName() {
        return viewName;
    }
}
