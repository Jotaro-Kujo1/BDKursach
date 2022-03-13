package database;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public abstract class CrudRepository {
    private Connection dbConnection;


    protected Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:ucanaccess://C:/Javist/BDKurs/LaborExchange.accdb";//Когда скину на флешку нужно будет сменить путь
        dbConnection = DriverManager.getConnection(connectionString);
        return dbConnection;
    }

    public abstract <T> void add (T essence);

    public abstract <T> void delete (int id);

    public abstract <T> T get (int id);

    public abstract int transformation (String str);

    public abstract <T> List<T> readResultSet ();
}
