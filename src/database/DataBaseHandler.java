package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseHandler {
    private Connection dbConnection;


    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:ucanaccess://C:/Javist/BDKurs/LaborExchange.accdb";//Когда скину на флешку нужно будет сменить путь
        try {
            //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            dbConnection = DriverManager.getConnection(connectionString);
            System.out.println("yessssssssss");
        }catch (Exception ex){
            System.out.println("nooooooo");
        }
        return dbConnection;
    }
}
