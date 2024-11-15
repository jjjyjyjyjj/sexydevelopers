package use_case.favourite_recipe;

import entity.User;
import entity.UserFactory;

/**
 * The Favourite Recipes Interactor.
 */
public class FavouriteRecipesInteractor implements FavouriteRecipesInputBoundary {
    private final FavouriteRecipesUserDataAccessInterface userDataAccessObject;
    private final FavouriteRecipesOutputBoundary userPresenter;
    private final UserFactory userFactory;

    public FavouriteRecipesInteractor(FavouriteRecipesUserDataAccessInterface favouriteRecipesDataAccessInterface,
                                      FavouriteRecipesOutputBoundary favouriteRecipesOutputBoundary,
                                      UserFactory userFactory) {
        this.userDataAccessObject = favouriteRecipesDataAccessInterface;
        this.userPresenter = favouriteRecipesOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(FavouriteRecipesInputData favouriteRecipesInputData) {
        final User user = userFactory.create(FavouriteRecipesInputData.getUsername(),
                FavouriteRecipesInputData.getPassword());
        userDataAccessObject.changePassword(user);

        final FavouriteRecipesOutputData favouriteRecipesOutputData = new FavouriteRecipesOutputData(user.getName(),
                false);
        userPresenter.prepareSuccessView(favouriteRecipesOutputData);
    }
}