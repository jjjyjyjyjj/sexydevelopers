package app;

import javax.swing.*;
import java.io.File;

public class MainApplication {
    public static void main(String[] args) {
        final AppBuilder appBuilder = new AppBuilder();

        final JFrame application = appBuilder
                .addSignupView()
                .addLoginView()
                .addHomeView()
                .addSavedForLaterView()
                .addSignupUseCase()
                .addLoginUseCase()
                .build();
        application.pack();
        application.setVisible(true);
    }
}
