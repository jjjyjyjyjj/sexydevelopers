package view;

import interface_adapter.LoggedInState;
import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;

public class TriedRecipesView extends JPanel {
    public TriedRecipesView(LoggedInState loggedInState, ViewManagerModel viewManagerModel) {
        this.setLayout(new BorderLayout());

        // Create navigation bar with actions
        NavBarPanel navBar = new NavBarPanel(
                e -> viewManagerModel.setState("home"),
                e -> viewManagerModel.setState("fridge"),
                e -> viewManagerModel.setState("savedForLater"),
                e -> viewManagerModel.setState("triedRecipes")
        );

        // Add nav bar at the top
        this.add(navBar, BorderLayout.NORTH);

        // Add placeholder for tried recipes
        JLabel triedRecipesLabel = new JLabel("Your Tried Recipes:", JLabel.CENTER);
        this.add(triedRecipesLabel, BorderLayout.CENTER);
    }

    public String getViewName() {
        return "triedRecipes";
    }
}
