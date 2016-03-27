package com.develorain.application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private static final String TITLE = "Vision Reliever";
    private static final int WIDTH = 600;
    private static final int HEIGHT = 300;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Pane layout = FXMLLoader.load(Main.class.getResource("gui.fxml"));
        stage.setTitle(TITLE);
        stage.setScene(new Scene(layout, WIDTH, HEIGHT));
        stage.setAlwaysOnTop(true);
        stage.show();
        stage.setOnCloseRequest(e -> {
            GUIController.timer.cancel();
            stage.hide();
            Platform.exit();
        });
    }
}
