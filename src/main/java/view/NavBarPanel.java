package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class NavBarPanel extends JPanel {
    public NavBarPanel(ActionListener goToHome, ActionListener goToFridge,
                       ActionListener goToSavedForLater, ActionListener goToTriedRecipes) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton homeButton = new JButton("Home");
        JButton fridgeButton = new JButton("Fridge");
        JButton savedForLaterButton = new JButton("Saved For Later");
        JButton triedRecipesButton = new JButton("Tried Recipes");

        homeButton.addActionListener(goToHome);
        fridgeButton.addActionListener(goToFridge);
        savedForLaterButton.addActionListener(goToSavedForLater);
        triedRecipesButton.addActionListener(goToTriedRecipes);

        this.add(homeButton);
        this.add(fridgeButton);
        this.add(savedForLaterButton);
        this.add(triedRecipesButton);
    }
}

