package database;

import pojo.Company;
import pojo.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CompanyDomain extends CrudRepository{

    public <T> void add (T company){
        Company tmp = null;
        if(company instanceof Company) tmp = (Company) company;
        String sqlQuery = "INSERT INTO company VALUES(?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,tmp.getId());
            statement.setString(2, tmp.getCompany());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }



    public void delete (int id){
        String sqlQuery = "DELETE FROM company WHERE Id=" + id;
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public <T> T get (int id){
        String sqlQuery = "SELECT * FROM company WHERE Id='" + id + "'";
        Company company = null;
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            if(rs.next()){
                company = new Company(Integer.parseInt(rs.getString("Id")), rs.getString("Компания"));
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return (T) company;
    }

    public int transformation (String str) {
        String sqlQuery = "SELECT Id FROM company WHERE Компания='" + str + "'";
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
        Company tmp = null;
        List<Company> list = new ArrayList<>();
        String sqlQuery = "SELECT * FROM company";
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                tmp = new Company(Integer.parseInt(rs.getString("Id")), rs.getString("Компания"));
                list.add(tmp);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return (List<T>) list;
    }
}
