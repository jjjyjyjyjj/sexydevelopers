package view;

import interface_adapter.LoggedInState;
import interface_adapter.fridge.FridgeViewModel;

import javax.swing.*;
import java.awt.*;

public class FridgeView extends JPanel {

    private final LoggedInState loggedInState;
    private final FridgeViewModel fridgeViewModel;

    private JLabel fridgeTitleLabel;

    private JButton addIngredientButton;
    private JButton removeIngredientButton;

    public FridgeView(FridgeViewModel fridgeViewModel, LoggedInState loggedInState) {
        this.fridgeViewModel = fridgeViewModel;
        this.loggedInState = loggedInState;
        setupUI();
        setupListeners();
    }

    private void setupUI() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.ORANGE);

        fridgeTitleLabel = new JLabel("Your Fridge");
        fridgeTitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        fridgeTitleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        fridgeTitleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 50, 0));

        // Create navigation bar with actions
        NavBarPanel navBar = new NavBarPanel(
                e -> loggedInState.setViewName("home"),
                e -> loggedInState.setViewName("fridge"),
                e -> loggedInState.setViewName("savedForLater"),
                e -> loggedInState.setViewName("triedRecipes")
        );

        // Add placeholder for fridge contents
        JLabel fridgeContentLabel = new JLabel("Your Fridge Contents:");
        fridgeContentLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        addIngredientButton = new JButton("Add Ingrident");
        removeIngredientButton = new JButton("Remove Ingrident");

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
        //Add Ingredient Button
        addIngredientButton.addActionListener(e -> {
        });

        //Remove Ingredient Button
        removeIngredientButton.addActionListener(e -> {
        });
    }

    public String getViewName() {
        return "fridge";
    }
}
