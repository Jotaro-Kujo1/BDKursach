package controllers;

import database.DataBaseHandler;
import database.OfficeDomain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Office;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteOfficeController implements ToPane, ToJson {

    private ObservableList<Office> osList = FXCollections.observableArrayList();

    private List<Office> officeList;

    private OfficeDomain officeDomain = new OfficeDomain();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Office> officeTable;

    @FXML
    private TableColumn<Office, Integer> idColumn;

    @FXML
    private TableColumn<Office, String> cityColumn;


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
    private Button deleteButton;


    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Office,Integer>("id"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<Office,String>("city"));

        showData();

        deleteButton.setOnMouseEntered(event -> deleteButton.setStyle("-fx-background-color: #808080;"));
        deleteButton.setOnMouseExited(event -> deleteButton.setStyle("-fx-background-color: #696969;"));
        deleteButton.setOnAction(event -> {
            Office office = officeTable.getSelectionModel().getSelectedItem();
            officeDomain.delete(office.getId());
            officeList.clear();
            osList.clear();
            try{
                officeList = officeDomain.readResultSet();
                for(Office i : officeList){
                    osList.add(i);
                }
                officeTable.setItems(osList);
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
        officeList = officeDomain.readResultSet();
        for(Office i: officeList){
            osList.add(i);
        }
        officeTable.setItems(osList);
    }
}
