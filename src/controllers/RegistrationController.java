package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationController {

    private DataBaseHandler db = new DataBaseHandler();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button regButton;

    @FXML
    private TextField loginTextArea;

    @FXML
    private TextField passwordTextArea;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        regButton.setOnAction(event -> {
            db.userRegistration(loginTextArea.getText().trim(), passwordTextArea.getText().trim());
        });

        backButton.setOnAction(event -> toSignInPane());
    }

    private void toSignInPane() {
        backButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../recourses/signInPane.fxml"));
        try{
            loader.load();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}