package controllers;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import ModalWindows.RegModalWindow;
import database.DataBaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RegistrationController {

    private DataBaseHandler db = new DataBaseHandler();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button signInButton;

    @FXML
    private TextField loginTextArea;

    @FXML
    private TextField passwordTextArea;



    @FXML
    void initialize() {
        signInButton.setOnMouseEntered(event -> signInButton.setStyle("-fx-background-color: #808080;"));
        signInButton.setOnMouseExited(event -> signInButton.setStyle("-fx-background-color: #696969;"));
        signInButton.setOnAction(event -> {
            if(db.userRegistration(loginTextArea.getText().trim(), passwordTextArea.getText().trim())){
                //RegModalWindow.newWindow();
                toRegModWindw();
                toMainPane();
            }
        });


        //backButton.setOnMouseEntered(event -> backButton.setStyle("-fx-background-color: #808080;"));
        //backButton.setOnMouseExited(event -> backButton.setStyle("-fx-background-color: #696969;"));
        //backButton.setOnAction(event -> toSignInPane());
    }

    /*
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
*/
    private void toRegModWindw(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../recourses/regModalWindowPane.fxml"));
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

}