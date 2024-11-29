package view;

import interface_adapter.LoggedInState;
import interface_adapter.ViewManagerModel;

import javax.swing.*;
import java.awt.*;

public class FridgeView extends JPanel {
//    public FridgeView(LoggedInState loggedInState, FridgeViewModel viewManagerModel) {
//        this.setLayout(new BorderLayout());
//
//        // Create navigation bar with actions
//        NavBarPanel navBar = new NavBarPanel(
//                e -> viewManagerModel.setState("home"),
//                e -> viewManagerModel.setState("fridge"),
//                e -> viewManagerModel.setState("savedForLater"),
//                e -> viewManagerModel.setState("triedRecipes")
//        );
//
//        // Add nav bar at the top
//        this.add(navBar, BorderLayout.NORTH);
//
//        // Add placeholder for fridge contents
//        JLabel fridgeLabel = new JLabel("Your Fridge Contents:", JLabel.CENTER);
//        this.add(fridgeLabel, BorderLayout.CENTER);
//    }

    public String getViewName() {
        return "fridge";
    }
}
