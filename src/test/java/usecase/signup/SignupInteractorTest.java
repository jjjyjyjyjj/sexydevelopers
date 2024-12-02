package usecase.signup;

import data_access.FileUserDataAccessObject;
import entity.PantryPalUserFactory;
import entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SignupInteractorTest {

    private File testFile;
    private FileUserDataAccessObject userRepository;

    @BeforeEach
    void setUp() throws IOException {
        testFile = new File("test_signup_users.json");
        userRepository = new FileUserDataAccessObject(testFile.getPath());
    }

    @AfterEach
    void tearDown() {
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    void successTest() {
        SignupInputData inputData = new SignupInputData("Paul", "password", "password");

        SignupOutputBoundary successPresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                assertEquals("Paul", user.getUsername());
                assertTrue(userRepository.existsByName("Paul"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToLoginView() {
            }
        };

        SignupInputBoundary interactor = new SignupInteractor(userRepository, successPresenter, new PantryPalUserFactory());
        interactor.execute(inputData);
    }

    @Test
    void failurePasswordMismatchTest() {
        SignupInputData inputData = new SignupInputData("Paul", "password", "wrong");

        SignupOutputBoundary failurePresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Passwords don't match.", error);
            }

            @Override
            public void switchToLoginView() {
            }
        };

        SignupInputBoundary interactor = new SignupInteractor(userRepository, failurePresenter, new PantryPalUserFactory());
        interactor.execute(inputData);
    }

    @Test
    void failureUserExistsTest() {
        SignupInputData inputData = new SignupInputData("Paul", "password", "password");

        User user = new PantryPalUserFactory().create("Paul", "password");
        userRepository.save(user);

        SignupOutputBoundary failurePresenter = new SignupOutputBoundary() {
            @Override
            public void prepareSuccessView(SignupOutputData user) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("User already exists.", error);
            }

            @Override
            public void switchToLoginView() {
            }
        };

        SignupInputBoundary interactor = new SignupInteractor(userRepository, failurePresenter, new PantryPalUserFactory());
        interactor.execute(inputData);
    }
}
