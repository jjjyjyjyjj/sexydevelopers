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
import interfaceadapter.fridge.FridgeViewModel;

/**
 * The View for Fridge.
 */
public class FridgeView extends JPanel {

    private final LoggedInState loggedInState;
    private final FridgeViewModel fridgeViewModel;

    private JLabel fridgeTitleLabel;

    private JButton addIngredientButton;
    private JButton removeIngredientButton;

    public FridgeView(FridgeViewModel fridgeViewModel, CardLayout cardLayout, JPanel cardPanel) {
        this.fridgeViewModel = fridgeViewModel;
        this.loggedInState = new LoggedInState();
        setupUI(cardLayout, cardPanel);
        addIngredientButton.addActionListener(e -> {
            System.out.println("NavBarPanel: Switching to Add Ingredient.");
            cardLayout.show(cardPanel, "add ingredient");
        });
    }

    private void setupUI(CardLayout cardLayout, JPanel cardPanel) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.ORANGE);

        fridgeTitleLabel = new JLabel("Your Fridge");
        fridgeTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        fridgeTitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        fridgeTitleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 50, 0));

        // Create navigation bar with actions
        NavBarPanel navBar = new NavBarPanel(cardLayout, cardPanel);

        // Add placeholder for fridge contents
        JLabel fridgeContentLabel = new JLabel("Your Fridge Contents:");
        fridgeContentLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        addIngredientButton = new JButton("Add Ingredient");
        removeIngredientButton = new JButton("Remove Ingredient");

        JPanel fridgeButtonPanel = new JPanel();
        fridgeButtonPanel.add(addIngredientButton);
        fridgeButtonPanel.add(removeIngredientButton);
        fridgeButtonPanel.setBackground(Color.ORANGE);

        this.add(fridgeTitleLabel);
        this.add(fridgeContentLabel);
        this.add(fridgeButtonPanel);
        this.add(navBar);

    }

    private void setupListeners() {
        // Add Ingredient Button
        addIngredientButton.addActionListener(e -> {
        });

        // Remove Ingredient Button
        removeIngredientButton.addActionListener(e -> {
        });
    }


    /**
     * Returns the View name.
     * @return view name
     */
    public String getViewName() {
        return "fridge";
    }
}
