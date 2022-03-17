package com.example.okeeeeeyletsgo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class AlohaApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(AlohaApplication.class.getResource("list-view.fxml"));
        MainController controller = new ListController();
        fxmlLoader.setController(controller);
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.getIcons().add(new Image("C:\\okeeeeeyletsgo\\src\\main\\resources\\icon.jpg"));
        stage.setTitle("Aloha haircuts dance!(therealyou) Уя");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}