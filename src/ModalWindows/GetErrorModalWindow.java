package ModalWindows;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class GetErrorModalWindow {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button okButton;

    @FXML
    void initialize() {

        okButton.setOnMouseEntered(event -> okButton.setStyle("-fx-background-color: #808080;"));
        okButton.setOnMouseExited(event -> okButton.setStyle("-fx-background-color: #696969;"));
        okButton.setOnAction(event -> {
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.close();
        });
    }

}
