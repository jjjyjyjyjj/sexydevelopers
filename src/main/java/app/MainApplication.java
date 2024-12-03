package app;

import javax.swing.JFrame;

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
