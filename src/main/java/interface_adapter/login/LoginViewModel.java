package interface_adapter.login;

/**
 * The View Model for the Login View.
 */
public class LoginViewModel extends ViewModel<LoginState> {

    public LoginViewModel() {
        super("log in");
        setState(new LoginState());
    }

}
