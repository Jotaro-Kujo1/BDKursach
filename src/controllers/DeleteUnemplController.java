package controllers;

import database.DataBaseHandler;
import database.UnemplDomain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Unemployed;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteUnemplController implements ToPane {

    private ObservableList<Unemployed> osList = FXCollections.observableArrayList();

    private List<Unemployed> unemplList;

    private UnemplDomain unemployedDomain = new UnemplDomain();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Unemployed> unemplTable;

    @FXML
    private TableColumn<Unemployed, Integer> idColumn;

    @FXML
    private TableColumn<Unemployed, String> surnameColumn;

    @FXML
    private TableColumn<Unemployed, String> nameColumn;

    @FXML
    private TableColumn<Unemployed, String> patronymicColumn;

    @FXML
    private TableColumn<Unemployed, Integer> ageColumn;

    @FXML
    private TableColumn<Unemployed, Integer> gendrColumn;

    @FXML
    private TableColumn<Unemployed, Integer> educationColumn;

    @FXML
    private TableColumn<Unemployed, Integer> expColumn;

    @FXML
    private TableColumn<Unemployed, String> contactsColumn;

    @FXML
    private TableColumn<Unemployed, Integer> countryColumn;

    @FXML
    private TableColumn<Unemployed, Integer> previousEmploymentColumn;

    @FXML
    private TableColumn<Unemployed, String> passportColumn;

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
    private Button deleteButton;


    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Unemployed,Integer>("id"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Unemployed,String>("surname"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Unemployed,String>("name"));
        patronymicColumn.setCellValueFactory(new PropertyValueFactory<Unemployed,String>("patronymic"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<Unemployed,Integer>("age"));
        gendrColumn.setCellValueFactory(new PropertyValueFactory<Unemployed,Integer>("gender"));
        educationColumn.setCellValueFactory(new PropertyValueFactory<Unemployed,Integer>("education"));
        expColumn.setCellValueFactory(new PropertyValueFactory<Unemployed,Integer>("experience"));
        contactsColumn.setCellValueFactory(new PropertyValueFactory<Unemployed,String>("contacts"));
        countryColumn.setCellValueFactory(new PropertyValueFactory<Unemployed,Integer>("country"));
        previousEmploymentColumn.setCellValueFactory(new PropertyValueFactory<Unemployed,Integer>("previousEmployment"));
        passportColumn.setCellValueFactory(new PropertyValueFactory<Unemployed,String>("passport"));

        showData();

        deleteButton.setOnMouseEntered(event -> deleteButton.setStyle("-fx-background-color: #808080;"));
        deleteButton.setOnMouseExited(event -> deleteButton.setStyle("-fx-background-color: #696969;"));
        deleteButton.setOnAction(event -> {
            Unemployed unemployed = unemplTable.getSelectionModel().getSelectedItem();
            unemployedDomain.delete(unemployed.getId());
            unemplList.clear();
            osList.clear();
            try{
                unemplList = unemployedDomain.readResultSet();
                for(Unemployed i : unemplList){
                    osList.add(i);
                }
                unemplTable.setItems(osList);
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
        unemplList = unemployedDomain.readResultSet();
        for(Unemployed i: unemplList){
            osList.add(i);
        }
        unemplTable.setItems(osList);
    }
}