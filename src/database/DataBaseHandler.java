package database;

import java.sql.*;

public class DataBaseHandler {
    private Connection dbConnection;


    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:ucanaccess://C:/Javist/BDKurs/LaborExchange.accdb";//Когда скину на флешку нужно будет сменить путь
        //Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        dbConnection = DriverManager.getConnection(connectionString);
        return dbConnection;
    }

    public boolean userSignIn(String login, String password){
        ResultSet rset = null;
        String sqlQuery = "SELECT * FROM users WHERE Логин =? AND Пароль =?";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setString(1,login);
            statement.setString(2,password);
            rset = statement.executeQuery();
            if(rset.next()) return true;
            else return false;
        }catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

    public boolean userRegistration(String login, String password){
        String sqlQuery = "INSERT INTO users (Логин, Пароль) VALUES(?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setString(1, login);
            statement.setString(2, password);
            statement.execute();
            return true;
        }catch (ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }

}
