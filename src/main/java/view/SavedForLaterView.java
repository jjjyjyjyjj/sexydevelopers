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

import interfaceadapter.LoggedInState;
import interfaceadapter.ViewManagerModel;
import interfaceadapter.saveforlater.SaveForLaterViewModel;

/**
 * The View for Save for Later Recipes.
 */
public class SavedForLaterView extends JPanel {

    private final String viewName = "savedForLater";
    private final SaveForLaterViewModel viewModel;
    private final LoggedInState loggedInState;
    private ViewManagerModel viewManagerModel;

    private JLabel savedRecipesLabel;
    private JButton viewRecipeButton;
    private JButton removeRecipeButton;

    public SavedForLaterView(SaveForLaterViewModel viewModel, CardLayout cardLayout, JPanel cardPanel) {
        this.viewModel = viewModel;
        this.loggedInState = new LoggedInState();
        setupUI(cardLayout, cardPanel);
        setupListeners();
    }

    private void setupUI(CardLayout cardLayout, JPanel cardPanel) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.ORANGE);

        NavBarPanel navBar = new NavBarPanel(cardLayout, cardPanel);
        savedRecipesLabel = new JLabel("Your Saved Recipes");
        savedRecipesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        savedRecipesLabel.setFont(new Font("Arial", Font.BOLD, 24));
        savedRecipesLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 50, 0));

        // Recipe buttons
        viewRecipeButton = new JButton("View Recipe");
        removeRecipeButton = new JButton("Remove Recipe");

        JPanel recipeButtonPanel = new JPanel();
        recipeButtonPanel.add(viewRecipeButton);
        recipeButtonPanel.add(removeRecipeButton);
        recipeButtonPanel.setBackground(Color.ORANGE);

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

    /**
     * Returns the View name.
     * @return View name
     */
    public String getViewName() {
        return viewName;
    }
}
