package controllers;

import java.math.BigInteger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pojo.Unemployed;

public class AddSpecialityController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Unemployed> unemplTable;

    @FXML
    private TableColumn<Unemployed, Integer> idColumn;

    @FXML
    private TableColumn<Unemployed, Integer> specialityColumn;

    @FXML
    private TableColumn<Unemployed, Integer> salaryColumn;

    @FXML
    private TableColumn<Unemployed, Integer> idUnempl;

    @FXML
    private MenuButton addMainButton;

    @FXML
    private MenuItem addUnempButton;

    @FXML
    private MenuItem addSpeciality;

    @FXML
    private MenuItem addSkill;

    @FXML
    private MenuItem addVacancy;

    @FXML
    private MenuItem addOffice;

    @FXML
    private MenuItem addCountry;

    @FXML
    private MenuItem addEducation;

    @FXML
    private MenuItem addCompany;

    @FXML
    private Button addButton;

    @FXML
    private TextField IdTextArea;

    @FXML
    private TextField specialityTextArea;

    @FXML
    private TextField salaryTextArea;

    @FXML
    private TextField idUnemplTextArea;

    @FXML
    void initialize() {

    }
}

