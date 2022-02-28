package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import database.DataBaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Unemployed;

public class AddUnemplController implements ToPane{

    private ObservableList<Unemployed> osList = FXCollections.observableArrayList();

    private List<Unemployed> unempList;

    private DataBaseHandler db = new DataBaseHandler();

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
                    patronymicTextArea.getText(),Integer.parseInt(ageTextArea.getText()),Integer.parseInt(genderTextArea.getText()),
                    Integer.parseInt(educationTextArea.getText()),Integer.parseInt(experienceTextArea.getText()),contactsTextArea.getText(),
                    Integer.parseInt(countryTextArea.getText()),Integer.parseInt(previousEmploymentTextArea.getText()),passportTextArea.getText());
            db.addUnempl(unemployed);
            unempList.clear();
            osList.clear();
            showData();
            clearTextBox();
        });


        addSpecialityButton.setOnAction(event -> {
            addMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/addSpecialityPane.fxml");
        });

    }

    private void showData(){
        unempList = db.readResultSet();
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
