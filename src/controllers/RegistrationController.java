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
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RegistrationController implements ToPane{


    private DataBaseHandler db = new DataBaseHandler();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    protected Button signInButton;

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
                toRegModWindw();
                Stage stage = (Stage) signInButton.getScene().getWindow();
                stage.close();
                toMainPane();
            }
        });
    }


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
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

}