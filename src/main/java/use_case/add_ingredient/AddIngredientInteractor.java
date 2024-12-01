package use_case.add_ingredient;
import entity.Fridge;
import entity.Ingredient;
import entity.IngredientFactory;
import entity.User;

public class AddIngredientInteractor implements AddIngredientInputBoundary{
    private final AddIngredientDataAccessInterface addIngredientDataAccessInterface;
    private final AddIngredientOutputBoundary addIngredientOutputBoundary;
    private final IngredientFactory ingredientFactory;

    public AddIngredientInteractor(AddIngredientDataAccessInterface addIngredientDataAccessInterface,
                                   AddIngredientOutputBoundary addIngredientOutputBoundary,
                                   IngredientFactory ingredientFactory) {
        this.addIngredientDataAccessInterface = addIngredientDataAccessInterface;
        this.addIngredientOutputBoundary = addIngredientOutputBoundary;
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void execute(AddIngredientInputData addIngredientInputData){
        Fridge fridge = addIngredientInputData.getFridge();
        Ingredient toAddIngredient = IngredientFactory.create(addIngredientInputData.getName(),
                addIngredientInputData.getUnit(), addIngredientInputData.getQuantity());

        if (!fridge.hasIngredient(toAddIngredient)){
            addIngredientOutputBoundary.prepareFailView("this ingredient already exists");
        }
        else {
            addIngredientDataAccessInterface.addIngredient(fridge, toAddIngredient);
            final AddIngredientOutputData addIngredientOutputData
                    = new AddIngredientOutputData(fridge, false);
            addIngredientOutputBoundary.prepareSuccessView(addIngredientOutputData);
        }
    }
}
