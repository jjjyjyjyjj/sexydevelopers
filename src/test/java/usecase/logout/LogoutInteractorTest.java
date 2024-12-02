package usecase.logout;

import data_access.FileUserDataAccessObject;
import entity.PantryPalUserFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LogoutInteractorTest {

    private File testFile;
    private FileUserDataAccessObject userRepository;

    @BeforeEach
    void setUp() throws IOException {
        testFile = new File("test_logout_users.json");
        userRepository = new FileUserDataAccessObject(testFile.getPath());

        userRepository.save(new PantryPalUserFactory().create("Paul", "password"));
        userRepository.setCurrentUsername("Paul");
    }

    @AfterEach
    void tearDown() {
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    void successTest() {
        LogoutInputData inputData = new LogoutInputData("Paul");

        LogoutOutputBoundary successPresenter = new LogoutOutputBoundary() {
            @Override
            public void prepareSuccessView(LogoutOutputData user) {
                assertEquals("Paul", user.getUsername());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        LogoutInputBoundary interactor = new LogoutInteractor(userRepository, successPresenter);
        interactor.execute(inputData);

        assertNull(userRepository.getCurrentUsername());
    }
}
