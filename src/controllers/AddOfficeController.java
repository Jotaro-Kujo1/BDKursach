package controllers;

import database.DataBaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Country;
import pojo.Education;
import pojo.Office;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddOfficeController implements ToPane{

    private ObservableList<Office> osList = FXCollections.observableArrayList();

    private List<Office> officeList;

    private DataBaseHandler db = new DataBaseHandler();

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
    private Button addButton;

    @FXML
    private TextField IdTextArea;

    @FXML
    private TextField cityTextArea;



    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Office,Integer>("id"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<Office,String>("city"));

        showData();

        addButton.setOnMouseEntered(event -> addButton.setStyle("-fx-background-color: #808080;"));
        addButton.setOnMouseExited(event -> addButton.setStyle("-fx-background-color: #696969;"));
        addButton.setOnAction( event -> {
            Office office = new Office(Integer.parseInt(IdTextArea.getText()),cityTextArea.getText());
            db.addOffice(office);
            officeList.clear();
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
        addVacancyButton.setOnAction(event -> {
            addMainButton.getScene().getWindow().hide();
            toAddPane("../recourses/addVacancyPane.fxml");
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
        officeList = db.readOfficeResultSet();
        for(Office i: officeList){
            osList.add(i);
        }
        officeTable.setItems(osList);
    }

    private void clearTextBox(){
        IdTextArea.clear();
        cityTextArea.clear();
    }
}
