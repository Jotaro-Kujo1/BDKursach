package database;

import pojo.Skill;
import pojo.Speciality;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SpecialityDomain extends CrudRepository{

    public <T> void add (T speciality){
        Speciality tmp = null;
        if(speciality instanceof Speciality) tmp = (Speciality) speciality;
        String sqlQuery = "INSERT INTO speciality VALUES(?,?,?,?)";
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.setInt(1,tmp.getId());
            statement.setInt(2, tmp.getSpeciality());
            statement.setInt(3,tmp.getSalary());
            statement.setInt(4, tmp.getPerson());
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void delete (int id){
        String sqlQuery = "DELETE FROM speciality WHERE Id=" + id;
        try(PreparedStatement statement = getDbConnection().prepareStatement(sqlQuery)){
            statement.execute();
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public <T> T get (int id){
        String sqlQuery = "SELECT * FROM speciality WHERE Id='" + id + "'";
        Speciality speciality = null;
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            if(rs.next()){
                speciality = new Speciality(Integer.parseInt(rs.getString("Id")), Integer.parseInt(rs.getString("Специальность")),Integer.parseInt(rs.getString("Зарплата")),Integer.parseInt(rs.getString("Человек")));
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return (T) speciality;
    }

    public int transformation (String str) {
        String sqlQuery = "SELECT Id FROM skills WHERE Умение='" + str + "'";
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
        Speciality speciality = null;
        List<Speciality> list = new ArrayList<>();
        String sqlQuery = "SELECT * FROM speciality";
        try(Statement statement = getDbConnection().createStatement()){
            ResultSet rs = statement.executeQuery(sqlQuery);
            while(rs.next()){
                speciality = new Speciality(Integer.parseInt(rs.getString("Id")), Integer.parseInt(rs.getString("Специальность")),Integer.parseInt(rs.getString("Зарплата")),Integer.parseInt(rs.getString("Человек")));
                list.add(speciality);
            }
        }catch (SQLException | ClassNotFoundException ex){
            ex.printStackTrace();
        }
        return (List<T>) list;
    }
}
