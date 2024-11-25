package use_case.saveforlater;

public interface SaveForLaterOutputBoundary {
    void prepareSuccessView(SaveForLaterOutputData outputData);

    void prepareFailureView(String errorMessage);
}