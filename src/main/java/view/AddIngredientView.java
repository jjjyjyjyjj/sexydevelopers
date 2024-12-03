package view;

import interfaceadapter.LoggedInState;
import interfaceadapter.ViewManagerModel;
import interfaceadapter.add_ingredient.AddIngredientController;
import interfaceadapter.add_ingredient.AddIngredientState;
import interfaceadapter.add_ingredient.AddIngredientViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddIngredientView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "add ingredient";
    private final AddIngredientViewModel viewModel;
    private final LoggedInState loggedInState;

    private final JTextField nameField = new JTextField(15);
    private final JLabel nameErrorField = new JLabel();

    private final JTextField unitField = new JTextField(15);

    private final JTextField quantityField = new JTextField(15);

    private final JButton doneButton;
    private final JButton cancelButton;
    private AddIngredientController addIngredientController;

    public AddIngredientView(AddIngredientViewModel viewModel, LoggedInState loggedInState) {
        this.viewModel = viewModel;
        this.loggedInState = loggedInState;

        AddIngredientState state = viewModel.getState();
        viewModel.setState(state);
        this.viewModel.addPropertyChangeListener(this);
        this.setBackground(Color.orange);
        nameErrorField.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel title = new JLabel("Add Ingredient");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(30, 0, 100, 0));

        final JPanel inputs = new JPanel();
        inputs.setLayout(new BoxLayout(inputs, BoxLayout.Y_AXIS));

        final LabelTextPanel nameInfo = new LabelTextPanel(
                new JLabel("Name:"), nameField);
        nameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameInfo.setBackground(Color.orange);
        inputs.add(nameInfo);
        final LabelTextPanel unitInfo = new LabelTextPanel(
                new JLabel("Unit:"), unitField);
        unitInfo.setBackground(Color.orange);
        unitInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputs.add(unitInfo);
        final LabelTextPanel quantityInfo = new LabelTextPanel(
                new JLabel("Quantity:"), quantityField);
        quantityInfo.setBackground(Color.orange);
        quantityInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputs.add(quantityInfo);

        inputs.add(nameErrorField);

        inputs.setAlignmentX(CENTER_ALIGNMENT);
        inputs.setBorder(BorderFactory.createEmptyBorder(0, 0, 165, 0));
        inputs.setBackground(Color.ORANGE);

        doneButton = new JButton("Done");
        doneButton.setAlignmentX(CENTER_ALIGNMENT);
        doneButton.setPreferredSize(new Dimension(40, 40));

        cancelButton = new JButton("Cancel");
        cancelButton.setAlignmentX(CENTER_ALIGNMENT);
        cancelButton.setPreferredSize(new Dimension(40, 40));

        doneButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(doneButton)) {
                            final AddIngredientState currentState = viewModel.getState();

                            addIngredientController.execute(
                                    currentState.getName(),
                                    currentState.getUnit(),
                                    currentState.getQuantity(),
                                    currentState.getUser()
                            );
                        }
                    }
                }
        );
        cancelButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (addIngredientController != null) {
                            addIngredientController.switchToFridgeView();
                        }
                    }
                }
        );

        nameField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final AddIngredientState currentState = viewModel.getState();
                currentState.setName(nameField.getText());
                viewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        unitField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final AddIngredientState currentState = viewModel.getState();
                currentState.setUnit(unitField.getText());
                viewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

        quantityField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final AddIngredientState currentState = viewModel.getState();
                currentState.setQuantity(Integer.parseInt(quantityField.getText()));
                viewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

        this.add(title);
        this.add(inputs);
        this.add(doneButton);
        this.add(cancelButton);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final LoggedInState state = (LoggedInState) evt.getNewValue();
        setFields(state);
        nameErrorField.setText(state.getAddError());
    }

    private void setFields(LoggedInState state) {
        nameField.setText(state.getName());
        unitField.setText(state.getUnit());
        quantityField.setText(String.valueOf(state.getQuantity()));
    }

    public String getViewName() {
        return viewName;
    }

    public void setAddIngredientController(AddIngredientController addIngredientController) {
        this.addIngredientController = addIngredientController;
    }


}
