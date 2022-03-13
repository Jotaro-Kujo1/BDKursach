package database;

import pojo.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDomain extends CrudRepository{


    public <T> void add (T country){
        Country tmp = null;
        if(country instanceof Country) tmp = (Country) country;
        String sqlQuery = "INSERT INTO country VALUES(?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,tmp.getId());
            statement.setString(2, tmp.getCountry());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }



    public void delete (int id){
        String sqlQuery = "DELETE FROM country WHERE Id=" + id;
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public <T> T get (int id){
        String sqlQuery = "SELECT * FROM country WHERE Id='" + id + "'";
        Country country = null;
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            if(rs.next()){
                country = new Country(Integer.parseInt(rs.getString("Id")), rs.getString("Страна"));
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return (T) country;
    }

    public int transformation (String str) {
        String sqlQuery = "SELECT Id FROM country WHERE Страна='" + str + "'";
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            if(rs.next()){
                return Integer.parseInt(rs.getString("Id"));
            }
            return 0;
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
            return 0;
        }
    }

    public <T> List<T> readResultSet () {
        Country tmp = null;
        List<Country> list = new ArrayList<>();
        String sqlQuery = "SELECT * FROM country";

        try (Statement statement = getDbConnection().createStatement()) {
            //Country country = null;
            ResultSet rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                tmp = new Country(Integer.parseInt(rs.getString("Id")), rs.getString("Страна"));
                list.add(tmp);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return (List<T>) list;
    }

}

