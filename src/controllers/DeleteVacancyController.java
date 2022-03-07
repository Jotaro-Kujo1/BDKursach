package controllers;

import database.DataBaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Speciality;
import pojo.Vacancy;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteVacancyController implements ToPane {

    private ObservableList<Vacancy> osList = FXCollections.observableArrayList();

    private List<Vacancy> vacancyList;

    private DataBaseHandler db = new DataBaseHandler();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Vacancy> vacancyTable;

    @FXML
    private TableColumn<Vacancy, Integer> idColumn;

    @FXML
    private TableColumn<Vacancy, Integer> skillColumn;

    @FXML
    private TableColumn<Vacancy, Integer> experienceColumn;

    @FXML
    private TableColumn<Vacancy, Integer> salaryColumn;

    @FXML
    private TableColumn<Vacancy, Integer> numberOfWorkplacesColumn;

    @FXML
    private TableColumn<Vacancy, Integer> privilegesColumn;

    @FXML
    private TableColumn<Vacancy, Integer> officeColumn;

    @FXML
    private TableColumn<Vacancy, Integer> companyColumn;


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
        idColumn.setCellValueFactory(new PropertyValueFactory<Vacancy,Integer>("id"));
        skillColumn.setCellValueFactory(new PropertyValueFactory<Vacancy,Integer>("skill"));
        experienceColumn.setCellValueFactory(new PropertyValueFactory<Vacancy,Integer>("experience"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Vacancy,Integer>("salary"));
        numberOfWorkplacesColumn.setCellValueFactory(new PropertyValueFactory<Vacancy,Integer>("numberOfWorkplaces"));
        privilegesColumn.setCellValueFactory(new PropertyValueFactory<Vacancy,Integer>("privileges"));
        officeColumn.setCellValueFactory(new PropertyValueFactory<Vacancy,Integer>("office"));
        companyColumn.setCellValueFactory(new PropertyValueFactory<Vacancy,Integer>("company"));

        showData();

        deleteButton.setOnMouseEntered(event -> deleteButton.setStyle("-fx-background-color: #808080;"));
        deleteButton.setOnMouseExited(event -> deleteButton.setStyle("-fx-background-color: #696969;"));
        deleteButton.setOnAction(event -> {
            Vacancy vacancy = vacancyTable.getSelectionModel().getSelectedItem();
            db.deleteVacancy(vacancy.getId());
            vacancyList.clear();
            osList.clear();
            try{
                vacancyList = db.readVacancyResultSet();
                for(Vacancy i : vacancyList){
                    osList.add(i);
                }
                vacancyTable.setItems(osList);
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


    }

    private void showData(){
        vacancyList = db.readVacancyResultSet();
        for(Vacancy i: vacancyList){
            osList.add(i);
        }
        vacancyTable.setItems(osList);
    }
}
