package use_case.add_ingredient;
import entity.Fridge;
import entity.Ingredient;
import entity.User;

public class AddIngredientInteractor implements AddIngredientInputBoundary{
    private final AddIngredientDataAccessInterface addIngredientUserDataAccessInterface;
    private final AddIngredientOutputBoundary addIngredientOutputBoundary;

    public AddIngredientInteractor(AddIngredientDataAccessInterface addIngredientUserDataAccessInterface,
                                   AddIngredientOutputBoundary addIngredientOutputBoundary) {
        this.addIngredientUserDataAccessInterface = addIngredientUserDataAccessInterface;
        this.addIngredientOutputBoundary = addIngredientOutputBoundary;
    }

    @Override
    public void execute(AddIngredientInputData addIngredientInputData){
        Fridge fridge = addIngredientInputData.getFridge();
        Ingredient toAddIngredient = addIngredientInputData.getIngredient();

        fridge.addIngredient(toAddIngredient);
        addIngredientUserDataAccessInterface.addIngredient(fridge, toAddIngredient);

        final AddIngredientOutputData addIngredientOutputData = new AddIngredientOutputData(fridge, false);

        addIngredientOutputBoundary.prepareSuccessView(addIngredientOutputData);
    }
}
