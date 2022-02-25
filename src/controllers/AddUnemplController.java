package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import database.DataBaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import pojo.Unemployed;

public class AddUnemplController {

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

        unempList = db.readResultSet();
        for(Unemployed i: unempList){
            osList.add(i);
        }
        unemplTable.setItems(osList);


    }
}
