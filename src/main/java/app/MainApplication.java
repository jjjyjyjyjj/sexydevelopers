package app;

import java.io.File;
import javax.swing.*;

/**
 * Code to run the Application.
 */
public class MainApplication {
    /**
     * Initializing the application.
     * @param args input
     */
    public static void main(String[] args) {
        final AppBuilder appBuilder = new AppBuilder();

        final JFrame application = appBuilder
                .addSignupView()
                .addLoginView()
                .addLoggedInView()
                .addSignupUseCase()
                .addLoginUseCase()
                .addViews()
                .build();
        application.setVisible(true);
    }
}
