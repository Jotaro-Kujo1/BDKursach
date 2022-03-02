package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import pojo.Vacancy;


import java.net.URL;
import java.util.ResourceBundle;

public class AddVacancyController implements ToPane{
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Vacancy> skillTable;

    @FXML
    private TableColumn<Vacancy, Integer> idColumn;

    @FXML
    private TableColumn<Vacancy, Integer> vacancyColumn;

    @FXML
    private TableColumn<Vacancy, Integer> experienceColumn;

    @FXML
    private TableColumn<Vacancy, Integer> salaryColumn;

    @FXML
    private TableColumn<Vacancy, Integer> numsColumn;

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
    private TextField vacancyTextArea;

    @FXML
    private TextField experienceTextArea;

    @FXML
    private TextField salaryTextArea;

    @FXML
    private TextField numsTextArea;

    @FXML
    private TextField privilegesTextArea;

    @FXML
    private TextField officeTextArea;

    @FXML
    private TextField companyTextArea;


    @FXML
    void initialize() {
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
}
