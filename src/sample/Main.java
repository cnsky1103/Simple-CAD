package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import Stage.MainStage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        new MainStage();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
