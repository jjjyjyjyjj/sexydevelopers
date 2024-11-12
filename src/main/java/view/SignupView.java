package view;

import interface_adapter.viewModel.SignupViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SignupView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "Sign Up";

    private final SignupViewModel signupviewModel;
    private final JTextField usernameInputField = new JTextField(15);
    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JPasswordField confirmPasswordInputField = new JPasswordField(15);

    private final JButton signUp;
    private final JButton login;

    public SignupView(SignupViewModel signupviewModel) {
        this.signupviewModel = signupviewModel;
        signupviewModel.addPropertyChangeListener(this);

        final LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.USERNAME_LABEL), usernameInputField);
        final LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.PASSWORD_LABEL), passwordInputField);
        final LabelTextPanel confirmPasswordInfo = new LabelTextPanel(
                new JLabel(SignupViewModel.CONFIRM_PASSWORD_LABEL), confirmPasswordInputField);

        final JPanel buttons = new JPanel();
        login = new JButton(signupviewModel.LOGIN_BUTTON_LABEL);
        buttons.add(login);
        signUp = new JButton(signupviewModel.SIGNUP_BUTTON_LABEL);
        buttons.add(signUp);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
