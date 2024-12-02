package view;


import interface_adapter.LoggedInState;
import interface_adapter.fridge.FridgeViewModel;
import interface_adapter.saveforlater.SaveForLaterViewModel;

import javax.swing.*;
import java.awt.*;

public class FridgeViewTest {

    public static void main(String[] args) {
        LoggedInState loggedInState = new LoggedInState();
        FridgeViewModel viewModel = new FridgeViewModel();


        // Initialize the SavedForLaterView
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel();

        FridgeView savedForLaterView = new FridgeView(viewModel, cardLayout, cardPanel);

        // Set up JFrame to display the view
        JFrame frame = new JFrame("Fridge View Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.add(savedForLaterView);
        frame.setVisible(true);
    }
}
