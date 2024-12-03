package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * The View for the Navigation Bar Panel.
 */
public class NavBarPanel extends JPanel {

    public NavBarPanel(CardLayout cardLayout, JPanel cardPanel) {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(Color.GRAY);
        this.setPreferredSize(new Dimension(800, 120));
        this.setMaximumSize(new Dimension(800, 210));

        JButton homeButton = createStyledButton("Home");
        JButton fridgeButton = createStyledButton("Fridge");
        JButton savedForLaterButton = createStyledButton("Saved For Later");
        JButton triedRecipesButton = createStyledButton("Tried Recipes");
        JButton favRecipesButton = createStyledButton("Favourite Recipes");

        // Add ActionListeners to directly switch views
        homeButton.addActionListener(e -> {
            System.out.println("NavBarPanel: Switching to Home.");
            cardLayout.show(cardPanel, "home");
        });

        fridgeButton.addActionListener(e -> {
            System.out.println("NavBarPanel: Switching to Fridge.");
            cardLayout.show(cardPanel, "fridge");
        });

        savedForLaterButton.addActionListener(e -> {
            System.out.println("NavBarPanel: Switching to Saved For Later.");
            cardLayout.show(cardPanel, "savedForLater");
        });

        triedRecipesButton.addActionListener(e -> {
            System.out.println("NavBarPanel: Switching to Tried Recipes.");
            cardLayout.show(cardPanel, "triedRecipes");
        });

        favRecipesButton.addActionListener(e -> {
            System.out.println("NavBarPanel: Switching to Favourite Recipes.");
            cardLayout.show(cardPanel, "favouriteRecipes");
        });

        // Add buttons to the navigation bar
        this.add(Box.createHorizontalGlue());
        this.add(homeButton);
        // Add spacing between buttons
        this.add(Box.createHorizontalStrut(20));
        this.add(fridgeButton);
        this.add(Box.createHorizontalStrut(20));
        this.add(savedForLaterButton);
        this.add(Box.createHorizontalStrut(20));
        this.add(triedRecipesButton);
        this.add(Box.createHorizontalStrut(20));
        this.add(favRecipesButton);
        this.add(Box.createHorizontalGlue());
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        // Set font style
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        // Text color
        button.setForeground(Color.WHITE);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                // Change text color on hover
                button.setForeground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                // Revert text color
                button.setForeground(Color.WHITE);
            }
        });

        return button;
    }
}
