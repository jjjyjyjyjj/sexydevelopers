package view;

import interface_adapter.triedRecipes.TriedRecipesController;
import interface_adapter.triedRecipes.TriedRecipesPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TriedRecipesView extends JFrame {
    private TriedRecipesController controller;

    public TriedRecipesView(TriedRecipesController controller) {
        this.controller = controller;
        setTitle("Tried Recipes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void displayTriedRecipes(String username) {
        TriedRecipesPresenter presenter = new TriedRecipesPresenter();
        controller.getTriedRecipes(username, presenter);
    }
}
