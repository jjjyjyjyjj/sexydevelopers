package app;

import javax.swing.*;
import java.io.File;

public class MainApplication {
    public static void main(String[] args) {
        final AppBuilder appBuilder = new AppBuilder();

        final JFrame application = appBuilder
                .addSignupView()
                .addLoginView()
                .addLoggedInView()
                .addLoggedInStateListener()
                .addSignupUseCase()
                .addLoginUseCase()
                .addViews()
                .build();
        application.setVisible(true);
    }
}
