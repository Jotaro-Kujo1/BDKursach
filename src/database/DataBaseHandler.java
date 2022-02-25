package database;

import pojo.Unemployed;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Unemployed> readResultSet(){
        String sqlQuery = "SELECT * FROM unemployed";
        List<Unemployed> list = new ArrayList<>();
        try(Statement statement = getDbConnection().createStatement()){
            Unemployed up = null;
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                up = new Unemployed(Integer.parseInt(rs.getString("Id")),rs.getString("Фамилия"),rs.getString("Имя"),rs.getString("Отчество"),Integer.parseInt(rs.getString("Возраст")),
                        Integer.parseInt(rs.getString("Пол")),Integer.parseInt(rs.getString("Образование")), Integer.parseInt(rs.getString("Опыт")), rs.getString("Контакты"), Integer.parseInt(rs.getString("Страна")),
                        Integer.parseInt(rs.getString("Предыдущее место работы")),rs.getString("Паспорт"));
                list.add(up);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return list;
    }


}
