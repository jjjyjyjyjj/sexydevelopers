package view;

import interface_adapter.LoggedInState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NavBarPanel extends JPanel {

    private final LoggedInState loggedInState;

    public NavBarPanel(LoggedInState loggedInState,ActionListener goToHome, ActionListener goToFridge,
                       ActionListener goToSavedForLater, ActionListener goToTriedRecipes, ActionListener goToFavRecipes) {
        this.loggedInState = loggedInState;
        System.out.println("NavBarPanel initialized with LoggedInState: " + (this.loggedInState != null));

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(Color.GRAY);
        this.setPreferredSize(new Dimension(800, 120));
        this.setMaximumSize(new Dimension(800, 210));


        JButton homeButton = createStyledButton("Home");
        JButton fridgeButton = createStyledButton("Fridge");
        JButton savedForLaterButton = createStyledButton("Saved For Later");
        JButton triedRecipesButton = createStyledButton("Tried Recipes");
        JButton favRecipesButton = createStyledButton("Favourite Recipes");

        homeButton.addActionListener(goToHome);
        fridgeButton.addActionListener(goToFridge);
        savedForLaterButton.addActionListener(e -> {
            System.out.println("NavBarPanel: Saved For Later button clicked.");
            loggedInState.setViewName("savedForLater");
        });

        triedRecipesButton.addActionListener(goToTriedRecipes);
        favRecipesButton.addActionListener(goToFavRecipes);

        // Add buttons to the horizontal button panel
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

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(Color.LIGHT_GRAY); // Change text color on hover
                button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to pointer
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(Color.WHITE); // Revert text color
                button.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Revert cursor
            }
        });


        return button;
    }
}

