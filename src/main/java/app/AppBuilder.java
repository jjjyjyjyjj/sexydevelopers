package app;

import data_access.FileUserDataAccessObject;
import entity.PantryPalUserFactory;
import entity.UserFactory;
import interfaceadapter.LoggedInState;
import interfaceadapter.favourite_recipe.FavouriteRecipesViewModel;
import interfaceadapter.fridge.FridgeViewModel;
import interfaceadapter.login.LoginController;
import interfaceadapter.login.LoginPresenter;
import interfaceadapter.login.LoginViewModel;
import interfaceadapter.recipeRecommendation.RecipeRecViewModel;
import interfaceadapter.signup.SignupController;
import interfaceadapter.signup.SignupPresenter;
import interfaceadapter.signup.SignupViewModel;
import interfaceadapter.triedRecipes.TriedRecipesController;
import interfaceadapter.triedRecipes.TriedRecipesViewModel;
import interfaceadapter.saveforlater.SaveForLaterViewModel;
import interfaceadapter.ViewManagerModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInteractor;
import use_case.signup.SignupOutputBoundary;
import use_case.tried_recipes.TriedRecipesInteractor;
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
    private FavouriteRecipesView loggedInViewFavouriteRecipes;


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
        loggedInViewHome = new HomeView(recipeRecViewModel, cardLayout, cardPanel);
        cardPanel.add(loggedInViewHome, loggedInViewHome.getViewName());
        System.out.println("AppBuilder: Registered 'home' view in CardLayout.");
        return this;
    }

    public AppBuilder addFridgeView() {
        LoggedInState loggedInState = new LoggedInState();
        FridgeViewModel fridgeViewModel = new FridgeViewModel();
        loggedInViewFridge = new FridgeView(fridgeViewModel, cardLayout, cardPanel);
        cardPanel.add(loggedInViewFridge, loggedInViewFridge.getViewName());
        return this;
    }

    public AppBuilder addFavouritedRecipesView() {
        FavouriteRecipesViewModel favouriteRecipesViewModel = new FavouriteRecipesViewModel();
        loggedInViewFavouriteRecipes = new FavouriteRecipesView(favouriteRecipesViewModel, cardLayout, cardPanel);
        cardPanel.add(loggedInViewFavouriteRecipes, loggedInViewFavouriteRecipes.getViewName());
        return this;
    }

    public AppBuilder addTriedRecipeView() {
        TriedRecipesViewModel triedRecipesViewModel = new TriedRecipesViewModel();
        loggedInViewTriedRecipes = new TriedRecipesView(triedRecipesViewModel, cardLayout, cardPanel);
        cardPanel.add(loggedInViewTriedRecipes, loggedInViewTriedRecipes.getViewName());
        return this;
    }

    public AppBuilder addSavedForLaterView() {
        SaveForLaterViewModel saveForLaterViewModel = new SaveForLaterViewModel();
        loggedInViewSavedForLaters = new SavedForLaterView(saveForLaterViewModel, cardLayout, cardPanel);
        cardPanel.add(loggedInViewSavedForLaters, "savedForLater");
        System.out.println("AppBuilder: Registered 'savedForLater' view in CardLayout.");
        return this;
    }

    public AppBuilder addLoggedInStateListener() {
        loggedInState.addPropertyChangeListener(evt -> {
            if ("viewName".equals(evt.getPropertyName())) {
                String viewName = (String) evt.getNewValue();
                System.out.println("AppBuilder: Switching to view " + viewName);

                cardLayout.show(cardPanel, viewName); // Attempt to switch views
                cardPanel.revalidate();
                cardPanel.repaint();

                // Debug: Check visibility of all components in cardPanel
                for (Component component : cardPanel.getComponents()) {
                    System.out.println("Component: " + component.getClass().getName() +
                            ", Name: " + ((component instanceof SavedForLaterView) ? "savedForLater" : "unknown") +
                            ", Visible: " + component.isVisible());
                }
            }
        });


        // Link the ViewManagerModel to the LoggedInState
        loggedInState.setViewManagerModel(viewManagerModel);

        return this;
    }


    public LoggedInState loggedInState() {
        return loggedInState;
    }

    public AppBuilder addViews() {
        cardPanel.add(loggedInViewHome, "home");
        cardPanel.add(loggedInViewSavedForLaters, "savedForLater");
        System.out.println("AppBuilder: Registered view 'savedForLater' with CardLayout.");
        return this;
    }

    public AppBuilder addLoggedInView() {
        return addHomeView().addTriedRecipeView().addSavedForLaterView().addFridgeView().addFavouritedRecipesView();
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

        application.setMinimumSize(new Dimension(800, 600));

        application.setLocationRelativeTo(null);

        application.add(cardPanel, BorderLayout.CENTER);

        viewManagerModel.setState(signupView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }

}
