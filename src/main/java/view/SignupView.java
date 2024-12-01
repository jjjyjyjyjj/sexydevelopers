package view;

import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "Sign Up";

    private final SignupViewModel signupViewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField confirmPasswordInputField = new JPasswordField(15);
    private SignupController signupController;

    private final JButton signUp;
    private final JButton login;

    public SignupView(SignupViewModel signupviewModel) {
        this.signupViewModel = signupviewModel;
        signupviewModel.addPropertyChangeListener(this);


        final JLabel title = new JLabel(SignupViewModel.TITLE_LABEL);
        title.setAlignmentX(CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(30, 0, 100, 0));

        final JPanel inputs = new JPanel();
        inputs.setLayout(new BoxLayout(inputs, BoxLayout.Y_AXIS));

final JLabel signupLabel = new JLabel(SignupViewModel.SIGNUP_LABEL);
signupLabel.setAlignmentX(CENTER_ALIGNMENT);
signupLabel.setForeground(Color.BLACK);
signupLabel.setFont(new Font("Arial", Font.BOLD, 16));
signupLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
inputs.add(signupLabel);
        final LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.USERNAME_LABEL), usernameInputField);
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        usernameInfo.setBackground(Color.ORANGE);
        inputs.add(usernameInfo);
        final LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.PASSWORD_LABEL), passwordInputField);
        passwordInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordInfo.setBackground(Color.ORANGE);
        inputs.add(passwordInfo);
        final LabelTextPanel confirmPasswordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.CONFIRM_PASSWORD_LABEL), confirmPasswordInputField);
        confirmPasswordInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        confirmPasswordInfo.setBackground(Color.ORANGE);
        inputs.add(confirmPasswordInfo);

        inputs.setAlignmentX(CENTER_ALIGNMENT);
        inputs.setBorder(BorderFactory.createEmptyBorder(0, 0, 100, 0));
        inputs.setBackground(Color.ORANGE);

        signUp = new JButton(signupviewModel.SIGNUP_BUTTON_LABEL);
        signUp.setAlignmentX(CENTER_ALIGNMENT);
        signUp.setPreferredSize(new Dimension(40,40));

        final JPanel goToLogin = new JPanel();
        final JLabel toLogin = new JLabel("Already have an account?");
        goToLogin.add(toLogin);
        login = new JButton(signupviewModel.LOGIN_BUTTON_LABEL);
        goToLogin.add(login);
        goToLogin.setBackground(Color.ORANGE);

        signUp.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(signUp)) {
                            final SignupState currentState = signupviewModel.getState();

                            signupController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword(),
                                    currentState.getRepeatPassword()
                            );
                        }
                    }
                }
        );

        login.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        signupController.switchToLoginView();
                    }
                }
        );

        addUsernameListener();
        addPasswordListener();
        addRepeatPasswordListener();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(inputs);
        this.add(signUp);
        this.add(goToLogin);

        this.setBackground(Color.ORANGE);
    }

    private void addUsernameListener() {
        usernameInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final SignupState currentState = signupViewModel.getState();
                currentState.setUsername(usernameInputField.getText());
                signupViewModel.setState(currentState);
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
    }

    private void addPasswordListener() {
        passwordInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final SignupState currentState = signupViewModel.getState();
                currentState.setPassword(new String(passwordInputField.getPassword()));
                signupViewModel.setState(currentState);
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
    }

    private void addRepeatPasswordListener() {
        confirmPasswordInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final SignupState currentState = signupViewModel.getState();
                currentState.setRepeatPassword(new String(confirmPasswordInputField.getPassword()));
                signupViewModel.setState(currentState);
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Cancel not implemented yet");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final SignupState state = (SignupState) evt.getNewValue();
        if (state.getUsernameError() != null) {
            JOptionPane.showMessageDialog(this, state.getUsernameError());
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setSignupController(SignupController controller) {
        this.signupController = controller;
    }

}
