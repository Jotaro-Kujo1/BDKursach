package controllers;

import java.math.BigInteger;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import database.DataBaseHandler;
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


public class AddSpecialityController implements ToPane{

    private ObservableList<Speciality> osList = FXCollections.observableArrayList();

    private List<Speciality> specialityList;

    private DataBaseHandler db = new DataBaseHandler();

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
            Speciality speciality = new Speciality(Integer.parseInt(IdTextArea.getText()),Integer.parseInt(specialityTextArea.getText()),Integer.parseInt(salaryTextArea.getText()),Integer.parseInt(personTextArea.getText()));
            db.addSpeciality(speciality);
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
    }

    private void showData(){
        specialityList = db.readSpecialityResultSet();
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

