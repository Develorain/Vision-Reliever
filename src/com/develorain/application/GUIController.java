package com.develorain.application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class GUIController implements Initializable {
    private Media media;
    private MediaPlayer mediaPlayer;
    private Timer timer;
    private TimerTask timerTask;
    private long notificationTime = 10 * 1000;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    public void comboBoxClicked() {
        notificationTime = Long.parseLong(comboBox.getValue()) * 1000;
        mediaPlayer.stop();
        timerTask.cancel();
        initTimerTask();
    }

    @Override
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String path = Main.class.getResource("haze.wav").toString();
        media = new Media(path);
        mediaPlayer = new MediaPlayer(media);
        timer = new Timer();

        initTimerTask();

        ObservableList<String> options = FXCollections.observableArrayList(
                "20", "40", "60"
        );

        comboBox.setItems(options);
    }

    private void initTimerTask() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                mediaPlayer.stop();
                mediaPlayer.play();
            }
        };

        timer.scheduleAtFixedRate(timerTask, notificationTime, notificationTime);
    }
}
