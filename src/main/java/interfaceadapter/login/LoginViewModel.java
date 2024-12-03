package interfaceadapter.login;

import interfaceadapter.ViewModel;

/**
 * The View Model for the Login View.
 */
public class LoginViewModel extends ViewModel<LoginState> {

    public LoginViewModel() {
        super("Login");
        setState(new LoginState());
    }

}
