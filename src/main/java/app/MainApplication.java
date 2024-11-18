package app;

import javax.swing.*;

public class MainApplication {
    public static void main(String[] args) {
        final AppBuilder appBuilder = new AppBuilder();

        final JFrame application = appBuilder
                .addSignupView()
                .addLoginView()
                .addLoggedInView()
                .addSignupUseCase()
                .addLogoutUseCase()
                .addLoginUseCase()
                .addChangePasswordUseCase()
                .build();
        application.pack();
        application.setVisible(true);
    }
}
