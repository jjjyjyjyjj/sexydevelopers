package use_case.recipe_recommender;

public interface RecipeRecOutputBoundary {
    void prepareSuccessView(RecipeRecOutputData outputData);

    void prepareFailView(String errorMessage);

}

