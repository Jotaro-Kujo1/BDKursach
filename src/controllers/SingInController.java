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

public class SingInController {

    private DataBaseHandler db = new DataBaseHandler();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button signInButton;

    @FXML
    private Button regButton;

    @FXML
    private TextField loginTextArea;

    @FXML
    private PasswordField passwordTextArea;

    @FXML
    void initialize() {
        signInButton.setOnMouseEntered(event -> signInButton.setStyle("-fx-background-color: #808080;"));
        signInButton.setOnMouseExited(event -> signInButton.setStyle("-fx-background-color: #696969;"));
        signInButton.setOnAction(event -> {
            if(db.userSignIn(loginTextArea.getText().trim(),passwordTextArea.getText().trim())) toMainPane();
        });


        regButton.setOnMouseEntered(event -> regButton.setStyle("-fx-background-color: #808080;"));
        regButton.setOnMouseExited(event -> regButton.setStyle("-fx-background-color: #696969;"));
        regButton.setOnAction(event -> toRegPane());

    }

    private void toMainPane(){
        signInButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../recourses/mainPane.fxml"));
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

    private void toRegPane(){
        regButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../recourses/registrationPane.fxml"));
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