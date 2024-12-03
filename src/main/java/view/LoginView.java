package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interfaceadapter.login.LoginController;
import interfaceadapter.login.LoginState;
import interfaceadapter.login.LoginViewModel;

/**
 * The View for when the user is logging into the program.
 */
public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "Login";
    private final LoginViewModel loginViewModel;

    private final JTextField usernameInputField = new JTextField(15);
    private final JLabel usernameErrorField = new JLabel();

    private final JPasswordField passwordInputField = new JPasswordField(15);
    private final JLabel passwordErrorField = new JLabel();

    private final JButton logIn;
    private final JButton signUp;
    private LoginController loginController;

    public LoginView(LoginViewModel loginViewModel) {

        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);
        this.setBackground(Color.orange);
        usernameErrorField.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordErrorField.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel title = new JLabel("Login to PantryPal");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBorder(BorderFactory.createEmptyBorder(30, 0, 100, 0));

        final JPanel inputs = new JPanel();
        inputs.setLayout(new BoxLayout(inputs, BoxLayout.Y_AXIS));

        final JLabel loginLabel = new JLabel("Welcome Back!");
        loginLabel.setAlignmentX(CENTER_ALIGNMENT);
        loginLabel.setForeground(Color.BLACK);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 16));
        loginLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        inputs.add(loginLabel);
        final LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username:"), usernameInputField);
        usernameInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        usernameInfo.setBackground(Color.orange);
        inputs.add(usernameInfo);
        final LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password:"), passwordInputField);
        passwordInfo.setBackground(Color.orange);
        passwordInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputs.add(passwordInfo);

        inputs.add(usernameErrorField);
        inputs.add(passwordErrorField);

        inputs.setAlignmentX(CENTER_ALIGNMENT);
        inputs.setBorder(BorderFactory.createEmptyBorder(0, 0, 165, 0));
        inputs.setBackground(Color.ORANGE);

        logIn = new JButton("Log In");
        logIn.setAlignmentX(CENTER_ALIGNMENT);
        logIn.setPreferredSize(new Dimension(40, 40));

        final JPanel toSignup = new JPanel();
        final JLabel backToSignup = new JLabel("Don't have an account yet?");
        toSignup.add(backToSignup);
        signUp = new JButton("Sign Up");
        toSignup.add(signUp);
        toSignup.setBackground(Color.orange);

        logIn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logIn)) {
                            final LoginState currentState = loginViewModel.getState();

                            loginController.execute(
                                    currentState.getUsername(),
                                    currentState.getPassword()
                            );
                        }
                    }
                }
        );

        signUp.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (loginController != null) {
                            loginController.switchToSignupView();
                        }
                    }
                }
        );

        usernameInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final LoginState currentState = loginViewModel.getState();
                currentState.setUsername(usernameInputField.getText());
                loginViewModel.setState(currentState);
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

        passwordInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final LoginState currentState = loginViewModel.getState();
                currentState.setPassword(new String(passwordInputField.getPassword()));
                loginViewModel.setState(currentState);
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
        this.add(logIn);
        this.add(toSignup);
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
        final LoginState state = (LoginState) evt.getNewValue();
        setFields(state);
        usernameErrorField.setText(state.getLoginError());
    }

    private void setFields(LoginState state) {
        usernameInputField.setText(state.getUsername());
        passwordInputField.setText(state.getPassword());
    }

    /**
     * Returns the View name.
     * @return View name
     */
    public String getViewName() {
        return viewName;
    }

    /**
     * Sets the controller for Login Use Case.
     * @param loginController controller for login use case
     */
    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}
