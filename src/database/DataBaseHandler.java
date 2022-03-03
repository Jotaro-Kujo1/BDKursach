package database;

import pojo.Company;
import pojo.Country;
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

    public List<Unemployed> readUnemplResultSet(){
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

    public void addUnempl(Unemployed unempl){
        String sqlQuery = "INSERT INTO unemployed VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,unempl.getId());
            statement.setString(2, unempl.getSurname());
            statement.setString(3, unempl.getName());
            statement.setString(4, unempl.getPatronymic());
            statement.setInt(5, unempl.getAge());
            statement.setInt(6, unempl.getGender());
            statement.setInt(7, unempl.getEducation());
            statement.setInt(8, unempl.getExperience());
            statement.setString(9, unempl.getContacts());
            statement.setInt(10, unempl.getCountry());
            statement.setInt(11, unempl.getPreviousEmployment());
            statement.setString(12, unempl.getPassport());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public List<Company> readCompanyResultSet(){
        String sqlQuery = "SELECT * FROM company";
        List<Company> list = new ArrayList<>();
        try(Statement statement = getDbConnection().createStatement()){
            Company company = null;
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                company = new Company(Integer.parseInt(rs.getString("Id")), rs.getString("Компания"));
                list.add(company);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return list;
    }

    public void addCompany(Company company){
        String sqlQuery = "INSERT INTO company VALUES(?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,company.getId());
            statement.setString(2, company.getCompany());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public List<Country> readCountryResultSet(){
        String sqlQuery = "SELECT * FROM country";
        List<Country> list = new ArrayList<>();
        try(Statement statement = getDbConnection().createStatement()){
            Country country = null;
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                country = new Country(Integer.parseInt(rs.getString("Id")), rs.getString("Страна"));
                list.add(country);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return list;
    }

    public void addCountry(Country country){
        String sqlQuery = "INSERT INTO country VALUES(?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,country.getId());
            statement.setString(2, country.getCountry());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

}
