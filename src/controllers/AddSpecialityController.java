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
import pojo.Speciality;
import pojo.Unemployed;

public class AddSpecialityController implements ToPane{

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
    private TableColumn<Speciality, Integer> idUnempl;

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
    private TextField IdTextAreaButton;

    @FXML
    private TextField companyTextArea;


    @FXML
    void initialize() {
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
}

