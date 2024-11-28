package use_case.change_quantity;
import entity.Fridge;
import entity.Ingredient;
import entity.User;
import use_case.add_ingredient.*;

public class ChangeQuantityInteractor implements ChangeQuantityInputBoundary {
    private final ChangeQuantityDataAccessInterface changeQuantityUserDataAccessInterface;
    private final ChangeQuantityOutputBoundary changeQuantityOutputBoundary;

    public ChangeQuantityInteractor(ChangeQuantityDataAccessInterface changeQuantityUserDataAccessInterface,
                                    ChangeQuantityOutputBoundary changeQuantityOutputBoundary) {
        this.changeQuantityUserDataAccessInterface = changeQuantityUserDataAccessInterface;
        this.changeQuantityOutputBoundary = changeQuantityOutputBoundary;
    }

    @Override
    public void execute(ChangeQuantityInputData changeQuantityInputData){
        Double amount = changeQuantityInputData.getAmount();
        Ingredient toChangeIngredient = changeQuantityInputData.getIngredient();

        Double previousQuantity = toChangeIngredient.getQuantity();
        toChangeIngredient.setQuantity(previousQuantity + amount);
        changeQuantityUserDataAccessInterface.changeQuantity(amount, toChangeIngredient);

        final ChangeQuantityOutputData changeQuantityOutputData = new ChangeQuantityOutputData(toChangeIngredient, false);

        changeQuantityOutputBoundary.prepareSuccessView(changeQuantityOutputData);
    }
}
