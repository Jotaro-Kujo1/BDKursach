package controllers;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import database.DataBaseHandler;
import database.SpecialityDomain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Speciality;


public class AddSpecialityController implements ToPane, ToJson{

    private ObservableList<Speciality> osList = FXCollections.observableArrayList();

    private List<Speciality> specialityList;


    private SpecialityDomain specialityDomain = new SpecialityDomain();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Speciality> specialityTable;

    @FXML
    private TableColumn<Speciality, Integer> idColumn;

    @FXML
    private TableColumn<Speciality, Integer> specialityColumn;

    @FXML
    private TableColumn<Speciality, Integer> salaryColumn;

    @FXML
    private TableColumn<Speciality, Integer> personColumn;

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
    private Button addButton;

    @FXML
    private TextField IdTextArea;

    @FXML
    private TextField specialityTextArea;

    @FXML
    private TextField salaryTextArea;

    @FXML
    private TextField personTextArea;


    @FXML
    void initialize() {

        idColumn.setCellValueFactory(new PropertyValueFactory<Speciality,Integer>("id"));
        specialityColumn.setCellValueFactory(new PropertyValueFactory<Speciality,Integer>("speciality"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Speciality,Integer>("salary"));
        personColumn.setCellValueFactory(new PropertyValueFactory<Speciality,Integer>("person"));

        showData();

        addButton.setOnMouseEntered(event -> addButton.setStyle("-fx-background-color: #808080;"));
        addButton.setOnMouseExited(event -> addButton.setStyle("-fx-background-color: #696969;"));
        addButton.setOnAction( event -> {
            Speciality speciality = new Speciality(Integer.parseInt(IdTextArea.getText()),specialityDomain.transformation(specialityTextArea.getText()),Integer.parseInt(salaryTextArea.getText()),Integer.parseInt(personTextArea.getText()));
            specialityDomain.add(speciality);
            specialityList.clear();
            osList.clear();
            showData();
            clearTextBox();
        });

        addUnempButton.setOnAction(event -> {
            addMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/addUnemplPane.fxml");
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
        specialityList = specialityDomain.readResultSet();
        for(Speciality i: specialityList){
            osList.add(i);
        }
        specialityTable.setItems(osList);
    }

    private void clearTextBox(){
        IdTextArea.clear();
        specialityTextArea.clear();
        salaryTextArea.clear();
        personTextArea.clear();
    }
}

