package controllers;

import database.DataBaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Education;


import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteEducationController implements ToPane {

    private ObservableList<Education> osList = FXCollections.observableArrayList();

    private List<Education> educationList;

    private DataBaseHandler db = new DataBaseHandler();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Education> educationTable;

    @FXML
    private TableColumn<Education, Integer> idColumn;

    @FXML
    private TableColumn<Education, String> educationColumn;


    @FXML
    private MenuButton addMainButton;

    @FXML
    private MenuItem addUnempButton;

    @FXML
    private MenuItem addSpecialityButton;

    @FXML
    private MenuItem addSkillButton;

    @FXML
    private MenuItem addVacancyButton;

    @FXML
    private MenuItem addOfficeButton;

    @FXML
    private MenuItem addCountryButton;

    @FXML
    private MenuItem addEducationButton;

    @FXML
    private MenuItem addCompanyButton;

    @FXML
    private MenuButton deleteMainButton;

    @FXML
    private MenuItem deleteUnempButton;

    @FXML
    private MenuItem deleteSpecialityButton;

    @FXML
    private MenuItem deleteSkillButton;

    @FXML
    private MenuItem deleteVacancyButton;

    @FXML
    private MenuItem deleteOfficeButton;

    @FXML
    private MenuItem deleteCountryButton;

    @FXML
    private MenuItem deleteEducationButton;

    @FXML
    private MenuItem deleteCompanyButton;

    @FXML
    private Button deleteButton;


    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Education,Integer>("id"));
        educationColumn.setCellValueFactory(new PropertyValueFactory<Education,String>("education"));

        showData();

        deleteButton.setOnMouseEntered(event -> deleteButton.setStyle("-fx-background-color: #808080;"));
        deleteButton.setOnMouseExited(event -> deleteButton.setStyle("-fx-background-color: #696969;"));
        deleteButton.setOnAction(event -> {
            Education education = educationTable.getSelectionModel().getSelectedItem();
            db.deleteEducation(education.getId());
            educationList.clear();
            osList.clear();
            try{
                educationList = db.readEducationResultSet();
                for(Education i : educationList){
                    osList.add(i);
                }
                educationTable.setItems(osList);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        });


        addUnempButton.setOnAction(event -> {
            addMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/addUnemplPane.fxml");
        });
        addSpecialityButton.setOnAction(event -> {
            addMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/addSpecialityPane.fxml");
        });
        addSkillButton.setOnAction(event -> {
            addMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/addSkillPane.fxml");
        });
        addVacancyButton.setOnAction(event -> {
            addMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/addVacancyPane.fxml");
        });
        addOfficeButton.setOnAction(event -> {
            addMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/addOfficePane.fxml");
        });
        addCountryButton.setOnAction(event -> {
            addMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/addCountryPane.fxml");
        });
        addEducationButton.setOnAction(event -> {
            addMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/addEducationPane.fxml");
        });
        addCompanyButton.setOnAction(event -> {
            addMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/addCompanyPane.fxml");
        });

        deleteUnempButton.setOnAction(event -> {
            deleteMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/deleteUnemplPane.fxml");
        });
        deleteSpecialityButton.setOnAction(event -> {
            deleteMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/deleteSpecialityPane.fxml");
        });
        deleteSkillButton.setOnAction(event -> {
            deleteMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/deleteSkillPane.fxml");
        });
        deleteVacancyButton.setOnAction(event -> {
            deleteMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/deleteVacancyPane.fxml");
        });
        deleteOfficeButton.setOnAction(event -> {
            deleteMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/deleteOfficePane.fxml");
        });
        deleteCountryButton.setOnAction(event -> {
            deleteMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/deleteCountryPane.fxml");
        });

        deleteCompanyButton.setOnAction(event -> {
            deleteMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/deleteCompanyPane.fxml");
        });


    }

    private void showData(){
        educationList = db.readEducationResultSet();
        for(Education i: educationList){
            osList.add(i);
        }
        educationTable.setItems(osList);
    }
}