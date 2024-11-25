package view;

import interface_adapter.signup.SignupViewModel;
import interface_adapter.triedRecipes.TriedRecipesController;
import interface_adapter.triedRecipes.TriedRecipesPresenter;
import interface_adapter.triedRecipes.TriedRecipesState;
import interface_adapter.triedRecipes.TriedRecipesViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TriedRecipesView extends JPanel {

    private final TriedRecipesViewModel viewModel;

    public TriedRecipesView(TriedRecipesViewModel viewModel) {
        this.viewModel = viewModel;
        setLayout(new BorderLayout());

        final JLabel title = new JLabel(TriedRecipesViewModel.TITLE_LABEL);
        title.setAlignmentX(CENTER_ALIGNMENT);

        JTextArea recipesArea = new JTextArea();
        recipesArea.setEditable(false);
        add(new JScrollPane(recipesArea), BorderLayout.CENTER);

        viewModel.addPropertyChangeListener(evt -> {
            TriedRecipesState state = viewModel.getState();
            recipesArea.setText(String.join("\n", state.getTriedRecipes()));
        });
    }
}
