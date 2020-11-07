package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BallPane pane = new BallPane();
        pane.setOnMousePressed(e -> pane.pause());
        pane.setOnMouseReleased(e -> pane.play());

        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                pane.increaseSpeed();
            } else if (e.getCode() == KeyCode.DOWN) {
                pane.decreaseSpeed();
            }
        });

        Scene scene = new Scene(pane, 250, 150);

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
