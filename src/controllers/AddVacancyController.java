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

public class AddVacancyController implements ToPane{

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
    private Button addButton;

    @FXML
    private TextField IdTextArea;

    @FXML
    private TextField skillTextArea;

    @FXML
    private TextField experienceTextArea;

    @FXML
    private TextField salaryTextArea;

    @FXML
    private TextField numberOfWorkplacesTextArea;

    @FXML
    private TextField privilegesTextArea;

    @FXML
    private TextField officeTextArea;

    @FXML
    private TextField companyTextArea;


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

        addButton.setOnMouseEntered(event -> addButton.setStyle("-fx-background-color: #808080;"));
        addButton.setOnMouseExited(event -> addButton.setStyle("-fx-background-color: #696969;"));
        addButton.setOnAction( event -> {
            Vacancy vacancy = new Vacancy(Integer.parseInt(IdTextArea.getText()),Integer.parseInt(skillTextArea.getText()),Integer.parseInt(experienceTextArea.getText()),Integer.parseInt(salaryTextArea.getText()),
                    Integer.parseInt(numberOfWorkplacesTextArea.getText()),Integer.parseInt(privilegesTextArea.getText()),Integer.parseInt(officeTextArea.getText()),Integer.parseInt(companyTextArea.getText()));
            db.addVacancy(vacancy);
            vacancyList.clear();
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
        addSkillButton.setOnAction(event -> {
            addMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/addSkillPane.fxml");
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
    }

    private void showData(){
        vacancyList = db.readVacancyResultSet();
        for(Vacancy i: vacancyList){
            osList.add(i);
        }
        vacancyTable.setItems(osList);
    }

    private void clearTextBox(){
        IdTextArea.clear();
        skillTextArea.clear();
        experienceTextArea.clear();
        salaryTextArea.clear();
        numberOfWorkplacesTextArea.clear();
        privilegesTextArea.clear();
        officeTextArea.clear();
        officeTextArea.clear();
    }
}
