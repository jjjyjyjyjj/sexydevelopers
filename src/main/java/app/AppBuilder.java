package app;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import data_access.FileUserDataAccessObject;
import entity.CommonIngredientFactory;
import entity.IngredientFactory;
import entity.PantryPalUserFactory;
import entity.UserFactory;
import interfaceadapter.LoggedInState;
import interfaceadapter.LoggedInViewModel;
import interfaceadapter.ViewManagerModel;
import interfaceadapter.add_ingredient.AddIngredientController;
import interfaceadapter.add_ingredient.AddIngredientPresenter;
import interfaceadapter.add_ingredient.AddIngredientViewModel;
import interfaceadapter.favourite_recipe.FavouriteRecipesViewModel;
import interfaceadapter.fridge.FridgeViewModel;
import interfaceadapter.login.LoginController;
import interfaceadapter.login.LoginPresenter;
import interfaceadapter.login.LoginViewModel;
import interfaceadapter.recipeRecommendation.RecipeRecViewModel;
import interfaceadapter.saveforlater.SaveForLaterViewModel;
import interfaceadapter.signup.SignupController;
import interfaceadapter.signup.SignupPresenter;
import interfaceadapter.signup.SignupViewModel;
import interfaceadapter.triedRecipes.TriedRecipesController;
import interfaceadapter.triedRecipes.TriedRecipesViewModel;
import usecase.add_ingredient.AddIngredientInputBoundary;
import usecase.add_ingredient.AddIngredientInteractor;
import usecase.add_ingredient.AddIngredientOutputBoundary;
import usecase.login.LoginInputBoundary;
import usecase.login.LoginInteractor;
import usecase.login.LoginOutputBoundary;
import usecase.signup.SignupInputBoundary;
import usecase.signup.SignupInteractor;
import usecase.signup.SignupOutputBoundary;
import usecase.tried_recipes.TriedRecipesInteractor;
import view.AddIngredientView;
import view.FavouriteRecipesView;
import view.FridgeView;
import view.HomeView;
import view.LoginView;
import view.SavedForLaterView;
import view.SignupView;
import view.TriedRecipesView;
import view.ViewManager;

/**
 * The Application Builder.
 */
public class AppBuilder {

    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    private final UserFactory userFactory = new PantryPalUserFactory();
    private final IngredientFactory ingredientFactory = new CommonIngredientFactory();
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
    private AddIngredientView loggedInViewAddIngredient;
    private AddIngredientPresenter loggedInViewAddIngredientPresenter;
    private AddIngredientInteractor loggedInViewAddIngredientInteractor;
    private AddIngredientViewModel loggedInViewAddIngredientViewModel = new AddIngredientViewModel();
    private LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
    private FridgeViewModel loggedInFridgeViewModel;

    public AppBuilder() {
        cardPanel.setLayout(cardLayout);

        try {
            String jsonPath = new File("users.json").getAbsolutePath();
            userDataAccessObject = new FileUserDataAccessObject(jsonPath);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize FileUserDataAccessObject");
        }
    }

    /**
     * Returns the Signup View.
     * @return signup view
     */
    public AppBuilder addSignupView() {
        signupViewModel = new SignupViewModel();
        signupView = new SignupView(signupViewModel);
        cardPanel.add(signupView, signupView.getViewName());
        return this;
    }

    /**
     * Returns the Login View.
     * @return login view
     */
    public AppBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
        return this;
    }

    /**
     * Returns Home View.
     * @return home view
     */
    public AppBuilder addHomeView() {
        LoggedInState loggedInState = new LoggedInState();
        RecipeRecViewModel recipeRecViewModel;
        recipeRecViewModel = new RecipeRecViewModel();
        loggedInViewHome = new HomeView(recipeRecViewModel, cardLayout, cardPanel, loggedInState);
        cardPanel.add(loggedInViewHome, loggedInViewHome.getViewName());
        System.out.println("AppBuilder: Registered 'home' view in CardLayout.");
        return this;
    }

    /**
     * Returns Fridge View.
     * @return fridge view
     */
    public AppBuilder addFridgeView() {
        LoggedInState loggedInState = new LoggedInState();
        FridgeViewModel fridgeViewModel = new FridgeViewModel();
        loggedInViewFridge = new FridgeView(fridgeViewModel, cardLayout, cardPanel);
        cardPanel.add(loggedInViewFridge, loggedInViewFridge.getViewName());
        return this;
    }

    /**
     * Returns Favourite Recipe View.
     * @return favourite recipe
     */
    public AppBuilder addFavouritedRecipesView() {
        FavouriteRecipesViewModel favouriteRecipesViewModel = new FavouriteRecipesViewModel();
        // Pass the correct parameters: FavouriteRecipesViewModel and LoggedInState
        loggedInViewFavouriteRecipes = new FavouriteRecipesView(favouriteRecipesViewModel, cardLayout, cardPanel);
        cardPanel.add(loggedInViewFavouriteRecipes, loggedInViewFavouriteRecipes.getViewName());
        return this;
    }

    /**
     * Returns Tried Recipes view.
     * @return tried recipes view
     */
    public AppBuilder addTriedRecipeView() {
        TriedRecipesViewModel triedRecipesViewModel = new TriedRecipesViewModel();
        loggedInViewTriedRecipes = new TriedRecipesView(triedRecipesViewModel, cardLayout, cardPanel);
        cardPanel.add(loggedInViewTriedRecipes, loggedInViewTriedRecipes.getViewName());
        return this;
    }

    /**
     * Returns save for later view.
     * @return dave for later view
     */
    public AppBuilder addSavedForLaterView() {
        SaveForLaterViewModel saveForLaterViewModel = new SaveForLaterViewModel();
        loggedInViewSavedForLaters = new SavedForLaterView(saveForLaterViewModel, cardLayout, cardPanel);
        cardPanel.add(loggedInViewSavedForLaters, "savedForLater");
        System.out.println("AppBuilder: Registered 'savedForLater' view in CardLayout.");
        return this;
    }

    /**
     * Returns Logged in State Listener.
     * @return logged in state listener
     */
    public AppBuilder addAddIngredientView() {
        AddIngredientViewModel addIngredientViewModel = new AddIngredientViewModel();
        loggedInViewAddIngredient = new AddIngredientView(addIngredientViewModel, loggedInState);
        cardPanel.add(loggedInViewAddIngredient, loggedInViewAddIngredient.getViewName());
        return this;
    }

    /**
     * Adds a Listener to LoggedinState.
     * @return LoggedinState Listener
     */
    public AppBuilder addLoggedInStateListener() {
        loggedInState.addPropertyChangeListener(evt -> {
            if ("viewName".equals(evt.getPropertyName())) {
                String viewName = (String) evt.getNewValue();
                System.out.println("AppBuilder: Switching to view " + viewName);

                // Attempt to switch views
                cardLayout.show(cardPanel, viewName);
                cardPanel.revalidate();
                cardPanel.repaint();

                // Debug: Check visibility of all components in cardPanel
                for (Component component : cardPanel.getComponents()) {
                    System.out.println("Component: " + component.getClass().getName()
                            + ", Name: " + ((component instanceof SavedForLaterView) ? "savedForLater" : "unknown")
                            + ", Visible: " + component.isVisible());
                }
            }
        });

        // Link the ViewManagerModel to the LoggedInState
        loggedInState.setViewManagerModel(viewManagerModel);
        return this;
    }

    /**
     * Returns the Logged in State.
     * @return logged in state
     */
    public LoggedInState loggedInState() {
        return loggedInState;
    }

    /**
     * Adds the View classes to the application.
     * @return view classes
     */
    public AppBuilder addViews() {
        cardPanel.add(loggedInViewHome, "home");
        cardPanel.add(loggedInViewSavedForLaters, "savedForLater");
        System.out.println("AppBuilder: Registered view 'savedForLater' with CardLayout.");
        return this;
    }

    /**
     * Adds Logged in View to the application.
     * @return logged in view
     */
    public AppBuilder addLoggedInView() {
        return addHomeView().addTriedRecipeView().addSavedForLaterView().addFridgeView()
                .addAddIngredientView().addFavouritedRecipesView();
    }

    /**
     * Adds Sign up Use Case to the application.
     * @return sign up use case
     */
    public AppBuilder addSignupUseCase() {
        final SignupOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel,
                signupViewModel, loginViewModel);
        final SignupInputBoundary userSignupInteractor = new SignupInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        final SignupController controller = new SignupController(userSignupInteractor);
        signupView.setSignupController(controller);
        return this;
    }
    
    /**
     * Adds Add Ingredient Use Case to the application.
     * @return add ingredient use case
     */
    public AppBuilder addAddIngredientUseCase() {

        final AddIngredientOutputBoundary addIngredientOutputBoundary =
                new AddIngredientPresenter(loggedInViewAddIngredientViewModel,
                        loggedInFridgeViewModel, viewManagerModel);
        final AddIngredientInputBoundary addIngredientInputInteractor =
                new AddIngredientInteractor(userDataAccessObject, addIngredientOutputBoundary, ingredientFactory);

        final AddIngredientController controller = new AddIngredientController(addIngredientInputInteractor);
        loggedInViewAddIngredient.setAddIngredientController(controller);
        return this;
    }

    /**
     * Adds Log In Use Case to the application.
     * @return log in use case
     */
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
    //                new LogoutInteractor((LogoutUserDataAccessInterface) this.userDataAccessObject,
    //                logoutOutputBoundary);
    //
    //        final LogoutController logoutController = new LogoutController(logoutInteractor);
    //        loggedInViewHome.setLogoutController(logoutController);
    //        return this;
    //    }

    /**
     * Adds Tried Recipes Use Case to the application.
     * @return tried recipes use case
     */
    public AppBuilder addTriedRecipesUseCase() {
        TriedRecipesViewModel triedRecipesViewModel = new TriedRecipesViewModel();
        TriedRecipesInteractor interactor = new TriedRecipesInteractor(userDataAccessObject, triedRecipesViewModel);
        this.triedRecipesController = new TriedRecipesController(interactor);

        triedRecipesController.setViewModel(triedRecipesViewModel);
        return this;
    }

    /**
     * Returns Main Application window.
     * @return application window
     */
    public JFrame build() {
        final JFrame application = new JFrame("PantryPal");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setLocationRelativeTo(null);
        application.setMinimumSize(new Dimension(800, 600));

        JScrollPane scrollPane = new JScrollPane(cardPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Disable horizontal scrolling
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Enable vertical scrolling when necessary

        application.add(scrollPane, BorderLayout.CENTER);

        application.setLocationRelativeTo(null);

        viewManagerModel.setState(signupView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }

}
