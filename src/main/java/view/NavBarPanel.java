package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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
        this.add(Box.createHorizontalStrut(20)); // Add spacing between buttons
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
        button.setFont(new Font("Arial", Font.BOLD, 14)); // Set font style
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE); // Text color
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                button.setForeground(Color.LIGHT_GRAY); // Change text color on hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                button.setForeground(Color.WHITE); // Revert text color
            }
        });

        return button;
    }
}
