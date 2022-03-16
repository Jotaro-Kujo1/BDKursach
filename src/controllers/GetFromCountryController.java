package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import database.CountryDomain;
import database.UnemplDomain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Country;
import pojo.Unemployed;

public class GetFromCountryController implements ToGetError{

    private CountryDomain countryDomain = new CountryDomain();
    private UnemplDomain unemplDomain = new UnemplDomain();
    private ObservableList<Unemployed> osList = FXCollections.observableArrayList();
    private List<Unemployed> unemployedList;

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

    @FXML
    private MenuItem getPeopleForSpeciality;

    @FXML
    private MenuItem getSpecialityForPeople;

    @FXML
    private MenuItem getVacancyAndPeopleMatch;

    @FXML
    private Button getButton;

    @FXML
    private TextField countryTextArea;

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



        getButton.setOnMouseEntered(event -> getButton.setStyle("-fx-background-color: #808080;"));
        getButton.setOnMouseExited(event -> getButton.setStyle("-fx-background-color: #696969;"));
        getButton.setOnAction(event -> {
            unemployedList = unemplDomain.getPeopleForCountry(countryDomain.transformation(countryTextArea.getText()));
            if(unemployedList.size()!=0) {
                for (Unemployed i : unemployedList) {
                    osList.add(i);
                    unemplTable.setItems(osList);
                }
            }else toGerErrorModWindw();
            countryTextArea.clear();
        });
    }
}
