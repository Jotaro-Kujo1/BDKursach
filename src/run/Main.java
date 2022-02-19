package run;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../recourses/signInPane.fxml"));
        stage.setTitle("Labour exchange data base");
        stage.setScene(new Scene(root,600,400));//Сменить после смены размеров окна
        stage.show();
    }
}
