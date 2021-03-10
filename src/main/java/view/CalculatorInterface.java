package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;

public class CalculatorInterface extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        URL url = new File("src\\main\\java\\view\\sample.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);

        stage.setTitle("Polynomial Calculator");
        Scene scene = new Scene(root, 400, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
