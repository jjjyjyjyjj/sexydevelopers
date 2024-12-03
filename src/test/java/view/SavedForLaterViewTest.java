package view;

import javax.swing.*;
import interfaceadapter.LoggedInState;
import interfaceadapter.saveforlater.SaveForLaterViewModel;
import view.SavedForLaterView;

import java.awt.*;

public class SavedForLaterViewTest {

    public static void main(String[] args) {
        // Create dummy instances for required dependencies
        LoggedInState loggedInState = new LoggedInState();
        SaveForLaterViewModel viewModel = new SaveForLaterViewModel();

        // Create a CardLayout and a JPanel (cardPanel) for navigation
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Initialize the SavedForLaterView
        SavedForLaterView savedForLaterView = new SavedForLaterView(viewModel, cardLayout, cardPanel);

        // Add SavedForLaterView to the cardPanel
        cardPanel.add(savedForLaterView, "SavedForLaterView");

        // Set up JFrame to display the cardPanel
        JFrame frame = new JFrame("Saved For Later View Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.add(cardPanel);
        frame.setVisible(true);

        // Show the SavedForLaterView using CardLayout
        cardLayout.show(cardPanel, "SavedForLaterView");
    }
}

