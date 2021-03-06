package controllers;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import database.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Unemployed;

public class AddUnemplController implements ToPane, ToJson{

    private ObservableList<Unemployed> osList = FXCollections.observableArrayList();

    private List<Unemployed> unempList;

    private DataBaseHandler db = new DataBaseHandler();

    private CountryDomain countryDomain = new CountryDomain();

    private CompanyDomain companyDomain = new CompanyDomain();

    private EducationDomain educationDomain = new EducationDomain();

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
    private MenuButton customMainButton;

    @FXML
    private MenuItem getFromCountry;

    @FXML
    private MenuItem getWithEducation;

    @FXML
    private MenuItem getSomeAge;

    @FXML
    private MenuItem getPeopleForGender;

    //@FXML
    //private MenuItem getPeopleForSpeciality;

    @FXML
    private MenuItem getSpecialityForPeople;

    @FXML
    private MenuItem getJSON;

    //@FXML
    //private MenuItem getVacancyAndPeopleMatch;

    @FXML
    private TextField IdTextArea;

    @FXML
    private TextField surnameTextArea;

    @FXML
    private TextField ageTextArea;

    @FXML
    private TextField genderTextArea;

    @FXML
    private TextField contactsTextArea;

    @FXML
    private TextField experienceTextArea;

    @FXML
    private TextField nameTextArea;

    @FXML
    private TextField patronymicTextArea;

    @FXML
    private TextField passportTextArea;

    @FXML
    private TextField previousEmploymentTextArea;

    @FXML
    private TextField countryTextArea;

    @FXML
    private TextField educationTextArea;

    @FXML
    private Button addButton;

    @FXML
    private Button JSONButton;

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

        addButton.setOnMouseEntered(event -> addButton.setStyle("-fx-background-color: #808080;"));
        addButton.setOnMouseExited(event -> addButton.setStyle("-fx-background-color: #696969;"));
        addButton.setOnAction(event -> {

            Unemployed unemployed = new Unemployed(Integer.parseInt(IdTextArea.getText()),surnameTextArea.getText(),nameTextArea.getText(),
                    patronymicTextArea.getText(),Integer.parseInt(ageTextArea.getText()),db.genderTransformation(genderTextArea.getText()),
                    educationDomain.transformation(educationTextArea.getText()),Integer.parseInt(experienceTextArea.getText()),contactsTextArea.getText(),
                    countryDomain.transformation(countryTextArea.getText()),companyDomain.transformation(previousEmploymentTextArea.getText()),passportTextArea.getText());
            unemployedDomain.add(unemployed);
            unempList.clear();
            osList.clear();
            showData();
            clearTextBox();
        });

        JSONButton.setOnMouseEntered(event -> JSONButton.setStyle("-fx-background-color: #808080;"));
        JSONButton.setOnMouseExited(event -> JSONButton.setStyle("-fx-background-color: #696969;"));
        JSONButton.setOnAction(event -> {
            try {
                Runtime.getRuntime().exec("C:\\Javist\\BDKurs\\Util\\Utility\\Utility\\bin\\Debug\\netcoreapp3.1\\Utility.exe");
            }catch (IOException ex){
                ex.printStackTrace();
            }
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
        getFromCountry.setOnAction(event -> {
            customMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/getFromCountryPane.fxml");
        });
        getWithEducation.setOnAction(event -> {
            customMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/getWithEducationPane.fxml");
        });
        getSomeAge.setOnAction(event -> {
            customMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/getSomeAgePane.fxml");
        });
        getPeopleForGender.setOnAction(event -> {
            customMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/getPeopleForGenderPane.fxml");
        });
        /*
        getPeopleForSpeciality.setOnAction(event -> {
            customMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/getPeopleForSpecialityPane.fxml");
        });

         */
        getSpecialityForPeople.setOnAction(event -> {
            customMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/getSpecialityForPeoplePane.fxml");
        });
        getJSON.setOnAction(event -> {
            try {
                Runtime.getRuntime().exec("C:\\Javist\\BDKurs\\Util\\Utility\\Utility\\bin\\Debug\\netcoreapp3.1\\Utility.exe");
                toGetJsonModWindw();
            }catch (IOException ex){
                ex.printStackTrace();
            }
        });
        /*
        getVacancyAndPeopleMatch.setOnAction(event -> {
            customMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/getVacancyAndPeopleMatchPane.fxml");
        });

         */
    }

    private void showData(){
        unempList = unemployedDomain.readResultSet();
        for(Unemployed i: unempList){
            osList.add(i);
        }
        unemplTable.setItems(osList);
    }

    private void clearTextBox(){
        IdTextArea.clear();
        surnameTextArea.clear();
        ageTextArea.clear();
        genderTextArea.clear();
        contactsTextArea.clear();
        experienceTextArea.clear();
        nameTextArea.clear();
        patronymicTextArea.clear();
        passportTextArea.clear();
        previousEmploymentTextArea.clear();
        countryTextArea.clear();
        educationTextArea.clear();
    }
}

