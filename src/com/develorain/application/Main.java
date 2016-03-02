package com.develorain.application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {
    private static final String TITLE = "Vision Reliever";
    private static final int WIDTH = 600;
    private static final int HEIGHT = 300;
    private Pane layout;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            layout = FXMLLoader.load(Main.class.getResource("gui.fxml"));
            primaryStage.setTitle(TITLE);
            primaryStage.setScene(new Scene(layout, WIDTH, HEIGHT));
            primaryStage.setOnCloseRequest(e -> {
                Platform.exit();
            });
            primaryStage.setAlwaysOnTop(true);
            primaryStage.show();
        } catch (Exception e) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
