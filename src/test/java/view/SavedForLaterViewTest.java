package view;

import javax.swing.*;
import interface_adapter.LoggedInState;
import interface_adapter.saveforlater.SaveForLaterViewModel;
import view.SavedForLaterView;

import java.awt.*;

public class SavedForLaterViewTest {

    public static void main(String[] args) {
        // Create dummy instances for required dependencies
        LoggedInState loggedInState = new LoggedInState();
        SaveForLaterViewModel viewModel = new SaveForLaterViewModel();

        // Initialize the SavedForLaterView
        SavedForLaterView savedForLaterView = new SavedForLaterView(viewModel, loggedInState);

        // Set up JFrame to display the view
        JFrame frame = new JFrame("Saved For Later Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(800, 600));
        frame.add(savedForLaterView);
        frame.setVisible(true);
    }
}
