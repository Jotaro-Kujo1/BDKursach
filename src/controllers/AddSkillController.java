package controllers;

import database.DataBaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Country;
import pojo.Education;
import pojo.Skill;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddSkillController implements ToPane{

    private ObservableList<Skill> osList = FXCollections.observableArrayList();

    private List<Skill> skillList;

    private DataBaseHandler db = new DataBaseHandler();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Skill> skillTable;

    @FXML
    private TableColumn<Skill, Integer> idColumn;

    @FXML
    private TableColumn<Skill, String> skillColumn;



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
    private MenuButton getMainButton;

    @FXML
    private MenuItem getUnempButton;

    @FXML
    private MenuItem getSpecialityButton;

    @FXML
    private MenuItem getSkillButton;

    @FXML
    private MenuItem getVacancyButton;

    @FXML
    private MenuItem getOfficeButton;

    @FXML
    private MenuItem getCountryButton;

    @FXML
    private MenuItem getEducationButton;

    @FXML
    private MenuItem getCompanyButton;

    @FXML
    private Button addButton;

    @FXML
    private TextField IdTextArea;

    @FXML
    private TextField skillTextArea;



    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Skill,Integer>("id"));
        skillColumn.setCellValueFactory(new PropertyValueFactory<Skill,String>("skill"));

        showData();

        addButton.setOnMouseEntered(event -> addButton.setStyle("-fx-background-color: #808080;"));
        addButton.setOnMouseExited(event -> addButton.setStyle("-fx-background-color: #696969;"));
        addButton.setOnAction( event -> {
            Skill skill = new Skill(Integer.parseInt(IdTextArea.getText()),skillTextArea.getText());
            db.addSkill(skill);
            skillList.clear();
            osList.clear();
            showData();
            clearTextBox();
        });

        addUnempButton.setOnAction(event -> {
            addMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/addUnemplPane.fxml");
        });
        addSpecialityButton.setOnAction(event -> {
            addMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/addSpecialityPane.fxml");
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
        deleteEducationButton.setOnAction(event -> {
            deleteMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/deleteEducationPane.fxml");
        });
        deleteCompanyButton.setOnAction(event -> {
            deleteMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/deleteCompanyPane.fxml");
        });
        getUnempButton.setOnAction(event -> {
            getMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/getUnemplPane.fxml");
        });
        getSpecialityButton.setOnAction(event -> {
            getMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/getSpecialityPane.fxml");
        });
        getSkillButton.setOnAction(event -> {
            getMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/getSkillPane.fxml");
        });
        getVacancyButton.setOnAction(event -> {
            getMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/getVacancyPane.fxml");
        });
        getOfficeButton.setOnAction(event -> {
            getMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/getOfficePane.fxml");
        });
        getCountryButton.setOnAction(event -> {
            getMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/getCountryPane.fxml");
        });
        getEducationButton.setOnAction(event -> {
            getMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/getEducationPane.fxml");
        });
        getCompanyButton.setOnAction(event -> {
            getMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/getCompanyPane.fxml");
        });
    }

    private void showData(){
        skillList = db.readSkillResultSet();
        for(Skill i: skillList){
            osList.add(i);
        }
        skillTable.setItems(osList);
    }

    private void clearTextBox(){
        IdTextArea.clear();
        skillTextArea.clear();
    }
}