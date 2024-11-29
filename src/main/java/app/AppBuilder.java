package app;

import data_access.FileUserDataAccessObject;
import entity.PantryPalUserFactory;
import entity.UserFactory;
import interface_adapter.LoggedInState;
import interface_adapter.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.recipeRecommendation.RecipeRecViewModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.triedRecipes.TriedRecipesController;
import interface_adapter.triedRecipes.TriedRecipesViewModel;
import interface_adapter.saveforlater.SaveForLaterController;
import interface_adapter.saveforlater.SaveForLaterViewModel;
import interface_adapter.ViewManagerModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import use_case.triedRecipes.TriedRecipesInteractor;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AppBuilder {

    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    private final UserFactory userFactory = new PantryPalUserFactory();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private final FileUserDataAccessObject userDataAccessObject;
    private TriedRecipesController triedRecipesController;

    private SignupViewModel signupViewModel;
    private SignupView signupView;
    private LoginViewModel loginViewModel;
    private final RecipeRecViewModel recipeRecViewModel = new RecipeRecViewModel();
    private final SaveForLaterViewModel saveForLaterViewModel = new SaveForLaterViewModel();
    private final LoggedInState loggedInState = new LoggedInState();
    private LoginView loginView;
    private HomeView loggedInViewHome;
    private TriedRecipesView loggedInViewTriedRecipes;
    private SavedForLaterView loggedInViewSavedForLaters;
    private FridgeView loggedInViewFridge;


    public AppBuilder() {
        cardPanel.setLayout(cardLayout);

        try {
            String jsonPath = new File("users.json").getAbsolutePath();
            userDataAccessObject = new FileUserDataAccessObject(jsonPath);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize FileUserDataAccessObject");
        }
    }

    public AppBuilder addSignupView() {
        signupViewModel = new SignupViewModel();
        signupView = new SignupView(signupViewModel);
        cardPanel.add(signupView, signupView.getViewName());
        return this;
    }

    public AppBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
        return this;
    }

    public AppBuilder addHomeView() {
        LoggedInState loggedInState = new LoggedInState();
        RecipeRecViewModel recipeRecViewModel = new RecipeRecViewModel();
        loggedInViewHome = new HomeView(recipeRecViewModel, loggedInState);
        cardPanel.add(loggedInViewHome, loggedInViewHome.getViewName());
        return this;
    }

    public AppBuilder addTriedRecipeView() {
        LoggedInState loggedInState = new LoggedInState();
        TriedRecipesViewModel triedRecipesViewModel = new TriedRecipesViewModel();
        loggedInViewTriedRecipes = new TriedRecipesView(loggedInState, viewManagerModel);
        cardPanel.add(loggedInViewTriedRecipes, loggedInViewTriedRecipes.getViewName());
        return this;
    }

    public AppBuilder addSavedForLaterView() {
        loggedInViewSavedForLaters = new SavedForLaterView(saveForLaterViewModel, loggedInState);
        cardPanel.add(loggedInViewSavedForLaters, "savedForLater");
        return this;
    }

    public AppBuilder addLoggedInStateListener() {
        loggedInState.addPropertyChangeListener(evt -> {
            if ("viewName".equals(evt.getPropertyName())) {
                String viewName = (String) evt.getNewValue();
                cardLayout.show(cardPanel, viewName); // Switch views
            }
        });
        return this;
    }

    public LoggedInState loggedInState() {
        return loggedInState;
    }



//    public AppBuilder addFridgeView() {
//        LoggedInState loggedInState = new LoggedInState();
//        FridgeViewModel fridgeViewModel = new FridgeViewModel();
//        loggedInViewFridge = new FridgeView(loggedInState, viewManagerModel);
//        cardPanel.add(loggedInViewFridge, loggedInViewFridge.getViewName());
//        return this;
//    }

    public AppBuilder addLoggedInView() {
        return addHomeView().addTriedRecipeView().addSavedForLaterView();
    }


    public AppBuilder addSignupUseCase() {
        final SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
                signupViewModel, loginViewModel);
        final SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        final SignupController controller = new SignupController(userSignupInteractor);
        signupView.setSignupController(controller);
        return this;
    }

    public AppBuilder addLoginUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                recipeRecViewModel, loginViewModel);

        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

//    public AppBuilder addChangePasswordUseCase() {
//        final ChangePasswordOutputBoundary changePasswordOutputBoundary =
//                new ChangePasswordPresenter(loggedInViewModel);
//
//        final ChangePasswordInputBoundary changePasswordInteractor =
//                new ChangePasswordInteractor(userDataAccessObject, changePasswordOutputBoundary, userFactory);
//
//        final ChangePasswordController changePasswordController =
//                new ChangePasswordController(changePasswordInteractor);
//        loggedInViewHome.setChangePasswordController(changePasswordController);
//        return this;
//    }
//
//    public AppBuilder addLogoutUseCase() {
//        final LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel,
//                loggedInViewModel, loginViewModel);
//
//        final LogoutInputBoundary logoutInteractor =
//                new LogoutInteractor((LogoutUserDataAccessInterface) this.userDataAccessObject, logoutOutputBoundary);
//
//        final LogoutController logoutController = new LogoutController(logoutInteractor);
//        loggedInViewHome.setLogoutController(logoutController);
//        return this;
//    }

    public AppBuilder addTriedRecipesUseCase() {
        TriedRecipesViewModel triedRecipesViewModel = new TriedRecipesViewModel();
        TriedRecipesInteractor interactor = new TriedRecipesInteractor(userDataAccessObject, triedRecipesViewModel);
        this.triedRecipesController = new TriedRecipesController(interactor);

        triedRecipesController.setViewModel(triedRecipesViewModel);
        return this;
    }

    public JFrame build() {
        final JFrame application = new JFrame("PantryPal");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setLocationRelativeTo(null);

        application.add(cardPanel);

        viewManagerModel.setState(signupView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }

}
