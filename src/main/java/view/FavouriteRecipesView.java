package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaceadapter.ViewManagerModel;
import interfaceadapter.favourite_recipe.FavouriteRecipesViewModel;

/**
 * The View for Favourite Recipes.
 */
public class FavouriteRecipesView extends JPanel {

    private final String viewName = "favouriteRecipes";
    private final FavouriteRecipesViewModel viewModel;
    private ViewManagerModel viewManagerModel;

    private JLabel favRecipesLabel;
    private JButton viewRecipeButton;
    private JButton removeFromFavButton;

    public FavouriteRecipesView(FavouriteRecipesViewModel viewModel, CardLayout cardLayout, JPanel cardPanel) {
        this.viewModel = viewModel;
        setupUI(cardLayout, cardPanel);
        setupListeners();
    }

    private void setupUI(CardLayout cardLayout, JPanel cardPanel) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.ORANGE);

        NavBarPanel navBar = new NavBarPanel(cardLayout, cardPanel);

        favRecipesLabel = new JLabel("Your Favourited Recipes");
        favRecipesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        favRecipesLabel.setFont(new Font("Arial", Font.BOLD, 24));
        favRecipesLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 50, 0));

        // Recipe buttons
        viewRecipeButton = new JButton("View Recipe");
        removeFromFavButton = new JButton("Remove from Favorites");

        JPanel recipeButtonPanel = new JPanel();
        recipeButtonPanel.add(viewRecipeButton);
        recipeButtonPanel.add(removeFromFavButton);
        recipeButtonPanel.setBackground(Color.ORANGE);

        // Adding components
        this.add(favRecipesLabel);
        this.add(recipeButtonPanel);
        this.add(navBar);
    }

    private void setupListeners() {
        // View Recipe Button
        viewRecipeButton.addActionListener(evt -> {
        });

        // Remove Recipe Button
        removeFromFavButton.addActionListener(evt -> {
        });
    }

    /**
     * Returns the View name.
     * @return view name
     */
    public String getViewName() {
        return viewName;
    }
}

