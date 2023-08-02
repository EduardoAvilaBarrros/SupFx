package br.com.senac.supfx.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class App {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(
                App.class.getResource("/gui/contas.fxml"));
        stage.setTitle("");
        stage.setScene(new Scene(parent));
        stage.show();
    }
}
