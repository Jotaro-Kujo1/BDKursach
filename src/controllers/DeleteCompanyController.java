package controllers;

import database.DataBaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Company;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteCompanyController implements ToPane {

    private ObservableList<Company> osList = FXCollections.observableArrayList();

    private List<Company> companyList;

    private DataBaseHandler db = new DataBaseHandler();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Company> companyTable;

    @FXML
    private TableColumn<Company, Integer> idColumn;

    @FXML
    private TableColumn<Company, String> companyColumn;


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
    private Button deleteButton;


    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Company,Integer>("id"));
        companyColumn.setCellValueFactory(new PropertyValueFactory<Company,String>("company"));

        showData();

        deleteButton.setOnMouseEntered(event -> deleteButton.setStyle("-fx-background-color: #808080;"));
        deleteButton.setOnMouseExited(event -> deleteButton.setStyle("-fx-background-color: #696969;"));
        deleteButton.setOnAction(event -> {
            Company company = companyTable.getSelectionModel().getSelectedItem();
            db.deleteCompany(company.getId());
            companyList.clear();
            osList.clear();
            try{
                companyList = db.readCompanyResultSet();
                for(Company i : companyList){
                    osList.add(i);
                }
                companyTable.setItems(osList);
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

    }

    private void showData(){
        companyList = db.readCompanyResultSet();
        for(Company i: companyList){
            osList.add(i);
        }
        companyTable.setItems(osList);
    }
}