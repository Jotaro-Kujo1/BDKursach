package ModalWindows;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;

public class RegModalWindow {

    public static void newWindow(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        Pane pane = new Pane();


        Button btn = new Button("Закрыть");
        btn.setOnAction(event -> window.close());

        pane.getChildren().add(btn);
        Scene scene = new Scene(pane,100,100);
        window.setScene(scene);
        window.showAndWait();
    }
}
