package view;


import interfaceadapter.LoggedInState;
import interfaceadapter.fridge.FridgeViewModel;
import interfaceadapter.saveforlater.SaveForLaterViewModel;

import javax.swing.*;
import java.awt.*;

public class FridgeViewTest {

    public static void main(String[] args) {
        // Create dummy instances for required dependencies
        LoggedInState loggedInState = new LoggedInState();
        FridgeViewModel viewModel = new FridgeViewModel();

        // Create the CardLayout and JPanel (cardPanel)
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Initialize the FridgeView
        FridgeView fridgeView = new FridgeView(viewModel, cardLayout, cardPanel);

        // Add FridgeView to the cardPanel
        cardPanel.add(fridgeView, "FridgeView");

        // Set up JFrame to display the cardPanel
        JFrame frame = new JFrame("Fridge View Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.add(cardPanel);
        frame.setVisible(true);

        // Optionally, show the FridgeView using the CardLayout
        cardLayout.show(cardPanel, "FridgeView");
    }
}

